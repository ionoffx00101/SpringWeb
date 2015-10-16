package org.kdea.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/email/")
public class EmailController {
	
    @Autowired
    private EmailService emailService;
     
    @RequestMapping("send")
    @ResponseBody
    public String sendMail() throws Exception {
 
        EmailVO email = new EmailVO();
         
        String receiver = "anes344@naver.com"; //Receiver.
        String subject = "ตส";
        String content = "?";
         
        email.setReceiver(receiver);
        email.setSubject(subject);
        email.setContent(content);
        boolean result = emailService.sendMail(email);
        
        return "Mail Send: "+result;
    }
}