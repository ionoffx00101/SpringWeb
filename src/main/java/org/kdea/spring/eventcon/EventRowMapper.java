package org.kdea.spring.eventcon;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.jdbc.core.RowMapper;  
   
public class EventRowMapper implements RowMapper<Event> {
 
    public Event mapRow(ResultSet rs, int line) throws SQLException {
    	EventExtractor eventExtractor = new EventExtractor();  
        return eventExtractor.extractData(rs);
    }  
 
}
