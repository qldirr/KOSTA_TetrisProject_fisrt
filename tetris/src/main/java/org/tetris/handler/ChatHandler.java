package org.tetris.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatMsgVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class ChatHandler extends TextWebSocketHandler {
	
	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private static Map<String, Object> sessionMap = new HashMap<String, Object>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession wsession) throws Exception {
		EmployeeVO user = getUser(wsession);
		sessionList.add(wsession);
		sessionMap = wsession.getAttributes();
		System.out.println(user);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession wsession, TextMessage message) throws Exception {
		EmployeeVO user = getUser(wsession);
		
		for(WebSocketSession webSocketSession : sessionList) {
			webSocketSession.sendMessage(new TextMessage(message.getPayload()));
		}
		log.info(wsession.getId() + ": " + message);
		System.out.println(wsession.getId() + ": " + message.getPayload());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession wsession, CloseStatus status) throws Exception {
		EmployeeVO user = getUser(wsession);
		log.info(wsession.getId());
		System.out.println(wsession.getId());
		sessionList.remove(wsession);
	}
	
	public EmployeeVO getUser(WebSocketSession wsession) throws Exception {
	    Map<String, Object> map = wsession.getAttributes();
	    EmployeeVO user = (EmployeeVO)map.get("user");
        
	    return user;
    }

}
