package org.tetris.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.tetris.domain.EmployeeVO;

import lombok.extern.log4j.Log4j;

@Log4j
public class ChatHandler extends TextWebSocketHandler {
	
	private static List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		String e_name = getUserName(session);
		System.out.println(e_name);
		sessionList.add(session);
		System.out.println(session.getAttributes());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String e_name= getUserName(session);
		for(WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
		}
		log.info(session.getId() + ": " + message);
		System.out.println(session.getId() + ": " + message.getPayload());
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		String e_name = getUserName(session);
		log.info(session.getId());
		System.out.println(session.getId());
		sessionList.remove(session);
	}
	
	public String getUserName(WebSocketSession session) throws Exception {
        String e_name;
        Map<String, Object> map = session.getAttributes();
        EmployeeVO user = (EmployeeVO)map.get("user");
        e_name = user.getE_name();
        return e_name;
    }

}
