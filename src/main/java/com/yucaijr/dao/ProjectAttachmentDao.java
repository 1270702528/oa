package com.yucaijr.dao;

import java.util.List;

import com.yucaijr.model.ProjectAttachment;

public interface ProjectAttachmentDao {

	
	public void insert(ProjectAttachment projectAttachment);
	
	public void update(ProjectAttachment projectAttachment);
	
	public List<ProjectAttachment> getProjectAttachmentsByProjectId(int id);
	
	public ProjectAttachment getByProjectInfoIdAndName(ProjectAttachment projectAttachment);
	
	public ProjectAttachment getProjectAttachmentsById(int id);
}
