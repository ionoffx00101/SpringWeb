package org.kdea.email;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email/")
public class EmailController {
	
    @Autowired
    private EmailService emailService;
     
    @RequestMapping("send")
    @ResponseBody
    public String sendMail(HttpServletRequest request) throws Exception {
    	//<a href="http://ip:8080/ctx/userInput?auth=이용자의 세션 아이디">이메일 수신 확인</a>
        //<a href=\"http://192.168.8.55:8500/SpringWeb/upload/form/\">이메일 수신 확인</a>	
    	
    	String reid =(String)request.getSession().getAttribute("reid");
    	String reemail =(String)request.getSession().getAttribute("reemail");
    	String sessionId = request.getSession().getId();
    	
  System.out.println(reemail);

        EmailVO email = new EmailVO();
         
        String receiver = reemail; //Receiver.
        String subject = "인증메일이 왔어요 ";
        String content = "<html>"
        		+ "<head>"
        		+ "</head>"
        		+ "<body>"
        		+ "<a href=\"http://192.168.8.55:8500/SpringWeb/email/userInput?auth="
        		+ sessionId
        		+ "\">"
        		+ "이메일인증"
        		+ "</a>"
        		+ "</body>"
        		+ "</html>";

        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setContent(content);
        boolean result = emailService.sendMail(email);
        
        return "Mail Send: "+result;
    }
    
    @RequestMapping(value = "login",  method = RequestMethod.GET)  
    public String loginlnk()  {
 
        return "email/login";
    }
    @RequestMapping(value = "login", method = RequestMethod.POST) 
    public String login(@RequestParam("email") String email, HttpServletRequest request)  {
    	request.getSession().setAttribute("reemail",email);

    	return "redirect:/email/send";  
    }

    @RequestMapping(value = "userInput",  method = RequestMethod.GET)  
    @ResponseBody
    public String emailclick(@RequestParam("auth") String id,HttpServletRequest request)  {
    	
    	String sessionId = request.getSession().getId();
    	
    	System.out.println(sessionId+"세션아이디");
    	boolean check= false;
    	if(sessionId.equals(id)){
    		check=true;
    		return "email: "+check+"|  session id :"+id;
    	}
    	return "email: "+check+"|  session id :"+id;
    //	return "email: "+check+"|  session id :"+id;
      // return "{check:"+check+"}";
    }
}