package org.kdea.spring.service;


import org.springframework.stereotype.Service;

@Service("loginservice")
public class LoginService {

	
	
	public boolean loginProcess(String id, String pass) {
		System.out.println(id+" "+pass);
		boolean check= false;
		
		check= new EmpDAO().log(Integer.parseInt(id), pass);
		
		return check;
	}

}
