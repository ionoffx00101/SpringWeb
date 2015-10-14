package org.kdea.spring.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.kdea.spring.service.LoginService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class LoginController {

    @Autowired
    private LoginService loginservice;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String orderGet(Locale locale, Model model) {
    	
 
        return "loginForm";
    }
    
    
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public LoginCommand orderPost(LoginCommand command, HttpSession session) {
    	boolean loginOk = loginservice.loginProcess(command.getId(),command.getPw());
    	
    	
    	command.setOk(loginOk);
    	session.setAttribute("ok",loginOk);
        return command;
    }
    
    public LoginService getMyservice() {
	return loginservice;
    }

    public void setMyservice(LoginService loginservice) {
	this.loginservice = loginservice;
    }
}