package com.yucaijr;




import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.yucaijr.constant.ProcessConst;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OaApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private IdentityService identityService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	
	@Test
	public void getTask() {
		HistoricTaskInstance h=historyService.createHistoricTaskInstanceQuery()
				.taskId("20023")
				.singleResult();
		
		System.out.println(h.getName());
	}
	
//	@Test
//	public void isDelopy() {
//	long count = repositoryService.createDeploymentQuery()
//								  .processDefinitionKey(ProcessConst.PROCESS_DEFINCE_ID)
//								  .count();
//		System.out.println(count);
//	}
//	
//	@Test
//	public void isExistUser() {
//		String username="test";
//		long count=identityService.createUserQuery()
//								  .userId(username)
//								  .count();
//		System.out.println(count);
//	}
//	
//	
//	@Test
//	public void taskId() {
//		HistoricTaskInstance hpi=historyService.createHistoricTaskInstanceQuery().taskId("88").singleResult();
//		
//	
//		System.out.println("task"+hpi.getName());
//	}
//	
//	
//	@Test
//	public void bussKey() {
//		String businesskey=runtimeService.createProcessInstanceQuery()
//										 .processInstanceId("49")
//										 .singleResult()
//										 .getBusinessKey();
//		
//		System.out.println("businesskey:"+businesskey);
//	}
//	
//	@Test
//	public void getTaskBybussKey() {
//		String businesskey="bidAudit,19";
//		Task task=taskService.createTaskQuery().processInstanceBusinessKey(businesskey).singleResult();
//		System.out.println(task.getName());
//		
//		System.out.println(4>>1);
//		
//	}
//	
//
//	@Test
//	public void delete() {
//		
//		runtimeService.deleteProcessInstance("35079", "");
//		
//	}
//	
//	
//	@Test
//	public void pdf() {
//		String PdfFilePath="D://a.pdf";
//		String dstImgFolder="D://pdf";
//		int dpi=300;
//		File file = new File(PdfFilePath);
//		PDDocument pdDocument;
//		try {
//			String imgPDFPath = file.getParent();
//			int dot = file.getName().lastIndexOf('.');
//			String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
//			String imgFolderPath = null;
//			if (dstImgFolder.equals("")) {
//				imgFolderPath = imgPDFPath + File.separator + imagePDFName;// 获取图片存放的文件夹路径
//			} else {
//				imgFolderPath = dstImgFolder + File.separator + imagePDFName;
//			}
// 
//	
// 
//				pdDocument = PDDocument.load(file);
//				PDFRenderer renderer = new PDFRenderer(pdDocument);
//				/* dpi越大转换后越清晰，相对转换速度越慢 */
//				PdfReader reader = new PdfReader(PdfFilePath);
//				int pages = reader.getNumberOfPages();
//				StringBuffer imgFilePath = null;
//				for (int i = 0; i < pages; i++) {
//					String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
//					imgFilePath = new StringBuffer();
//					imgFilePath.append(imgFilePathPrefix);
//					imgFilePath.append("_");
//					imgFilePath.append(String.valueOf(i + 1));
//					imgFilePath.append(".png");
//					File dstFile = new File(imgFilePath.toString());
//					BufferedImage image = renderer.renderImageWithDPI(i, dpi);
//					ImageIO.write(image, "png", dstFile);
//				}
//				System.out.println("PDF文档转PNG图片成功！");
// 
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	
	
}
