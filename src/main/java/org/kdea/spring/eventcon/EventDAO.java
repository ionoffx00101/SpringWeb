package org.kdea.spring.eventcon;

import java.util.*;

import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 
@Service
public class EventDAO {
 
    @Autowired
    private DataSource dataSource; // 혹은 아래처럼
 
    //@Resource(name="dataSource")
    //private DataSource dataSource;
 
    public List<Event> getEvtList() {  
        List<Event> list = new ArrayList<Event>();  
        String sql = "select * from event ORDER BY ENO";  
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
        list = jdbcTemplate.query(sql, new EventRowMapper());  
        return list;  
    }
     
    public boolean insertEvt(Event evt) {  
           
        String sql = "INSERT INTO event (eno,edate,eorg,eplace,phone) VALUES (EVENT_SEQ.NEXTVAL,?,?,?,?)";  
           
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
           
        int rows = jdbcTemplate.update(  
            sql,  
            new Object[] {evt.getEdate(),evt.getEorg(),evt.getEplace(),evt.getPhone()}
            /*new Object[] { evt.getEno(),evt.getEdate(),evt.getEorg(),evt.getEplace(),evt.getPhone() }*/
        );
        
        
        return rows>0 ? true : false;
    }
 
}