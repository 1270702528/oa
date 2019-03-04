package com.yucaijr.service;

import java.util.List;
import com.yucaijr.model.SysMenu;


public interface SysMenuService {

	public List<SysMenu> getSysMenuList();
	
	public List<SysMenu> getSysMenuList(List<Integer> list);
	
	public List<SysMenu> getTopSysMenuList();
}
