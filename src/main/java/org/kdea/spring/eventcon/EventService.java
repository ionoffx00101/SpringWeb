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
     
    public Event getEvt(int eno) {
        return evtDao.getEvt(eno);
    }
     
    public boolean insertEvt(Event evt) {
        return evtDao.insertEvt(evt);
    }

	public boolean editEvt(Event evt) {
		
		return evtDao.updateEvt(evt);
	}

	public boolean deleteEvt(int eno) {
		// TODO Auto-generated method stub
		return evtDao.deleteEvt(eno);
	}

	public List<Event> getSearchEvt(String word, String cate) {
		// TODO Auto-generated method stub
		if(cate.equals("행사주관단체")){
			//주관단체
			return evtDao.SearchEvt(word);
		}
		else if(cate.equals("행사장소")){
			return evtDao.SearchEvtloc(word);
		}
		else if(cate.equals("행사날짜")){
			//날짜
			//world
			
			
			return evtDao.SearchEvtdate(word);
        }
		//없으면 전체리스트
		return evtDao.getEvtList();
	}
     
}