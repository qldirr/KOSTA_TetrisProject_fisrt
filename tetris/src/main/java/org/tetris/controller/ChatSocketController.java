//package org.tetris.controller;
//
//import java.io.IOException;
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.PathParam;
//import javax.websocket.server.ServerEndpoint;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.tetris.domain.EmployeeVO;
//import org.tetris.domain.chat.ChatMsgVO;
//import org.tetris.security.domain.CustomUser;
//import org.tetris.service.ChatService;
//
//@ServerEndpoint("/chatting/{roomId}")
//public class ChatSocketController {
//	
//    private static HashMap<String, List<Session>> userMap = new HashMap<String, List<Session>>();
//    
//    @OnOpen
//    public void onOpen(Session userSession, @PathParam("roomId") String roomId) {
//        //클라이언트 접속 시 리스트에 웹소켓세션 저장
//    	if(userMap.get(roomId) == null) {
//        	userMap.put(roomId, new ArrayList<Session>());
//        }
//    	List<Session> userList = userMap.get(roomId);
//        userList.add(userSession);
//        for(Session chatPart : userList) {
//			sendMsg(chatPart, userSession.getUserPrincipal().getName() + "님이 입장하셨습니다.");
//        }
//    }
//    //서버 종료시
//    @OnClose
//    public void onClose(Session userSession, @PathParam("roomId") String roomId) {
//    	//접속 끊은 세션 제거
//    	List<Session> userList = userMap.get(roomId);
//        userList.remove(userSession);
//    	if(userList.size() == 0) {
//    		userMap.remove(roomId);
//    	}
//    	
//    	for(Session chatPart : userList) {
//        	sendMsg(chatPart, userSession.getUserPrincipal().getName() + "님이 나가셨습니다.");
//        }
//    }
//    
//    //메시지 수신시
//    @OnMessage
//	public void onMessage(String msg, @PathParam("roomId") String roomId, Session userSession) {
//    	List<Session> userList = userMap.get(roomId);
//    	for(Session chatPart : userList) {
//    		sendMsg(chatPart, userSession.getUserPrincipal().getName() + ": " +  msg);
//		}
//    }
//    
////    private void broadCast(String text){
////        logger.info("전달 대상 : "+userList.size());
////        Set<String>keys =  userList.keySet();
////        try {            
////            for(String key : keys) {
////                logger.info("key : "+key);
////                Session session = userList.get(key);    
////                session.getBasicRemote().sendText(text);
////                System.out.println(session.getId() + "ID!!!");
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
//    
//    //한명에게 메시지 전달
//    private void sendMsg(Session session, String msg) {
//        try {
//            session.getBasicRemote().sendText(msg);
//        } catch (IOException e) {    
//            e.printStackTrace();
//        }
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
