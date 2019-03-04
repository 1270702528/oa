package com.yucaijr.dao.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.yucaijr.dao.SysMenuDao;
import com.yucaijr.model.SysMenu;


@Repository(value="sysMenuDao")
public class SysMenuDaoImpl implements SysMenuDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SysMenu> getSysMenuList() {
		String sql="SELECT * from sys_menu";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>((SysMenu.class)));
	}

	@Override
	public List<SysMenu> getSysMenuList(List<Integer> list) {
		
		StringBuffer sql=new StringBuffer("SELECT * from sys_menu");
		if(list!=null && list.size()>0)
		{
			sql.append(" where id in (");
			for(int i=0;i<list.size();i++) {
				sql.append(list.get(i));
				if(i!=list.size()-1) {
					sql.append(",");
				}else {
					sql.append(")");
				}
				
			}
		}
		return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>((SysMenu.class)));
	    
	}

	@Override
	public List<SysMenu> getTopSysMenuList() {
		String sql="SELECT * from sys_menu where pcode=0";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>((SysMenu.class)));
	}

}
