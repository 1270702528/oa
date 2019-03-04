package com.yucaijr.dao;

import java.util.List;

import com.yucaijr.model.SysRole;

public interface SysRoleDao {

	public List<SysRole> getRoleList();
	
	public SysRole getRoleByUserName(String name);
	
	public SysRole getRoleById(int id);
	
	public List<SysRole> getRoleById(List<String> ids);
	
	public void insert(SysRole sysRole);
	
	public void update(SysRole sysRole);
	
	public void updatePermission(int id,String menus);
}
