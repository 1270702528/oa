package com.yucaijr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucaijr.dao.SysRoleDao;
import com.yucaijr.dao.SysUserDao;
import com.yucaijr.model.SysRole;
import com.yucaijr.model.SysUser;
import com.yucaijr.service.ProcessService;
import com.yucaijr.service.SysUserService;
import com.yucaijr.util.DataTool;

@Service(value="sysUserService")
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private ProcessService processService;
	
	@Override
	public SysUser getByUsernameAndPasswd(String username, String passwd) {
		
		return sysUserDao.getByUsernameAndPasswd(username, passwd);
	}

	@Override
	public List<SysUser> getSysUserList() {
		List<SysUser> list=new ArrayList<>();
		for(SysUser s:sysUserDao.getSysUserList()) {
			List<SysRole> sysRoles=sysRoleDao.getRoleById( DataTool.String2List(s.getRoleid()));
			StringBuilder roleName=new StringBuilder();
			for (SysRole sysRole : sysRoles) {
				roleName.append(sysRole.getName());
				roleName.append(",");
			}
			s.setRoleName(roleName.toString());
			list.add(s);
		}
		return list;
	}

	@Override
	public void insert(SysUser sysUser) {
		sysUserDao.insert(sysUser);
		
	}

	@Override
	public void update(SysUser sysUser) {
		sysUserDao.update(sysUser);
		
	}

	@Override
	public void updateStatus(int id) {
		sysUserDao.updateStatus(id);
		
	}

	@Override
	public SysUser getByUsername(String username) {
		return sysUserDao.getByUsername(username);
	}

	

	@Override
	public SysUser getById(int id) {
		return sysUserDao.getById(id);
	}

	@Override
	public void insertWithActivity(SysUser sysUser) {
		//创建系统用户
		insert(sysUser);
		
		//创建activity用户
		processService.addUser(sysUser.getAccount());
		
		//创建关联关系
		List<SysRole> sysRoles=sysRoleDao.getRoleById(DataTool.String2List(sysUser.getRoleid()));
		for (SysRole sysRole : sysRoles) {
			processService.createMembership(sysUser.getAccount(), sysRole.getName());
		}
	}

	@Override
	public void updateWithActivity(SysUser sysUser) {
		
		//获取旧对象
		SysUser oldUser=getById(sysUser.getId());
		
		
		//删除旧的关联关系
		List<SysRole> sysRoles=sysRoleDao.getRoleById(DataTool.String2List(oldUser.getRoleid()));
		for(SysRole sysRole:sysRoles) {
			processService.deleteMembership(oldUser.getAccount(), sysRole.getName());
		}
	
		//添加新的关联关系
		List<SysRole> nsysRoles=sysRoleDao.getRoleById(DataTool.String2List(sysUser.getRoleid()));
		for (SysRole sysRole : nsysRoles) {
			processService.createMembership(oldUser.getAccount(), sysRole.getName());
		}
		
		//修改
		update(sysUser);
		
	}

}
