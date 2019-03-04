package com.yucaijr.service.impl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yucaijr.dao.SysMenuDao;
import com.yucaijr.model.SysMenu;
import com.yucaijr.service.SysMenuService;


@Service(value="sysMenuService")
public class SysMenuServiceImpl implements SysMenuService{

	

	@Autowired
	private SysMenuDao sysMenuDao;
	@Override
	public List<SysMenu> getSysMenuList() {
		return sysMenuDao.getSysMenuList();
	}
	@Override
	public List<SysMenu> getSysMenuList(List<Integer> list) {
		return sysMenuDao.getSysMenuList(list);
	}
	@Override
	public List<SysMenu> getTopSysMenuList() {
		return sysMenuDao.getTopSysMenuList();
	}
	

}
