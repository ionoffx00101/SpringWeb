package org.kdea.spring.websocket;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
 

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
 
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor{
 
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler wsHandler,
            Map<String, Object> attributes) throws Exception {
 
      // System.out.println("Before Handshake");
         
       
        
        ServletServerHttpRequest ssreq = (ServletServerHttpRequest) request;
        System.out.println("URI:"+request.getURI());
 
        HttpServletRequest req =  ssreq.getServletRequest();
        System.out.println("param, id:"+req.getParameter("id"));
         
        String usrId = req.getParameter("id");
        attributes.put("usrId", usrId);
        
        req.setAttribute("myId", usrId);
        //req.getSession().setAttribute("myId", usrId); ¤²¹Ù·Î ¾È³ª¿È
        
        Object objList = req.getServletContext().getAttribute("usrList");
		if (objList == null) {
			List<String> usrList = new ArrayList<>();
			req.getServletContext().setAttribute("usrList", usrList);
			
			objList = usrList;
		}
		
		List<String> usrList = (List<String>) objList;
		usrList.add(usrId);
		
                
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
 
    @Override
    public void afterHandshake(ServerHttpRequest request,
            ServerHttpResponse response, WebSocketHandler wsHandler,
            Exception ex) {
       // System.out.println("After Handshake");
 
        super.afterHandshake(request, response, wsHandler, ex);
    }
 
}