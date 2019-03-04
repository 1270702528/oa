package com.yucaijr.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yucaijr.dao.SysUserDao;
import com.yucaijr.model.SysUser;


@Repository(value="sysUserDao")
public class SysUserDaoImpl implements SysUserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public SysUser getByUsernameAndPasswd(String username, String passwd) {
		String sql="select * from sys_user where account=? and password=? and status=1 limit 1";
		RowMapper<SysUser> rowMapper = new BeanPropertyRowMapper<>(SysUser.class);  
		List<SysUser> listsysUser = jdbcTemplate.query(sql, rowMapper, username,passwd);
		if(listsysUser!=null && listsysUser.size()>=1) {
			return listsysUser.get(0);
		}
		return null;
	}

	@Override
	public List<SysUser> getSysUserList() {
		String sql="SELECT user.*,role.name AS roleName FROM sys_user as user LEFT JOIN sys_role role ON user.roleid=role.id where user.status!=3";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>((SysUser.class)));
	}

	@Override
	public void insert(final SysUser sysUser) {
		jdbcTemplate.update("INSERT INTO sys_user(account,password,name,sex,phone,roleid) VALUES(?, ?, ?,?,?,?)",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, sysUser.getAccount());  
                        ps.setString(2, sysUser.getPassword());             
                        ps.setString(3, sysUser.getName());  
                        ps.setInt(4, sysUser.getSex());  
                        ps.setString(5, sysUser.getPhone());  
                        ps.setString(6, sysUser.getRoleid());  
					}
				});
            
        
		
	}

	@Override
	public void update(final SysUser sysUser) {
		jdbcTemplate.update("update sys_user set password=?,name=?,sex=?,phone=?,roleid=?,status=? where id=? ",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                        ps.setString(1, sysUser.getPassword());             
                        ps.setString(2, sysUser.getName());  
                        ps.setInt(3, 0);  
                        ps.setString(4, sysUser.getPhone());  
                        ps.setString(5, sysUser.getRoleid());  
                        ps.setInt(6, sysUser.getStatus()); 
                        ps.setInt(7, sysUser.getId()); 
					}
				});
	}

	@Override
	public void updateStatus(final int id) {
		jdbcTemplate.update("update sys_user set status=3 where id=? ",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                        ps.setInt(1, id);             
                       
					}
				});
	}

	@Override
	public SysUser getByUsername(String username) {
		String sql="select * from sys_user where account=?  limit 1";
		RowMapper<SysUser> rowMapper = new BeanPropertyRowMapper<>(SysUser.class);  
		List<SysUser> listsysUser = jdbcTemplate.query(sql, rowMapper, username);
		if(listsysUser!=null && listsysUser.size()>=1) {
			return listsysUser.get(0);
		}
		return null;
	}

	
	@Override
	public SysUser getById(int id) {
		String sql="select * from sys_user where id=?";
		RowMapper<SysUser> rowMapper = new BeanPropertyRowMapper<>(SysUser.class);  
		List<SysUser> listsysUser = jdbcTemplate.query(sql, rowMapper, id);
		if(listsysUser!=null && listsysUser.size()>=1) {
			return listsysUser.get(0);
		}
		return null;
	}

}
