package org.kdea.spring.eventcon;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.kdea.spring.controller.LoginCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
@RequestMapping("/event/")
public class EventController {
 
    @Autowired
    private EventService evtService;
 
    @RequestMapping("eventList")
    public String getList(Model model){
        model.addAttribute("list",evtService.getEvtList());
        return "event/eventList";
    }
     
    @RequestMapping(value = "eventInput",  method = RequestMethod.GET)  
    public String insertEvtlnk(@ModelAttribute Event evt) {
       System.out.println("인풋페이지로");
            return "event/eventInput";
    
    }  
    
    @RequestMapping(value = "eventInput", method = RequestMethod.POST)  
    public String insertEvt(@ModelAttribute Event evt) {
    	System.out.println("저장페이지로");
    	boolean check = evtService.insertEvt(evt);
        if(check) {
        	return "redirect:/event/eventList";  
           
        }else{
        	 return "event/eventInput";
        }
    }  
    
    @RequestMapping(value = "eventInfo",  method = RequestMethod.GET)  
    public String infoEvtlnk(@ModelAttribute Event evt,@RequestParam("eno") int eno, Model model) {

    	Event selectevt = evtService.getEvt(eno);
    	model.addAttribute("selectevt",selectevt);
    	
        return "event/eventInfo"; 
    }  
    
    @RequestMapping(value = "eventEdit",  method = RequestMethod.GET)  
    public String editEvtlnk(@ModelAttribute Event evt,@RequestParam("eno") int eno, Model model) {

    	Event selectevt = evtService.getEvt(eno);
    	model.addAttribute("selectevt",selectevt);
    	
        return "event/eventEdit"; 
    }  

    @RequestMapping(value = "eventEdit", method = RequestMethod.POST)  
    public String editEvt(@ModelAttribute Event evt, Model model) {
    	int x = evt.getEno();
    	boolean check = evtService.editEvt(evt);
        if(check) {
        /*	String str = "event/eventInfo?eno="+x+"";
        	
        	return str;  */
        	Event selectevt = evtService.getEvt(x);
        	model.addAttribute("selectevt",selectevt);
        	
            return "event/eventInfo"; 
          // return "event/eventInfo";    // 고쳐라 안되면 제이슨으로 보내고 받고라도 해라..
        }else{
        	 return "event/eventEdit"; 
        }
    
    } 
    
    @RequestMapping(value = "eventDelete", method = RequestMethod.GET)  
    public String deleteEvt(@ModelAttribute Event evt,@RequestParam("eno") int eno) {
    	
    	boolean check = evtService.deleteEvt(eno);
        if(check) {
        	return "redirect:/event/eventList";  
           
        }else{
        	 return "event/eventInfo"; 
        }
    
    }  
    
    @RequestMapping(value = "eventSearch", method = RequestMethod.GET)  
    public String searchEvt(@ModelAttribute Event evt,@RequestParam("word") String word,@RequestParam("cate") String cate,Model model) {
    	
    	model.addAttribute("list",evtService.getSearchEvt(word,cate));
    	return "event/eventList"; 
    }  
}