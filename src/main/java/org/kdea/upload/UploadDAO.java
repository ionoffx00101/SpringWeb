package org.kdea.upload;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UploadDAO {
	
	 @Autowired
	 private DataSource dataSource;

	public boolean insertFileinfoDAO(UploadVO vo) {
		
		 String sql = "INSERT INTO upload (fnum,orginfname,changefname,fdesc,fdate) VALUES (upload_SEQ.NEXTVAL,?,?,?,sysdate)";  
		           
		        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		           
		        int rows = jdbcTemplate.update(  
		            sql,  
		            new Object[] { vo.getOrginfname(),vo.getChangefname(),vo.getFdesc()}
		        );
		         
		        return rows>0 ? true : false;
		        
	}

   public UploadVO getrealfilename(String changename) {  
	        String sql = "select * from Upload where changefname=?";  
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	        UploadVO vo = jdbcTemplate.queryForObject(sql, new Object[]{changename}, new UploadRowMapper());  
  return vo;  
	}  
}
