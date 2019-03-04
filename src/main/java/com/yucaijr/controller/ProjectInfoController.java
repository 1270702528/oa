package com.yucaijr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yucaijr.constant.ProcessConst;
import com.yucaijr.converter.ProjectInfoCoverter;
import com.yucaijr.converter.ProjectInfoPropertiesMapping;
import com.yucaijr.model.ProjectInfo;
import com.yucaijr.model.SysLog;
import com.yucaijr.service.ProcessService;
import com.yucaijr.service.ProjectInfoService;
import com.yucaijr.service.SysLogService;
import com.yucaijr.util.ReflectionUtil;
import com.yucaijr.util.ResultVOUtil;
import com.yucaijr.util.SessionTool;
import com.yucaijr.util.WordUtil;
import com.yucaijr.vo.ResultVO;

@Controller
@RequestMapping(value="/project")
public class ProjectInfoController {

	@Autowired
	private ProjectInfoService projectInfoService;
	
	@Autowired
	private ProcessService processService;
	
	@Autowired
	private SysLogService sysLogService;
	
	/**
	 * 上传地址路径
	 */
	@Value("${upload.path}")
	private String uploadPath;

	@RequestMapping(value="/createProject",method=RequestMethod.POST)
	@ResponseBody
	public  ResultVO createByWebService(@ModelAttribute ProjectInfo projectInfo) {
		System.out.println("==================外部调用创建项目");
		projectInfoService.insert(projectInfo);
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/view/{id}/{index}",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> view(@PathVariable("id") Integer id,@PathVariable("index") Integer index,HttpServletRequest request) {
		ProjectInfo p= projectInfoService.getById(id);
		Collection<String> colls= ProjectInfoPropertiesMapping.getFields(index);
		Map<String,Object> map=new HashMap<>();
		Task task=processService.findTasKByProjectId(id);
		
		for (String string : colls) {
			map.put(string, ReflectionUtil.getValue(p, string));
		}
		
		
		//修改权限判断
		if(SessionTool.getLoginAccout(request).equals("admin")) {
			map.put("status", 1);
		}else {
			if(task==null) {
				map.put("status", 0);
			}else {
				switch (index){
				case 0:
					if(ProcessConst.PROJECT_START.equals(task.getName())||
							ProcessConst.MARKET_AUDIT.equals(task.getName())){
						map.put("status", 1);
					}
					break;

				case 1:
//					if(ProcessConst.PROJECT_START.equals(task.getName())||ProcessConst.RISK_COMMISSIONER_AUDIT.equals(task.getName())||
//							ProcessConst.MARKET_AUDIT.equals(task.getName())){
//						map.put("status", 1);
//					}
					if(ProcessConst.NOTICE_PROJECT_MANAGER.equals(task.getName())||
							ProcessConst.IS_FULL_BID.equals(task.getName())
							||ProcessConst.LENDING.equals(task.getName())) {
						
					}else {
						map.put("status", 1);
					}
					break;
					
				case 2:
					if(ProcessConst.NOTICE_PROJECT_MANAGER.equals(task.getName())||
							ProcessConst.SEND_BID.equals(task.getName()) ||ProcessConst.IS_FULL_BID.equals(task.getName())
							||ProcessConst.LENDING.equals(task.getName())) {
						
					}else {
						map.put("status", 1);
					}
					break;
					
				case 3:
					if(ProcessConst.NOTICE_PROJECT_MANAGER.equals(task.getName())||
							ProcessConst.IS_FULL_BID.equals(task.getName())
							||ProcessConst.LENDING.equals(task.getName())) {
						
					}else {
						map.put("status", 1);
					}
					break;
					
				case 4:
					if(ProcessConst.NOTICE_PROJECT_MANAGER.equals(task.getName())){
						
					}else {
						map.put("status", 1);
					}
					break;
				}
			}
		
		}
		return map;
	}
	
