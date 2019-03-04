package com.yucaijr.service.impl;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yucaijr.OaApplication;
import com.yucaijr.dao.ProjectAttachmentDao;
import com.yucaijr.form.ProjectAttachmentForm;
import com.yucaijr.model.ProjectAttachment;
import com.yucaijr.service.ProjectAttachmentService;
import com.yucaijr.util.JsonUtil;


@Service(value="projectAttachmentService")
public class ProjectAttachmentServiceImpl implements ProjectAttachmentService {

	@Autowired
	private ProjectAttachmentDao projectAttachmentDao;

	private static String jsonstr=null;
	static{
		System.out.println("===========加载json文件");
		URL url=OaApplication.class.getClassLoader().getResource("static/filetype.json");
		InputStream is = null;
		InputStreamReader inputStreamReader=null;
		StringBuilder sb=new StringBuilder();
		try {
			 is=url.openStream();
			 inputStreamReader=new InputStreamReader(is);
			 char b[]=new char[1000];
			 int tmp = 0;  
			 while((tmp = inputStreamReader.read(b)) != -1) {
				 sb.append(new String(b,0,tmp));	 
			 }
		}catch (IOException e) {
		
		}finally {
			try {
				is.close();
			} catch (IOException e)
			{	
				
			}
		}
		jsonstr=sb.toString();
	}
	@Override
	public void insert(ProjectAttachment projectAttachment) {
		ProjectAttachment attachment=projectAttachmentDao.getByProjectInfoIdAndName(projectAttachment);
		if(attachment!=null) {
			//System.out.println("====>:已经存在,修改");
			projectAttachment.setId(attachment.getId());
			projectAttachmentDao.update(projectAttachment);
		}else {
			//System.out.println("====>:不存在,添加");
			projectAttachmentDao.insert(projectAttachment);
		}
		
		
	}

	@Override
	public void update(ProjectAttachment projectAttachment) {
		projectAttachmentDao.update(projectAttachment);
		
	}

	@Override
	public List<ProjectAttachment> getProjectAttachmentsByProjectId(int id) {
		List<ProjectAttachment>  projectAttachments=projectAttachmentDao.getProjectAttachmentsByProjectId(id);
		List<ProjectAttachment>  projectAttachments2=tran(loadJson());
		for (ProjectAttachment projectAttachment : projectAttachments2) {
			if(!projectAttachments.contains(projectAttachment)) {
				projectAttachments.add(projectAttachment);
			}
		}
		Collections.sort(projectAttachments,new Comparator<ProjectAttachment>() {

			@Override
			public int compare(ProjectAttachment o1, ProjectAttachment o2) {
				return o1.getOrderNum()-o2.getOrderNum();
			}
		});
		return projectAttachments;
	}

	@Override
	public ProjectAttachment getProjectAttachmentsById(int id) {
		return projectAttachmentDao.getProjectAttachmentsById(id);
	}
	

	public static List<ProjectAttachmentForm> loadJson() {
		return JsonUtil.StringToEntityList(jsonstr, ProjectAttachmentForm.class);	
	}
	
	public static List<ProjectAttachment> tran(List<ProjectAttachmentForm> ProjectAttachmentForm) {
		 List<ProjectAttachment> projectAttachments=new ArrayList<>();
		 for(ProjectAttachmentForm projectAttachmentForm : ProjectAttachmentForm){
			 ProjectAttachment projectAttachment=new ProjectAttachment();
			 projectAttachment.setName(projectAttachmentForm.getText());
			 projectAttachment.setOrderNum(projectAttachmentForm.getValue());
			 projectAttachment.setRemark(projectAttachmentForm.isRemark());
			 projectAttachments.add(projectAttachment);
		 }
		 return projectAttachments;
		
	}
	
}
