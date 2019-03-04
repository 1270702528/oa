package com.yucaijr.dao;

import java.util.List;

import com.yucaijr.model.ProjectInfo;

public interface ProjectInfoDao {

	public void insert(ProjectInfo projectInfo);
	
	public void update(ProjectInfo projectInfo);
	
	public void updateStatus(int id, int status);
	
	public List<ProjectInfo> findList();
	
	public ProjectInfo getById(int id);
}
