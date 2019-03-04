package com.yucaijr.dao;

import java.util.List;

import com.yucaijr.model.SysMenu;

public interface SysMenuDao {

	public List<SysMenu> getSysMenuList();
	
	public List<SysMenu> getSysMenuList(List<Integer> list);
	
	public List<SysMenu> getTopSysMenuList();
}
