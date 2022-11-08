package org.tetris.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatMsgVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.log4j.Log4j;

@Log4j
public class ChatHandler extends TextWebSocketHandler {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private ChatService chatService;
	
	private static Map<String, List<WebSocketSession>> userMap = new HashMap<String, List<WebSocketSession>>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession wsession) throws Exception {
		String roomId = getRoomId(wsession);
		if(userMap.get(roomId) == null) {
			userMap.put(roomId, new ArrayList<WebSocketSession>());
		}
		List<WebSocketSession> userList = userMap.get(roomId);
		userList.add(wsession);
		EmployeeVO loginUser = getLoginUser(wsession);
		
		for(WebSocketSession chatPart : userList) {
			chatPart.sendMessage(new TextMessage(loginUser.getE_name() + "님이 입장하셨습니다."));
		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession wsession, TextMessage message) throws Exception {
		String roomId = getRoomId(wsession);
		EmployeeVO loginUser = getLoginUser(wsession);
		List<WebSocketSession> userList = userMap.get(roomId);
		
//		ChatMsgVO chatMsgVO = objectMapper.readValue(message.getPayload(), ChatMsgVO.class);
//		TextMessage textMessage = new TextMessage(chatMsgVO.getE_id() + ", " + chatMsgVO.getCm_contents());
//		chatService.registerMsg(chatMsgVO);
		
		for(WebSocketSession chatPart : userList) {
			chatPart.sendMessage(new TextMessage(loginUser.getE_name() + ": " + /*textMessage*/message.getPayload()));
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession wsession, CloseStatus status) throws Exception {
		String roomId = getRoomId(wsession);
		List<WebSocketSession> userList = userMap.get(roomId);
		EmployeeVO loginUser = getLoginUser(wsession);
		userList.remove(wsession);
		if(userList.size() == 0) {
			userMap.remove(roomId);
		}
		
		for(WebSocketSession chatPart : userList) {
			chatPart.sendMessage(new TextMessage(loginUser.getE_name() + "님이 나가셨습니다."));
		}
	}
	
	public String getRoomId(WebSocketSession wsession) {
		String str[] = wsession.getUri().getPath().split("/");
		String roomId = str[2];
		
		return roomId;
	}
	
	public EmployeeVO getLoginUser(WebSocketSession wsession) throws Exception {
		String e_id = wsession.getPrincipal().getName();
	    EmployeeVO loginUserVO = chatService.getEmp(e_id);
        
	    return loginUserVO;
    }

}