	@RequestMapping(value="/download/{id}/{index}",method=RequestMethod.GET)
	public void download(@PathVariable("id") Integer id,@PathVariable("index") Integer index,HttpServletResponse response) throws Exception {
		ProjectInfo p= projectInfoService.getById(id);
		Object obj=ProjectInfoCoverter.projectInfofoCoverter(index, p);
		String fileSrc=uploadPath+map.get(index);
		String url=uploadPath+UUID.randomUUID()+".docx";
		String templteSrc=uploadPath+"temple.docx";
		WordUtil.generateWord(WordUtil.load(obj), fileSrc,url, templteSrc);
		response.setContentType("application/msword");  
		response.setHeader("Content-disposition", "attachment;filename="  +System.currentTimeMillis()+".docx");  
		OutputStream os = response.getOutputStream();  
		InputStream in=new FileInputStream(new File(url));
		for(int b=-1;(b=in.read())!=-1;){
			os.write(b);
		}
		os.close();
		in.close();
		
		projectInfoService.updateDocPath(p, index,url);
		
	}
	
	@RequestMapping(value="/docs",method=RequestMethod.GET)
	@ResponseBody
	public Object listDoc(@RequestParam(value="id", defaultValue="")int id) {
		ProjectInfo p= projectInfoService.getById(id);
		List<Map<String, String>> list=new ArrayList<>();
		Map<String, String> map1=new HashMap<>();
		map1.put("name", "尽职调查报告");
		Map<String, String> map2=new HashMap<>();
		map2.put("name", "项目审批表");
		Map<String, String> map3=new HashMap<>();
		map3.put("name", "评审会决议书");
		Map<String, String> map4=new HashMap<>();
		map4.put("name", "上线通知书");
		Map<String, String> map5=new HashMap<>();
		map5.put("name", "项目放款审批表");
		if(p.getF81()!=null && !p.getF81().equals("")) {
			map1.put("status", "1");
		}
		if(p.getF82()!=null && !p.getF82().equals("")) {
			map2.put("status", "1");
		}
		if(p.getF83()!=null && !p.getF83().equals("")) {
			map3.put("status", "1");
		}
		if(p.getF84()!=null && !p.getF84().equals("")) {
			map4.put("status", "1");
		}
		if(p.getF85()!=null && !p.getF85().equals("")) {
			map5.put("status", "1");
		}
		list.add(map1);
		list.add(map2);
		list.add(map3);
		list.add(map4);
		list.add(map5);
		return list;
	}
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	@ResponseBody
	public Object list() {
		List<ProjectInfo> projectInfos=projectInfoService.findList();
		processService.converterProject(projectInfos);
		return projectInfos;
	}
		
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public  ResultVO create(@ModelAttribute ProjectInfo projectInfo,HttpServletRequest request){
		projectInfo.setUserName(SessionTool.getLoginAccout(request));
		projectInfoService.insert(projectInfo);
		return ResultVOUtil.success();
	}
		
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public  ResultVO update(@ModelAttribute ProjectInfo projectInfo,HttpServletRequest request){
		ProjectInfo srcPro= projectInfoService.getById(projectInfo.getId());
		ReflectionUtil.TranVals(srcPro, projectInfo);
		projectInfoService.update(projectInfo);
		sysLogService.insert(new SysLog(SessionTool.getLoginAccout(request), "修改项目信息"));
		return ResultVOUtil.success();
	}
	
	@RequestMapping(value="/get",method=RequestMethod.GET)
	@ResponseBody
	public ResultVO get(@RequestParam(value="id", defaultValue="")int id){
		return ResultVOUtil.success(projectInfoService.getById(id));
	}
	
	
	Map<Integer,String> map=new HashMap<>();
	{
		map.put(0, "file1.docx");
		map.put(1, "file2.docx");
		map.put(2, "file3.docx");
		map.put(3, "file4.docx");
		map.put(4, "file5.docx");
	}
	
}
