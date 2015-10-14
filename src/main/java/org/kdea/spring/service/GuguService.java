package org.kdea.spring.service;

import org.springframework.stereotype.Service;

@Service("guguservice")
public class GuguService {

	public String getGugu(int num) {
		
		String gugu= null;
		
		for(int i=1;i<10;i++){
			if(gugu==null){gugu=num+"*"+i+"="+num*i+"<br>";continue;}
			gugu+=(num+"*"+i+"="+num*i+"<br>");
		}
		
		return gugu;
	}

}
