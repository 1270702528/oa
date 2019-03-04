package com.yucaijr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucaijr.dao.SysRoleDao;
import com.yucaijr.model.SysRole;
import com.yucaijr.service.ProcessService;
import com.yucaijr.service.SysRoleService;

@Service(value="sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private ProcessService processService;
	
	@Override
	public List<SysRole> getRoleList() {
		return sysRoleDao.getRoleList();
	}

	@Override
	public SysRole getRoleByUserName(String name) {
		return sysRoleDao.getRoleByUserName(name);
	}

	@Override
	public List<SysRole> getRoleById(List<String> ids) {
		return sysRoleDao.getRoleById(ids);
	}

	@Override
	public void insert(SysRole sysRole) {
		sysRoleDao.insert(sysRole);
		
	}

	@Override
	public void update(SysRole sysRole) {
		sysRoleDao.update(sysRole);
		
	}

	@Override
	public void updatePermission(int id, String menus) {
		sysRoleDao.updatePermission(id, menus);
		
	}

	@Override
	public SysRole getRoleById(int id) {
		return sysRoleDao.getRoleById(id);
	}

	@Override
	public void insertWithActity(SysRole sysRole) {
		insert(sysRole);
		
		processService.addGroup(sysRole.getName());
	}

}
