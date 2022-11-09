package org.tetris.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.tetris.domain.user.UserVO;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class NotificationHandler extends TextWebSocketHandler {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	List<WebSocketSession> sockets = new ArrayList<WebSocketSession>();
	private static Map<String, WebSocketSession> user = new HashMap<String, WebSocketSession>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		sockets.add(session);
		
		String e_id = getUserId(session);
		user.put(e_id, session);
		
	}
	
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		
		String e_id = getUserId(session);
		String msg = message.getPayload();
		
		System.out.println(msg + "...................................");
		
		if(msg != null) {
			
			String[] strs = msg.split(",");
			
			if(strs != null && strs.length == 4) {
				
				String type = strs[0];
				String target = strs[1];
				String contents = strs[2];
				String url = strs[3];
				WebSocketSession targetSession = user.get(target);
				
				if("reply".equals(type) && targetSession != null) {
					TextMessage tmpMsg = new TextMessage("<a target='_blank' href='/projectdetail/home/"+ url +"'>[<b>댓글</b>] " + contents + "</a>" );
					targetSession.sendMessage(tmpMsg);
				} else if("docs".equals(type) && targetSession != null) {
					TextMessage tmpMsg = new TextMessage("<a target='_blank' href='"+ url +"'>[<b>결재</b>] " + contents + "</a>" );
					targetSession.sendMessage(tmpMsg);
				} else {
					TextMessage tmpMsg = new TextMessage("<a target='_blank' href='"+ url +"'>[<b>" + type + "</b>] " + contents + "</a>" );
					session.sendMessage(tmpMsg);
				}
			}
			
		}
	}
	
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		
		String e_id = getUserId(session);
		if(e_id != null) {
			log.info(e_id + " 연결 종료됨");
			user.remove(e_id);
			sockets.remove(session);
		}
	}
	
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.info(session.getId() + " 익셉션 발생: " + exception.getMessage());

	}

	
	private String getUserId(WebSocketSession session) {
		Map<String, Object> httpSession = session.getAttributes();
		UserVO loginUser = (UserVO) httpSession.get("loginUser");
		
		log.info(loginUser);
		
		if(loginUser == null) {
			return session.getPrincipal().getName();
		} else {
			log.info(loginUser);
			return loginUser.getE_id();
		}
				
	}
}
