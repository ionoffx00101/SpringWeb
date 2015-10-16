package org.kdea.spring.register;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register/")
public class RegisterController {
	
    @Autowired
    private RegisterService registerService;
     
    @RequestMapping("send") 
    @ResponseBody
    public String sendMail(HttpServletRequest request) throws Exception {
    	
    	String inemail = request.getParameter("email");
    	request.getSession().setAttribute("useremail",inemail);
    	System.err.println( inemail+"이메일온값");
    	String sessionId = request.getSession().getId();
    	
        EmailVO email = new EmailVO();
         
        String receiver =  request.getParameter("email"); //Receiver.
        String subject = "인증메일이 왔어요 ";
        String content = "<html>"
        		+ "<head>"
        		+ "</head>"
        		+ "<body>"
        		+ "<a href=\"http://192.168.8.55:8500/SpringWeb/register/userInput?auth="
        		+ sessionId
        		+ "\">"
        		+ "이메일인증"
        		+ "</a>"
        		+ "</body>"
        		+ "</html>";

        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setContent(content);
        boolean result = registerService.sendMail(email);
        
        return "{\"check\":"+result+"}";
    }
    
    @RequestMapping(value = "register",  method = RequestMethod.GET)  
    public String loginlnk()  {
 
        return "register/register";
    }
    
    @RequestMapping(value = "list",  method = RequestMethod.GET)  
    public String listlnk(Model model)  {
 
    	model.addAttribute("list",registerService.getallList());
    	
        return "register/list";
    }
    
  /*  @RequestMapping(value = "register", method = RequestMethod.POST) 
    public String login(@RequestParam("sessionid") String sessionid, HttpServletRequest request)  {
    	
    	request.getSession().getAttribute("useremail");
    	request.getSession().setAttribute("emailok", true);
    	
    	return "register/register";
    }*/

    @RequestMapping(value = "userInput",  method = RequestMethod.GET)  
   //@ResponseBody
    public String emailclick(@RequestParam("auth") String id,HttpServletRequest request)  {
    	
    	String sessionId = request.getSession().getId();
    	
    	
    	if(sessionId.equals(id)){
    
    		request.setAttribute("sessionid", sessionId);
    		request.getSession().setAttribute("emailok", true);
    		return "/register/register";
    	}
    	request.getSession().setAttribute("emailok",false);
    	return  "/register/register";

    }
    
    @RequestMapping("allform") 
    @ResponseBody
    public String addmember(HttpServletRequest request) throws Exception {
    	MemberVO vo = new MemberVO();
    vo.setEmail(request.getParameter("email"));
    vo.setId(request.getParameter("id"));
   vo.setPw(request.getParameter("pw")); 
    vo.setName(request.getParameter("name"));
        
        boolean result = registerService.addmembersvc(vo);
        
        return "{\"check\":"+result+"}";
    }
}