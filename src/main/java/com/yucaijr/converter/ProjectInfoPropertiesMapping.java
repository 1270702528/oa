package com.yucaijr.converter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目信息和生成字段映射
 * @author Administrator
 *
 */
public class ProjectInfoPropertiesMapping {

	/**
	 * projectInfo和file1映射         key:file1字段  ,value:projectInfo字段
	 * @return
	 */
	public static Map<String,String> File1Mapping(){
		Map<String,String> map=new HashMap<>();
		map.put("F01", "F34");
		map.put("F02", "F21");
		map.put("F03", "F22");
		map.put("F04", "F23");
		map.put("F05", "F35");
		map.put("F06", "F45");
		map.put("F07", "F25");
		map.put("F08", "F36");
		map.put("F09", "F37");
		map.put("F10", "F38");
		map.put("F11", "F42");
		map.put("F12", "F43");
		map.put("F13", "F20");
		map.put("F14", "F27");
		map.put("F15", "F28");
		map.put("F16", "F41");
		map.put("F17", "F40");
		map.put("F18", "F33");
		map.put("F19", "F39");
		map.put("F20", "F64");
		map.put("F21", "F65");
		map.put("F22", "F77");
		return map;
	}
	
	/**
	 * projectInfo和file2映射         key:file2字段  ,value:projectInfo字段
	 * @return
	 */
	public static Map<String,String> File2Mapping(){
		Map<String,String> map=new HashMap<>();
		map.put("a", "F34");
		map.put("b", "F21");
		map.put("c", "F22");
		map.put("d", "F23");
		map.put("e", "F23");
		map.put("f", "F44");
		map.put("g", "F25");
		map.put("h", "F10");
		map.put("i", "F86");
		map.put("j", "F42");
		map.put("k", "F45");
		map.put("l", "F87");
		map.put("m", "F46");
		map.put("n", "F64");
		map.put("o", "F66");
		map.put("p", "F27");
		map.put("q", "F28");
		map.put("r", "F63");
		map.put("s", "F33");
		map.put("t", "F89");
		map.put("u", "F90");
		map.put("v", "F91");
		map.put("w", "F49");
		map.put("x", "F93");
		map.put("y", "F94");
		map.put("z", "F95");
		return map;
	}
	
	/**
	 * projectInfo和file3映射         key:file3字段  ,value:projectInfo字段
	 * @return
	 */
	public static Map<String,String> File3Mapping(){
		Map<String,String> map=new HashMap<>();
		map.put("F01", "F47");
		map.put("F02", "F21");
		map.put("F03", "F22");
		map.put("F04", "F23");
		map.put("F05", "F25");
		map.put("F06", "F35");
		map.put("F07", "F48");
		map.put("F08", "F49");
		map.put("F09", "F78");
		map.put("F10", "F50");
		map.put("F11", "F51");
		map.put("F12", "F52");
		return map;
	}
	
	/**
	 * projectInfo和file4映射         key:file4字段  ,value:projectInfo字段
	 * @return
	 */
	public static Map<String,String> File4Mapping(){
		Map<String,String> map=new HashMap<>();
		map.put("a", "F53");
		map.put("b", "F34");
		map.put("c", "F23");
		map.put("d", "F54");
		map.put("e", "F21");
		map.put("f", "F22");
		map.put("g", "F24");
		map.put("h", "F55");
		map.put("i", "F50");
		map.put("j", "F79");
		map.put("m", "F25");
		map.put("n", "F86");
		map.put("o", "F56");
		map.put("p", "F01");
		map.put("q", "F57");
		map.put("r", "F09");
		map.put("s", "F03");
		map.put("t", "F58");
		map.put("u", "F59");
		map.put("v", "F88");
		map.put("w", "F07");
		map.put("x", "F08");
		map.put("y", "F60");
		map.put("z", "description");
		map.put("A", "F61");
		map.put("B", "F62");
		map.put("C", "F63");
		map.put("D", "F68");
		map.put("E", "F69");
		map.put("F", "F73");
		map.put("G", "F70");
		map.put("H", "F71");
		return map;
	}
	
	/**
	 * projectInfo和file5映射         key:file5字段  ,value:projectInfo字段
	 * @return
	 */
	public static Map<String,String> File5Mapping(){
		Map<String,String> map=new HashMap<>();
		map.put("a", "F34");
		map.put("b", "F53");
		map.put("c", "F21");
		map.put("d", "F22");
		map.put("e", "F21");
		map.put("f", "F25");
		map.put("g", "F24");
		map.put("h", "F74");
		map.put("i", "F71");
		map.put("j", "F75");
		map.put("k", "F76");
		map.put("l", "F80");
		return map;
	}
	
	public static Collection<String> getFields(int index){
		switch (index) {
		case 0:
			return File1Mapping().values();
		case 1:
			return File2Mapping().values();
		case 2:
			return File3Mapping().values();
		case 3:
			return File4Mapping().values();
		case 4:
			return File5Mapping().values();
		
		}
		return null;
	}

}
