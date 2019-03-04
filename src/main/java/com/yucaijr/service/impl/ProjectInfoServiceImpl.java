package com.yucaijr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yucaijr.dao.ProjectInfoDao;
import com.yucaijr.model.ProjectInfo;
import com.yucaijr.service.ProjectInfoService;

@Service(value="projectInfoService")
public class ProjectInfoServiceImpl implements ProjectInfoService {

	@Autowired
	private ProjectInfoDao projectInfoDao;
	
	@Override
	public void insert(ProjectInfo projectInfo) {
		projectInfoDao.insert(projectInfo);
	}

	@Override
	public void update(ProjectInfo projectInfo) {
		projectInfoDao.update(projectInfo);
	}

	@Override
	public void updateStatus(int id, int status) {
		projectInfoDao.updateStatus(id, status);
		
	}

	@Override
	public List<ProjectInfo> findList() {
		return projectInfoDao.findList();
	}

	@Override
	public ProjectInfo getById(int id) {
		return projectInfoDao.getById(id);
	}

	@Override
	public void updateDocPath(ProjectInfo p, int index,String url) {
		switch (index) {
		case 0:
			p.setF81(url);
			break;

		case 1:
			p.setF82(url);
			break;

		case 2:
			p.setF83(url);
			break;

		case 3:
			p.setF84(url);
			break;

		case 4:
			p.setF85(url);
			break;

		}
		
		update(p);
	}

}
