package org.kdea.spring.eventcon;

import java.util.Locale;

import javax.servlet.http.HttpSession;

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
    
}