package org.kdea.spring.controller;

import java.util.*;

import org.kdea.spring.service.MyService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    private MyService myservice;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String greeting(Locale locale, Model model) {
        model.addAttribute("sampleData", myservice.getMsg() );
        return "hello";
    }
    public MyService getMyservice() {
	return myservice;
    }

    public void setMyservice(MyService myservice) {
	this.myservice = myservice;
    }
}