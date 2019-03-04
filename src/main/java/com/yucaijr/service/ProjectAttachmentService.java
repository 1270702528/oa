package com.yucaijr.service;

import java.util.List;

import com.yucaijr.model.ProjectAttachment;

public interface ProjectAttachmentService {

	public void insert(ProjectAttachment projectAttachment);
	
	public void update(ProjectAttachment projectAttachment);
	
	public List<ProjectAttachment> getProjectAttachmentsByProjectId(int id);
	
	public ProjectAttachment getProjectAttachmentsById(int id);
	
}
