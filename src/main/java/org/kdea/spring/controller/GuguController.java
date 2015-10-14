package org.kdea.spring.controller;

import java.util.*;



import org.kdea.spring.service.GuguService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GuguController {

    @Autowired
    private GuguService guguservice;

    @RequestMapping(value = "/gugu", method = RequestMethod.GET)
    public String greeting(@RequestParam("num") int eventId,Locale locale, Model model) {
    	
       
        model.addAttribute("guguData", guguservice.getGugu(eventId) );
        return "gugu";
    }
    public GuguService getMyservice() {
	return guguservice;
    }

    public void setMyservice(GuguService guguservice) {
	this.guguservice = guguservice;
    }
}