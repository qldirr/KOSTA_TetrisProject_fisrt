package org.tetris.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//		sessionMap = wsession.getAttributes();
		System.out.println(user);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession wsession, TextMessage message) throws Exception {
		EmployeeVO user = getUser(wsession);
//		ChatMsgVO chatMsgVO = ChatMsgVO.convertMsg(message.getPayload());
//		System.out.println(chatMsgVO);
//		Date now = new Date();
//		String currentTime = String.format("%tp %tl:%tM",now,now,now); 
		// %tp              오전, 오후를 출력
        // %tl              시간을 1~12 으로 출력
        // %tM              분을 00~59 으로 출력
		
//		for(WebSocketSession webSocketSession : sessionList) {
//			// 채팅할 대상이 "전체"가 아닌 특정대상(지금은 귓속말대상 IP address 임) 일 경우
//			String hostAddress = webSocketSession.getRemoteAddress().getAddress().getHostAddress(); 
//	        // webSocketSession 은 웹소켓서버에 연결한 모든 클라이언트중 하나이며, 그 클라이언트의 IP address를 알아오는 것임.  
//		      
//		     if (messagevo.getTo().equals(hostAddress)) { 
//		         // messageVO.getTo() 는 클라이언트가 보내온 귓속말대상 IP address 임.
//		          webSocketSession.sendMessage(
//		                  new TextMessage("<span> 귓속말"+ wsession.getRemoteAddress().getAddress().getHostAddress() +"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>" +loginuser.getName()+ "</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all; color: red;'>" + messagevo.getMessage() +"</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>" ));  
//		                                                                                                                                                                                                                                                                                                                                            /* word-break: break-all; 은 공백없이 영어로만 되어질 경우 해당구역을 빠져나가므로 이것을 막기위해서 사용한다. */
//		          break; // 지금의 특정대상(지금은 귓속말대상 IP address 임)은 1개이므로 
//		                 // 특정대상(지금은 귓속말대상 IP address 임)에게만 메시지를 보내고  break;를 한다.
//		      }
//		}
//		
//		for(WebSocketSession webSocketSession : sessionList) {
//			if("all".equals(messagevo.getType())) {
//				// 나를 제외한 모두에게 보내기
//				if(!wsession.getId().equals(webSocketSession.getId()) ){
//					// wsession 은 메시지를 보낸 클라이언트임.
//                    // webSocketSession 은 웹소켓서버에 연결된 모든 클라이언트중 하나임.
//                    // wsession.getId() 와  webSocketSession.getId() 는 자동증가되는 고유한 숫자로 나옴 
//					webSocketSession.sendMessage(
//							new TextMessage("<span>"+ wsession.getRemoteAddress().getAddress().getHostAddress() +
//									"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>"+ loginuser.getName() +
//									"</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all;'>" + 
//									messagevo.getMessage() + "</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>"));
//				} 
//			} else { 
//				// 채팅할 대상이 "전체"가 아닌 특정대상(지금은 귓속말대상 IP address 임) 일 경우
//				String hostAddress = webSocketSession.getRemoteAddress().getAddress().getHostAddress(); 
//                // webSocketSession 은 웹소켓서버에 연결한 모든 클라이언트중 하나이며, 그 클라이언트의 IP address를 알아오는 것임.  
//			      
//			     if (messagevo.getTo().equals(hostAddress)) { 
//			         // messageVO.getTo() 는 클라이언트가 보내온 귓속말대상 IP address 임.
//			          webSocketSession.sendMessage(
//			                  new TextMessage("<span> 귓속말"+ wsession.getRemoteAddress().getAddress().getHostAddress() +"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>" +loginuser.getName()+ "</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all; color: red;'>" + messagevo.getMessage() +"</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>" ));  
//			                                                                                                                                                                                                                                                                                                                                            /* word-break: break-all; 은 공백없이 영어로만 되어질 경우 해당구역을 빠져나가므로 이것을 막기위해서 사용한다. */
//			          break; // 지금의 특정대상(지금은 귓속말대상 IP address 임)은 1개이므로 
//			                 // 특정대상(지금은 귓속말대상 IP address 임)에게만 메시지를 보내고  break;를 한다.
//			      }
//				
//			}
		
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
