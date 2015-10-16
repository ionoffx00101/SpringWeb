package org.kdea.spring.register;

import java.util.List;

import javax.mail.internet.InternetAddress; 
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("registerService")
public class RegisterService {
     
    @Autowired
    protected JavaMailSender  mailSender;
    
    @Autowired
    private RegisterDAO dao;
    
    public boolean sendMail(EmailVO email) throws Exception {
        try{
	        MimeMessage msg = mailSender.createMimeMessage();
	        
	        msg.setFrom("someone@paran.com"); // 송신자를 설정해도 소용없지만 없으면 오류가 발생한다
	        msg.setSubject(MimeUtility.encodeText(email.getSubject(), "UTF-8", "B"));
	        //msg.setSubject();
	        //msg.setText(email.getContent());
	        msg.setContent(email.getContent(), "text/html; charset=UTF-8");
	        msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReceiver()));
	         
	        mailSender.send(msg);
	        return true;
        }catch(Exception ex) {
        	ex.printStackTrace();
        }
        return false;
    }

	public boolean addmembersvc(MemberVO vo) {

		return dao.addmemberdao(vo);
	}

	public List<MemberVO> getallList() {
		
		return dao.getallListdao();
	}
}