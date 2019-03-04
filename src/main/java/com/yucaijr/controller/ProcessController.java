package com.yucaijr.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yucaijr.form.TaskForm;
import com.yucaijr.model.ProjectInfo;
import com.yucaijr.service.ProcessService;
import com.yucaijr.service.ProjectAttachmentService;
import com.yucaijr.util.ProcessImageTool;
import com.yucaijr.util.ResultVOUtil;
import com.yucaijr.util.SessionTool;
import com.yucaijr.vo.ResultVO;


@Controller
@RequestMapping(value="/process")
public class ProcessController {

	@Autowired
	private ProcessService processService;
	
	@Autowired
	private  ProjectAttachmentService projectAttachmentService;
	
	@RequestMapping(value="/start",method=RequestMethod.POST)
	public @ResponseBody ResultVO list(@RequestParam(value="id", defaultValue="")int id) {
		processService.startProcess(id);
		return ResultVOUtil.success();
	}
	

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody Object list(HttpServletRequest request){
		List<TaskForm> taskForms=processService.converterTasks(processService.findTaskList(SessionTool.getRoleSession(request)));
		return taskForms;
	}
	
	
	@RequestMapping(value="/projectInfo",method=RequestMethod.GET)
	public @ResponseBody ResultVO getProjectInfo(@RequestParam(value="taskId", defaultValue="")String taskId){
		ProjectInfo projectInfo=processService.findProjectInfoByTaskId(taskId);
		return ResultVOUtil.success(projectInfo);
	}
	
	@RequestMapping(value="/complete",method=RequestMethod.POST)
	public @ResponseBody ResultVO complete(@RequestParam(value="taskId", defaultValue="")String taskId,
			@RequestParam(value="type", defaultValue="")int type,
			@RequestParam(value="comment", defaultValue="")String comment,
			HttpServletRequest request) {
		processService.complete(type, taskId, comment, SessionTool.getLoginNick(request));
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/taskComment",method=RequestMethod.GET)
	public @ResponseBody Object getProjectComment(@RequestParam(value="taskId", defaultValue="")String taskId){
		List<Comment> comments= processService.findCommentByTaskId(taskId);
		return processService.converter(comments);
	}
	
	@RequestMapping(value="/historyComment",method=RequestMethod.GET)
	public @ResponseBody Object getHistoryComment(@RequestParam(value="id", defaultValue="")int id){
		List<Comment> comments= processService.findCommentByProjectId(id);
		return processService.converter(comments);
	}
	

	@RequestMapping(value="/viewImage",method=RequestMethod.GET)
	public void viewImage(@RequestParam(value="deploymentId", defaultValue="")String deploymentId,
			@RequestParam(value="imageName", defaultValue="")String imageName,
			HttpServletResponse response){
		response.setContentType("image/jpeg");  
		try {
			OutputStream os = response.getOutputStream() ;
			InputStream in = processService.findImageInputStream(deploymentId,imageName);
			for(int b=-1;(b=in.read())!=-1;){
				os.write(b);
			}
			os.close();
			in.close();
		} catch (IOException e){
		}  
	}
	
	@RequestMapping(value="/viewCurrentImage",method=RequestMethod.GET)
	public String viewCurrentImage(@RequestParam(value="taskId", defaultValue="")String taskId,Model model){	
		ProcessDefinition pd =processService.findProcessDefinitionByTaskId(taskId);
		String deploymentId=pd.getDeploymentId();
		String imageName=pd.getDiagramResourceName();	
		Map<String, Object> map=processService.findCoordingByTask(taskId);
		String url="viewImage?deploymentId="+deploymentId+"&imageName="+imageName;
		model.addAttribute("imgurl",url);
		model.addAttribute("style", ProcessImageTool.getStyle(map));	
		return "/task/layout-3.html";
	}
	
	@RequestMapping(value="/mobile/task/{taskId}",method=RequestMethod.GET)
	public String MoblieTaskPage(@PathVariable(value="taskId")String taskId,Model model){
		model.addAttribute("taskId",taskId);
		return "/mobile/task.html";
	}
	
	@RequestMapping(value="/mobile/attachment/{projectId}",method=RequestMethod.GET)
	public String MoblieTaskAttachmentPage(@PathVariable(value="projectId")String projectId,Model model){
		model.addAttribute("projectId",projectId);
		return "/mobile/attachment.html";
	}
	
	@RequestMapping(value="/mobile/hisTask/{projectId}",method=RequestMethod.GET)
	public String MoblieHisTaskAPage(@PathVariable(value="projectId")String projectId,Model model){
		model.addAttribute("projectId",projectId);
		return "/mobile/taskhistory.html";
	}
	
	@RequestMapping(value="/mobile/info/{projectId}",method=RequestMethod.GET)
	public String MoblieProjectInfo(@PathVariable(value="projectId")String projectId,Model model){
		model.addAttribute("projectId",projectId);
		return "/mobile/projectInfo.html";
	}
	
	@RequestMapping(value="/mobile/viewInfo/{projectId}/{index}",method=RequestMethod.GET)
	public String MoblieViewProjectInfo(@PathVariable(value="projectId")String projectId,@PathVariable(value="index") String index,Model model){
		model.addAttribute("projectId",projectId);
		model.addAttribute("index",index);
		return "/mobile/viewProjectInfo.html";
	}
	
	
	@RequestMapping(value="/mobile/viewPdf/{id}",method=RequestMethod.GET)
	public String MoblieViewPdf(@PathVariable(value="id")Integer id,Model model,HttpServletResponse respone){
		model.addAttribute("url",projectAttachmentService.getProjectAttachmentsById(id).getImageUrl());
		return "/mobile/showPdf.html";
	}
			
}
