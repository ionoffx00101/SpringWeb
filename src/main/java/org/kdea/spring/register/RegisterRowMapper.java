package org.kdea.spring.register;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
   
public class RegisterRowMapper implements RowMapper<MemberVO> {
 
    public MemberVO mapRow(ResultSet rs, int line) throws SQLException {
    	RegisterExtractor eventExtractor = new RegisterExtractor();  
        return eventExtractor.extractData(rs);
    }  
 
}
