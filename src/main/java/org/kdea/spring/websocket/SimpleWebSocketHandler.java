package org.kdea.spring.websocket;

import java.io.IOException;
import java.util.*;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class SimpleWebSocketHandler extends TextWebSocketHandler {
	private static Map<String, WebSocketSession> sessionMap = new HashMap<>();
	private static List<String> list = new ArrayList<>();
	
	// 웹소켓 서버측에 텍스트 메시지가 접수되면 호출되는 메소드
	@Override
	public void handleMessage(WebSocketSession session,
			WebSocketMessage<?> message) throws Exception {
		String payloadMessage = (String) message.getPayload();
		System.out.println("서버에 도착한 메시지:" + payloadMessage);

		/*
		 * Iterator<String> keys = sessionMap.keySet().iterator(); while
		 * (keys.hasNext()) { String key = keys.next();
		 * sessionMap.get(key).sendMessage(new TextMessage(payloadMessage)); }
		 */

		JSONParser jsonParser = new JSONParser();

		try {
			JSONObject jsonObj = (JSONObject) jsonParser.parse(payloadMessage);

			String receiver = (String) jsonObj.get("receiver");

			try {
				if (receiver.equals("default")) {
					Iterator<String> keys = sessionMap.keySet().iterator();
					while (keys.hasNext()) {
						String key = keys.next();
	
						sessionMap.get(key).sendMessage(new TextMessage(payloadMessage));
					}
				} else {
					Map<String, Object> map = session.getAttributes();
					String usrId = (String) map.get("usrId");
					sessionMap.get(usrId).sendMessage(
							new TextMessage(payloadMessage));
					sessionMap.get(receiver).sendMessage(
							new TextMessage(payloadMessage));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		Map<String, Object> map = session.getAttributes();
		String usrId = (String) map.get("usrId");
		
		System.out.println("전송자 아이디:" + usrId);
	}

	// 웹소켓 서버에 클라이언트가 접속하면 호출되는 메소드
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {

		super.afterConnectionEstablished(session);
		System.out.println("클라이언트 접속됨");

		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("usrId");

		sessionMap.put(id, session);
		
		Iterator<String> keys = sessionMap.keySet().iterator(); 
		
		list.add(id);	
		
		while(keys.hasNext()) { 
			String key = keys.next();
			sessionMap.get(key).sendMessage(new TextMessage("{'order':'usrappend','list':"+list+"}"));
			
			System.out.println("클라이언트 접속자 추가 "+"{'order':'usrappend','usrId':"+id+"}"+" 보냄");
		 }
		
		 
	}

	// 클라이언트가 접속을 종료하면 호출되는 메소드
	@Override
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);

		Map<String, Object> map = session.getAttributes();
		String id = (String) map.get("usrId");

		sessionMap.remove(id);
		list.remove(id);
		
		
		Iterator<String> keys = sessionMap.keySet().iterator();

	
		while (keys.hasNext()) { String key = keys.next();
		 
		sessionMap.get(key).sendMessage(new TextMessage("{'order':'usrappend','list':"+list+"}"));
		}
		

		System.out.println("클라이언트 접속해제");
	}

	// 메시지 전송시나 접속해제시 오류가 발생할 때 호출되는 메소드
	@Override
	public void handleTransportError(WebSocketSession session,
			Throwable exception) throws Exception {
		super.handleTransportError(session, exception);
		System.out.println("전송오류 발생");
	}
}