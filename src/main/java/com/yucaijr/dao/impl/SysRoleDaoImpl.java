package com.yucaijr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yucaijr.dao.SysRoleDao;
import com.yucaijr.model.SysRole;



@Repository(value="sysRoleDao")
public class SysRoleDaoImpl implements SysRoleDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SysRole> getRoleList() {
		String sql="SELECT * from sys_role";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>((SysRole.class)));
	}

	@Override
	public SysRole getRoleByUserName(String name) {
		String sql="select * from sys_role where name=?  limit 1";
		RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<>(SysRole.class);  
		List<SysRole> listsysRole = jdbcTemplate.query(sql, rowMapper, name);
		if(listsysRole!=null && listsysRole.size()>=1) {
			return listsysRole.get(0);
		}
		return null;
	}

	@Override
	public List<SysRole> getRoleById(List<String> ids) {
		StringBuilder sql=new StringBuilder("select * from sys_role");
	
		if(ids!=null && ids.size()>0) {
			sql.append(" where id in (");
			int i=0;
			for(String s:ids) {
				sql.append(s);
				if(i==ids.size()-1) {
					sql.append(")");
				}else {
					sql.append(",");
				}
				i++;
			}
			
		}else {
			return null;
		}
		RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<>(SysRole.class);  
		List<SysRole> listsysRole = jdbcTemplate.query(sql.toString(), rowMapper);
	
		return listsysRole;
	}

	@Override
	public void insert(SysRole sysRole) {
		jdbcTemplate.update("INSERT INTO sys_role(name,message) VALUES(?, ?)",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, sysRole.getName());  
                        ps.setString(2, sysRole.getMessage());             
                 
					}
				});
            
        
	}

	@Override
	public void update(SysRole sysRole) {
		jdbcTemplate.update("update sys_role set name=?,message=? where id=?",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, sysRole.getName());  
                        ps.setString(2, sysRole.getMessage());      
                        ps.setInt(3, sysRole.getId());           
                 
					}
				});
	}
	
	@Override
	public void updatePermission(int id, String menus) {
		jdbcTemplate.update("update sys_role set permission=? where id=? ",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                        ps.setString(1, menus);             
                        ps.setInt(2, id);    
					}
				});
	}

	@Override
	public SysRole getRoleById(int id) {
		String sql="select * from sys_role where id=?  limit 1";
		RowMapper<SysRole> rowMapper = new BeanPropertyRowMapper<>(SysRole.class);  
		List<SysRole> listsysRole = jdbcTemplate.query(sql, rowMapper, id);
		if(listsysRole!=null && listsysRole.size()>=1) {
			return listsysRole.get(0);
		}
		return null;
	}


}
