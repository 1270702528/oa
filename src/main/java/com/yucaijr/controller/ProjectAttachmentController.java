package com.yucaijr.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.yucaijr.model.ProjectAttachment;
import com.yucaijr.model.SysLog;
import com.yucaijr.service.ProjectAttachmentService;
import com.yucaijr.service.SysLogService;
import com.yucaijr.util.ResultVOUtil;
import com.yucaijr.util.SessionTool;
import com.yucaijr.vo.ResultVO;

@RestController
@RequestMapping(value="/attachment")
public class ProjectAttachmentController{

	@Autowired
	private  ProjectAttachmentService projectAttachmentService;
	
	@Autowired
	private SysLogService sysLogService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public Object list(@RequestParam(value="id", defaultValue="") int id){
		return projectAttachmentService.getProjectAttachmentsByProjectId(id);
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public ResultVO create(@ModelAttribute ProjectAttachment projectAttachment,HttpServletRequest request){
		projectAttachment.setUserName(SessionTool.getLoginAccout(request));
		projectAttachmentService.insert(projectAttachment);
		sysLogService.insert(new SysLog(SessionTool.getLoginAccout(request), "添加附件信息"));
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResultVO update(@ModelAttribute ProjectAttachment projectAttachment,HttpServletRequest request){
		projectAttachment.setUserName(SessionTool.getLoginAccout(request));
		projectAttachmentService.update(projectAttachment);
		sysLogService.insert(new SysLog(SessionTool.getLoginAccout(request), "修改附件信息"));
		return ResultVOUtil.success();
	}
	@RequestMapping(value="/update2",method=RequestMethod.POST)
	public ResultVO update2(@ModelAttribute ProjectAttachment projectAttachment,HttpServletRequest request){
		projectAttachment.setUserName(SessionTool.getLoginAccout(request));
		projectAttachmentService.update(projectAttachment);
		sysLogService.insert(new SysLog(SessionTool.getLoginAccout(request), "修改附件信息"));
		return ResultVOUtil.success();
	}
}
