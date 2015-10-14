package org.kdea.spring.websocket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.websocket.Session;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
 
public class HelloWebSocketHandler extends TextWebSocketHandler {
	private static Map<String, WebSocketSession> sessionMap = new HashMap<>();
	private static int num=0;
	
    // 웹소켓 서버측에 텍스트 메시지가 접수되면 호출되는 메소드
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        String payloadMessage = (String) message.getPayload();
        System.out.println("서버에 도착한 메시지:"+payloadMessage);
        
        Iterator<String> keys = sessionMap.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			/*sessionMap.get(key).sendMessage(new TextMessage("ECHO : " + payloadMessage));*/
			sessionMap.get(key).sendMessage(new TextMessage(payloadMessage));
		}
        
    }
 
    // 웹소켓 서버에 클라이언트가 접속하면 호출되는 메소드
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
         
        super.afterConnectionEstablished(session);
        sessionMap.put(Integer.toString(num++), session);
        
        System.out.println("클라이언트 접속됨");
    }
 
    // 클라이언트가 접속을 종료하면 호출되는 메소드
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
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