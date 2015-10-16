package org.kdea.upload;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
   
public class UploadRowMapper implements RowMapper<UploadVO> {
 
    public UploadVO mapRow(ResultSet rs, int line) throws SQLException {
    	UploadExtractor uploadExtractor = new UploadExtractor();  
        return uploadExtractor.extractData(rs);
    }  
 
}
