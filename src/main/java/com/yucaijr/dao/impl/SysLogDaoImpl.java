package com.yucaijr.dao.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.yucaijr.dao.SysLogDao;
import com.yucaijr.model.SysLog;

@Repository(value="sysLogDao")
public class SysLogDaoImpl implements SysLogDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insert(SysLog sysLog) {
		jdbcTemplate.update("INSERT INTO sys_log(name,type) VALUES(?,?)",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, sysLog.getName());  
                        ps.setString(2, sysLog.getType());             
                       
					}
				});
            
	}

}
