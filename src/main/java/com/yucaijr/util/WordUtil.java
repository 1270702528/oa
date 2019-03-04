package com.yucaijr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;


public class WordUtil {

	/**
	 * 
	 * @param param  需要转化参数
	 * @param fileSrc 模块路径
	 * @param fileDest 生成路径
	 * @param templeSrc 临时转化路径
	 */
	public static void generateWord(Map<String, String> param, String fileSrc, String fileDest,String templeSrc) {
        XWPFDocument doc = null;
        OPCPackage pack = null;
        try {
        	 
        	fileCopyNIO(fileSrc, fileDest);
            pack = POIXMLDocument.openPackage(fileDest);
            doc = new XWPFDocument(pack);
            if (param != null && param.size() > 0) {
                List<XWPFParagraph> paragraphList = doc.getParagraphs();
                processParagraphs(paragraphList, param, doc);
                processTables(param,doc);
                File file = new File(templeSrc);
                FileOutputStream stream = new FileOutputStream(file);
                doc.write(stream);
            }
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	try {
        		
				pack.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

	public static void fileCopyNIO(String source, String target) throws IOException {  
        try (FileInputStream in = new FileInputStream(source)) {  
            try (FileOutputStream out = new FileOutputStream(target)) {  
                FileChannel inChannel = in.getChannel();  
                FileChannel outChannel = out.getChannel();  
                ByteBuffer buffer = ByteBuffer.allocate(4096);  
                while(inChannel.read(buffer) != -1) {  
                    buffer.flip();  
                    outChannel.write(buffer);  
                    buffer.clear();  
                }  
            }  
        }  
    }  
  
    /**
     * 处理段落,替换关键字
     * 
     * @param paragraphList
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     */
    public static void processParagraphs(List<XWPFParagraph> paragraphList, Map<String, String> param, XWPFDocument doc)
            throws InvalidFormatException, FileNotFoundException {
        if (paragraphList != null && paragraphList.size() > 0) {
            for (XWPFParagraph paragraph : paragraphList) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                	//System.out.println("run:"+run);
                    String text = run.getText(0);
                    if (text != null) {
                        boolean isSetText = false;
                        for (Entry<String, String> entry : param.entrySet()) {
                            String key = entry.getKey();
                            if (text.indexOf(key) != -1) {// 在配置文件中有这个关键字对应的键
                                isSetText = true;
                                Object value = entry.getValue();
                                key="#{"+key+"}";
                                if (value instanceof String) {// 文本替换
                                    if (text.contains(key)) {
                                        text = text.replace(key, value.toString());
                                    }
                                }
                            }
                        }
                        if (isSetText) {
                            run.setText(text, 0);
                        }
                    }
                }
            }        
        }
    }
    
    
    public static void processTables( Map<String, String> param, XWPFDocument doc)
            throws InvalidFormatException, FileNotFoundException {
    	
    	 List<XWPFTable> allTable = doc.getTables();
         for (XWPFTable xwpfTable : allTable) {
             //获取表格行数据
             List<XWPFTableRow> rows = xwpfTable.getRows();
             for (XWPFTableRow xwpfTableRow : rows) {
                 //获取表格单元格数据
                 List<XWPFTableCell> cells = xwpfTableRow.getTableCells();
                 for (XWPFTableCell xwpfTableCell : cells) {
                     List<XWPFParagraph> paragraphs = xwpfTableCell.getParagraphs();
                     for (XWPFParagraph xwpfParagraph : paragraphs) {
                         List<XWPFRun> runs = xwpfParagraph.getRuns();
                         for (XWPFRun run : runs) {
                        	 //System.out.println("run:"+run);
                             run.setText(changeValue(run.toString(), param),0);
                         }
                     }
                 }
             }
         }
    }

	private static String changeValue(String value, Map<String, String> param) {
		Set<Entry<String, String>> textSets = param.entrySet();
        for (Entry<String, String> textSet : textSets) {
            String key = "#{"+textSet.getKey()+"}";
            if(value.indexOf(key)!= -1){
                value = value.replace(key, textSet.getValue()==null?"":textSet.getValue());
            }
        }
        return value;
	}
	
	
	public static Map<String,String> load(Object obj) {
		Map<String,String> map=new HashMap<>();
		Field[]  fields=obj.getClass().getDeclaredFields();
		for(Field f:fields) {
			String name=f.getName();
			f.setAccessible(true);
			String value;
			try {
				value = (String) f.get(obj);
				map.put(name, value);
			} catch (Exception e) {		
			}
		}
		return map;
	}

}
