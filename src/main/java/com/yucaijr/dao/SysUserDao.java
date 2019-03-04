package com.yucaijr.dao;

import java.util.List;

import com.yucaijr.model.SysUser;

public interface SysUserDao {
	public SysUser getByUsernameAndPasswd(String username,String passwd);
	
	public List<SysUser> getSysUserList();
	
	public void insert(SysUser sysUser);
	
	public void update(SysUser sysUser);
	
	public void updateStatus(int id);
	
	public SysUser getByUsername(String username);
	
	public SysUser getById(int id);
}
