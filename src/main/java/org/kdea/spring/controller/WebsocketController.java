package org.kdea.spring.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.kdea.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/game")
public class WebsocketController {

	@Autowired
    private LoginService loginservice;
	
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public LoginCommand orderPost(LoginCommand command, HttpSession session) {
    	boolean loginOk = loginservice.loginProcess(command.getId(),command.getPw());
    	
    	
    	command.setOk(loginOk);
    	session.setAttribute("id",command.getId());
        return command;
    }
	
	
	@RequestMapping(value = "/web", method = RequestMethod.GET)
	public String greeting(Locale locale, Model model) {

		return "websocket";
	}

	@RequestMapping(value = "/can", method = RequestMethod.GET)
	public String can(Locale locale, Model model) {

		return "webcanvas";
	}

	@RequestMapping(value = "/ball", method = RequestMethod.GET)
	public String ball(Locale locale, Model model) {

		return "webballcontrol";
	}

	@RequestMapping(value = "/proto", method = RequestMethod.GET)
	public String proto(Locale locale, Model model) {

		return "ballcontrollproto";
	}

	@RequestMapping(value = "/poket", method = RequestMethod.GET)
	public String chatForm() {
		return "wsclient";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm() {
		return "websocketlogin";
	}

}