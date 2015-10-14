package org.kdea.spring.service;

import org.springframework.stereotype.Service;

@Service("myservice")
public class MyService {

	public String getMsg() {
		
		return "Hello World";
	}
}