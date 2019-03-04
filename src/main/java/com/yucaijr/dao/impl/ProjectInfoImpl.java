package com.yucaijr.dao.impl;

import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.yucaijr.dao.ProjectInfoDao;
import com.yucaijr.model.ProjectInfo;


@Repository(value="projectInfoDao")
public class ProjectInfoImpl implements ProjectInfoDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(ProjectInfo projectInfo) {
		String sql="INSERT INTO project_info(user_name,title,description,F01,F02,F03,F04,F05,F06,F07,F08,F09,F10,F11,F12,F13,F14,F15,F16,F17,F18,F19,F20,F21,F22,F23,F24,F25,F26,F27,F28,F29,F30,F31,F32,F33,F34,F35,F36,F37,F38,F39,F40,F41,F42,F43,F44,F45,F46,F47,F48,F49,F50,F51,F52,F53,F54,F55,F56,F57,F58,F59,F60,F61,F62,F63,F64,F65,F66,F67,F68,F69,F70,F71,F72,F73,F74,F75,F76,F77,F78,F79,F80,F81,F82,F83,F84,F85,F86,F87,F88,F89,F90,F91,F92,F93,F94,F95) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
						ps.setString(1, projectInfo.getUserName());  
                        ps.setString(2, projectInfo.getTitle());             
                        ps.setString(3, projectInfo.getDescription());   
                        ps.setString(4,projectInfo.getF01());
                        ps.setString(5,projectInfo.getF02());
                        ps.setString(6,projectInfo.getF03());
                        ps.setString(7,projectInfo.getF04());
                        ps.setString(8,projectInfo.getF05());
                        ps.setString(9,projectInfo.getF06());
                        ps.setString(10,projectInfo.getF07());
                        ps.setString(11,projectInfo.getF08());
                        ps.setString(12,projectInfo.getF09());
                        ps.setString(13,projectInfo.getF10());
                        ps.setString(14,projectInfo.getF11());
                        ps.setString(15,projectInfo.getF12());
                        ps.setString(16,projectInfo.getF13());
                        ps.setString(17,projectInfo.getF14());
                        ps.setString(18,projectInfo.getF15());
                        ps.setString(19,projectInfo.getF16());
                        ps.setString(20,projectInfo.getF17());
                        ps.setString(21,projectInfo.getF18());
                        ps.setString(22,projectInfo.getF19());
                        ps.setString(23,projectInfo.getF20());
                        ps.setString(24,projectInfo.getF21());
                        ps.setString(25,projectInfo.getF22());
                        ps.setString(26,projectInfo.getF23());
                        ps.setString(27,projectInfo.getF24());
                        ps.setString(28,projectInfo.getF25());
                        ps.setString(29,projectInfo.getF26());
                        ps.setString(30,projectInfo.getF27());
                        ps.setString(31,projectInfo.getF28());
                        ps.setString(32,projectInfo.getF29());
                        ps.setString(33,projectInfo.getF30());
                        ps.setString(34,projectInfo.getF31());
                        ps.setString(35,projectInfo.getF32());
                        ps.setString(36,projectInfo.getF33());  
                        ps.setString(37,projectInfo.getF34());
                        ps.setString(38,projectInfo.getF35());
                        ps.setString(39,projectInfo.getF36());
                        ps.setString(40,projectInfo.getF37());
                        ps.setString(41,projectInfo.getF38());
                        ps.setString(42,projectInfo.getF39());
                        ps.setString(43,projectInfo.getF40());
                        ps.setString(44,projectInfo.getF41());
                        ps.setString(45,projectInfo.getF42());
                        ps.setString(46,projectInfo.getF43());
                        ps.setString(47,projectInfo.getF44());
                        ps.setString(48,projectInfo.getF45());
                        ps.setString(49,projectInfo.getF46());
                        ps.setString(50,projectInfo.getF47());
                        ps.setString(51,projectInfo.getF48());
                        ps.setString(52,projectInfo.getF49());
                        ps.setString(53,projectInfo.getF50());
                        ps.setString(54,projectInfo.getF51());
                        ps.setString(55,projectInfo.getF52());
                        ps.setString(56,projectInfo.getF53());
                        ps.setString(57,projectInfo.getF54());
                        ps.setString(58,projectInfo.getF55());
                        ps.setString(59,projectInfo.getF56());
                        ps.setString(60,projectInfo.getF57());
                        ps.setString(61,projectInfo.getF58());
                        ps.setString(62,projectInfo.getF59());
                        ps.setString(63,projectInfo.getF60());
                        ps.setString(64,projectInfo.getF61());
                        ps.setString(65,projectInfo.getF62());
                        ps.setString(66,projectInfo.getF63());
                        ps.setString(67,projectInfo.getF64());
                        ps.setString(68,projectInfo.getF65());
                        ps.setString(69,projectInfo.getF66());
                        ps.setString(70,projectInfo.getF67());
                        ps.setString(71,projectInfo.getF68());
                        ps.setString(72,projectInfo.getF69());
                        ps.setString(73,projectInfo.getF70());
                        ps.setString(74,projectInfo.getF71());
                        ps.setString(75,projectInfo.getF72());
                        ps.setString(76,projectInfo.getF73());
                        ps.setString(77,projectInfo.getF74());
                        ps.setString(78,projectInfo.getF75());
                        ps.setString(79,projectInfo.getF76());
                        ps.setString(80,projectInfo.getF77());
                        ps.setString(81,projectInfo.getF78());
                        ps.setString(82,projectInfo.getF79());
                        ps.setString(83,projectInfo.getF80());
                        ps.setString(84,projectInfo.getF81());
                        ps.setString(85,projectInfo.getF82());
                        ps.setString(86,projectInfo.getF83());
                        ps.setString(87,projectInfo.getF84());
                        ps.setString(88,projectInfo.getF85());
                        ps.setString(89,projectInfo.getF86());
                        ps.setString(90,projectInfo.getF87());
                        ps.setString(91,projectInfo.getF88()); 
                        ps.setString(92,projectInfo.getF89());
                        ps.setString(93,projectInfo.getF90());
                        ps.setString(94,projectInfo.getF91());
                        ps.setString(95,projectInfo.getF92());
                        ps.setString(96,projectInfo.getF93());
                        ps.setString(97,projectInfo.getF94());
                        ps.setString(98,projectInfo.getF95());

					}
				});
            
	}

	@Override
	public void update(ProjectInfo projectInfo) {
		jdbcTemplate.update("update project_info set title=?,description=?,F01=?,F02=?,F03=?,F04=?,F05=?,F06=?,F07=?,F08=?,F09=?,F10=?,F11=?,F12=?,F13=?,F14=?,F15=?,F16=?,F17=?,F18=?,F19=?,F20=?,F21=?,F22=?,F23=?,F24=?,F25=?,F26=?,F27=?,F28=?,F29=?,F30=?,F31=?,F32=?,F33=?,F34=?,F35=?,F36=?,F37=?,F38=?,F39=?,F40=?,F41=?,F42=?,F43=?,F44=?,F45=?,F46=?,F47=?,F48=?,F49=?,F50=?,F51=?,F52=?,F53=?,F54=?,F55=?,F56=?,F57=?,F58=?,F59=?,F60=?,F61=?,F62=?,F63=?,F64=?,F65=?,F66=?,F67=?,F68=?,F69=?,F70=?,F71=?,F72=?,F73=?,F74=?,F75=?,F76=?,F77=?,F78=?,F79=?,F80=?,F81=?,F82=?,F83=?,F84=?,F85=?,F86=?,F87=?,F88=?,F89=?,F90=?,F91=?,F92=?,F93=?,F94=?,F95=?  where id=?",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                        ps.setString(1, projectInfo.getTitle());     
                        ps.setString(2, projectInfo.getDescription());
                        ps.setString(3,projectInfo.getF01());
                        ps.setString(4,projectInfo.getF02());
                        ps.setString(5,projectInfo.getF03());
                        ps.setString(6,projectInfo.getF04());
                        ps.setString(7,projectInfo.getF05());
                        ps.setString(8,projectInfo.getF06());
                        ps.setString(9,projectInfo.getF07());
                        ps.setString(10,projectInfo.getF08());
                        ps.setString(11,projectInfo.getF09());
                        ps.setString(12,projectInfo.getF10());
                        ps.setString(13,projectInfo.getF11());
                        ps.setString(14,projectInfo.getF12());
                        ps.setString(15,projectInfo.getF13());
                        ps.setString(16,projectInfo.getF14());
                        ps.setString(17,projectInfo.getF15());
                        ps.setString(18,projectInfo.getF16());
                        ps.setString(19,projectInfo.getF17());
                        ps.setString(20,projectInfo.getF18());
                        ps.setString(21,projectInfo.getF19());
                        ps.setString(22,projectInfo.getF20());
                        ps.setString(23,projectInfo.getF21());
                        ps.setString(24,projectInfo.getF22());
                        ps.setString(25,projectInfo.getF23());
                        ps.setString(26,projectInfo.getF24());
                        ps.setString(27,projectInfo.getF25());
                        ps.setString(28,projectInfo.getF26());
                        ps.setString(29,projectInfo.getF27());
                        ps.setString(30,projectInfo.getF28());
                        ps.setString(31,projectInfo.getF29());
                        ps.setString(32,projectInfo.getF30());
                        ps.setString(33,projectInfo.getF31());
                        ps.setString(34,projectInfo.getF32());
                        ps.setString(35,projectInfo.getF33());
                       
                        ps.setString(36,projectInfo.getF34());
                        ps.setString(37,projectInfo.getF35());
                        ps.setString(38,projectInfo.getF36());
                        ps.setString(39,projectInfo.getF37());
                        ps.setString(40,projectInfo.getF38());
                        ps.setString(41,projectInfo.getF39());
                        ps.setString(42,projectInfo.getF40());
                        ps.setString(43,projectInfo.getF41());
                        ps.setString(44,projectInfo.getF42());
                        ps.setString(45,projectInfo.getF43());
                        ps.setString(46,projectInfo.getF44());
                        ps.setString(47,projectInfo.getF45());
                        ps.setString(48,projectInfo.getF46());
                        ps.setString(49,projectInfo.getF47());
                        ps.setString(50,projectInfo.getF48());
                        ps.setString(51,projectInfo.getF49());
                        ps.setString(52,projectInfo.getF50());
                        ps.setString(53,projectInfo.getF51());
                        ps.setString(54,projectInfo.getF52());
                        ps.setString(55,projectInfo.getF53());
                        ps.setString(56,projectInfo.getF54());
                        ps.setString(57,projectInfo.getF55());
                        ps.setString(58,projectInfo.getF56());
                        ps.setString(59,projectInfo.getF57());
                        ps.setString(60,projectInfo.getF58());
                        ps.setString(61,projectInfo.getF59());
                        ps.setString(62,projectInfo.getF60());
                        ps.setString(63,projectInfo.getF61());
                        ps.setString(64,projectInfo.getF62());
                        ps.setString(65,projectInfo.getF63());
                        ps.setString(66,projectInfo.getF64());
                        ps.setString(67,projectInfo.getF65());
                        ps.setString(68,projectInfo.getF66());
                        ps.setString(69,projectInfo.getF67());
                        ps.setString(70,projectInfo.getF68());
                        ps.setString(71,projectInfo.getF69());
                        ps.setString(72,projectInfo.getF70());
                        ps.setString(73,projectInfo.getF71());
                        ps.setString(74,projectInfo.getF72());
                        ps.setString(75,projectInfo.getF73());
                        ps.setString(76,projectInfo.getF74());
                        ps.setString(77,projectInfo.getF75());
                        ps.setString(78,projectInfo.getF76());
                        ps.setString(79,projectInfo.getF77());
                        ps.setString(80,projectInfo.getF78());
                        ps.setString(81,projectInfo.getF79());
                        ps.setString(82,projectInfo.getF80());
                        ps.setString(83,projectInfo.getF81());
                        ps.setString(84,projectInfo.getF82());
                        ps.setString(85,projectInfo.getF83());
                        ps.setString(86,projectInfo.getF84());
                        ps.setString(87,projectInfo.getF85());
                        ps.setString(88,projectInfo.getF86());
                        ps.setString(89,projectInfo.getF87());
                        ps.setString(90,projectInfo.getF88());
                        ps.setString(91,projectInfo.getF89());
                        ps.setString(92,projectInfo.getF90());
                        ps.setString(93,projectInfo.getF91());
                        ps.setString(94,projectInfo.getF92());
                        ps.setString(95,projectInfo.getF93());
                        ps.setString(96,projectInfo.getF94());
                        ps.setString(97,projectInfo.getF95());
                		ps.setInt(98, projectInfo.getId());  
					}
				});
	}

	@Override
	public void updateStatus(int id, int status) {
		jdbcTemplate.update("update project_info set status=? where id=?",  
                new PreparedStatementSetter() {
					
					@Override
					public void setValues(java.sql.PreparedStatement ps) throws SQLException {
                        ps.setInt(1, status);             
                		ps.setInt(2, id);  
					}
				});
	}

	@Override
	public List<ProjectInfo> findList() {
		String sql="SELECT * from project_info where status!=-1 order by id desc";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>((ProjectInfo.class)));
	}

	@Override
	public ProjectInfo getById(int id) {
		String sql="select * from project_info where id=?";
		RowMapper<ProjectInfo> rowMapper = new BeanPropertyRowMapper<>(ProjectInfo.class);  
		List<ProjectInfo> listProjectInfos= jdbcTemplate.query(sql, rowMapper, id);
		if(listProjectInfos!=null && listProjectInfos.size()>=1) {
			return listProjectInfos.get(0);
		}
		return null;
	}
}
