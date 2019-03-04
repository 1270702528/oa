package com.yucaijr.service;

import java.util.List;

import com.yucaijr.model.ProjectInfo;

public interface ProjectInfoService {

	public void insert(ProjectInfo projectInfo);
	
	public void update(ProjectInfo projectInfo);
	
	public void updateStatus(int id, int status);
	
	public List<ProjectInfo> findList();
	
	public ProjectInfo getById(int id);
	
	/**
	 * 修改文件路径
	 * @param p
	 */
	public void updateDocPath(ProjectInfo p,int index,String url);
}
