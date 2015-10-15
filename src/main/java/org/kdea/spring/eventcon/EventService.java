package org.kdea.spring.eventcon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class EventService {
 
    @Autowired
    private EventDAO evtDao;
 
    public List<Event> getEvtList(){
        return evtDao.getEvtList();
    }
     
/*    public Event getEmp(int empno) {
        return evtDao.getEmp(empno);
    }*/
     
    public boolean insertEvt(Event evt) {
        return evtDao.insertEvt(evt);
    }
     
}