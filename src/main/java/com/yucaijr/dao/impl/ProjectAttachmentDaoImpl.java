package com.yucaijr.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yucaijr.dao.ProjectAttachmentDao;
import com.yucaijr.model.ProjectAttachment;



@Repository(value="projectAttachmentDao")
public class ProjectAttachmentDaoImpl implements ProjectAttachmentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(ProjectAttachment projectAttachment) {
		jdbcTemplate.update("INSERT INTO project_attachment(project_info_id,image_url,name,order_num,user_name) VALUES(?,?,?,?,?)",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setInt(1, projectAttachment.getProjectInfoId());  
                        ps.setString(2, projectAttachment.getImageUrl());             
                        ps.setString(3, projectAttachment.getName());  
                        ps.setInt(4, projectAttachment.getOrderNum());   
                        ps.setString(5, projectAttachment.getUserName());   
					}
				});
            
	}

	@Override
	public void update(ProjectAttachment projectAttachment) {
		jdbcTemplate.update("update project_attachment set image_url=?, user_name=? where id=?",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, projectAttachment.getImageUrl());  
						ps.setString(2, projectAttachment.getUserName());         
						ps.setInt(3, projectAttachment.getId());  
						
					}
				});
            
	}

	@Override
	public List<ProjectAttachment> getProjectAttachmentsByProjectId(int id) {
		String sql="select * from project_attachment where project_info_id=? order by order_num";
		RowMapper<ProjectAttachment> rowMapper = new BeanPropertyRowMapper<>(ProjectAttachment.class);  
		List<ProjectAttachment> projectAttachments = jdbcTemplate.query(sql, rowMapper, id);
		
		return projectAttachments;
	}

	@Override
	public ProjectAttachment getByProjectInfoIdAndName(ProjectAttachment projectAttachment) {
		String sql="select * from project_attachment where project_info_id=? and name=? limit 1";
		RowMapper<ProjectAttachment> rowMapper = new BeanPropertyRowMapper<>(ProjectAttachment.class);  
		List<ProjectAttachment> projectAttachments = jdbcTemplate.query(sql, rowMapper, projectAttachment.getProjectInfoId(),projectAttachment.getName());
		if(projectAttachments!=null && projectAttachments.size()>=1) {
			return projectAttachments.get(0);
		}
		return null;
	}

	@Override
	public ProjectAttachment getProjectAttachmentsById(int id) {
		String sql="select * from project_attachment where id=? ";
		RowMapper<ProjectAttachment> rowMapper = new BeanPropertyRowMapper<>(ProjectAttachment.class);  
		List<ProjectAttachment> projectAttachments = jdbcTemplate.query(sql, rowMapper, id);
		if(projectAttachments!=null && projectAttachments.size()>=1) {
			return projectAttachments.get(0);
		}
		return null;
	}
	
	
}
