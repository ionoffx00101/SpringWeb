package org.kdea.spring.eventcon;

import java.sql.ResultSet;  
import java.sql.SQLException;  
import org.springframework.dao.DataAccessException;  
import org.springframework.jdbc.core.ResultSetExtractor;  
   
public class EventExtractor implements ResultSetExtractor<Event> {  
   
 public Event extractData(ResultSet resultSet) throws SQLException,  
   DataAccessException {  
     
   Event evt = new Event();  
   
   evt.setEno(resultSet.getInt("ENO"));
   evt.setEdate(resultSet.getDate("EDATE"));
   evt.setEorg(resultSet.getString("EORG"));
   evt.setEplace(resultSet.getString("EPLACE"));
   evt.setPhone(resultSet.getString("PHONE"));
   
  return evt;  
 }  
   
}
