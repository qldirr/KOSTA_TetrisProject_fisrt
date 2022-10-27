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
		// %tp              ����, ���ĸ� ���
        // %tl              �ð��� 1~12 ���� ���
        // %tM              ���� 00~59 ���� ���
		
//		for(WebSocketSession webSocketSession : sessionList) {
//			// ä���� ����� "��ü"�� �ƴ� Ư�����(������ �ӼӸ���� IP address ��) �� ���
//			String hostAddress = webSocketSession.getRemoteAddress().getAddress().getHostAddress(); 
//	        // webSocketSession �� �����ϼ����� ������ ��� Ŭ���̾�Ʈ�� �ϳ��̸�, �� Ŭ���̾�Ʈ�� IP address�� �˾ƿ��� ����.  
//		      
//		     if (messagevo.getTo().equals(hostAddress)) { 
//		         // messageVO.getTo() �� Ŭ���̾�Ʈ�� ������ �ӼӸ���� IP address ��.
//		          webSocketSession.sendMessage(
//		                  new TextMessage("<span> �ӼӸ�"+ wsession.getRemoteAddress().getAddress().getHostAddress() +"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>" +loginuser.getName()+ "</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all; color: red;'>" + messagevo.getMessage() +"</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>" ));  
//		                                                                                                                                                                                                                                                                                                                                            /* word-break: break-all; �� ������� ����θ� �Ǿ��� ��� �ش籸���� ���������Ƿ� �̰��� �������ؼ� ����Ѵ�. */
//		          break; // ������ Ư�����(������ �ӼӸ���� IP address ��)�� 1���̹Ƿ� 
//		                 // Ư�����(������ �ӼӸ���� IP address ��)���Ը� �޽����� ������  break;�� �Ѵ�.
//		      }
//		}
//		
//		for(WebSocketSession webSocketSession : sessionList) {
//			if("all".equals(messagevo.getType())) {
//				// ���� ������ ��ο��� ������
//				if(!wsession.getId().equals(webSocketSession.getId()) ){
//					// wsession �� �޽����� ���� Ŭ���̾�Ʈ��.
//                    // webSocketSession �� �����ϼ����� ����� ��� Ŭ���̾�Ʈ�� �ϳ���.
//                    // wsession.getId() ��  webSocketSession.getId() �� �ڵ������Ǵ� ������ ���ڷ� ���� 
//					webSocketSession.sendMessage(
//							new TextMessage("<span>"+ wsession.getRemoteAddress().getAddress().getHostAddress() +
//									"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>"+ loginuser.getName() +
//									"</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all;'>" + 
//									messagevo.getMessage() + "</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>"));
//				} 
//			} else { 
//				// ä���� ����� "��ü"�� �ƴ� Ư�����(������ �ӼӸ���� IP address ��) �� ���
//				String hostAddress = webSocketSession.getRemoteAddress().getAddress().getHostAddress(); 
//                // webSocketSession �� �����ϼ����� ������ ��� Ŭ���̾�Ʈ�� �ϳ��̸�, �� Ŭ���̾�Ʈ�� IP address�� �˾ƿ��� ����.  
//			      
//			     if (messagevo.getTo().equals(hostAddress)) { 
//			         // messageVO.getTo() �� Ŭ���̾�Ʈ�� ������ �ӼӸ���� IP address ��.
//			          webSocketSession.sendMessage(
//			                  new TextMessage("<span> �ӼӸ�"+ wsession.getRemoteAddress().getAddress().getHostAddress() +"</span>&nbsp;[<span style='font-weight:bold; cursor:pointer;' class='loginuserName'>" +loginuser.getName()+ "</span>]<br><div style='background-color: white; display: inline-block; max-width: 60%; padding: 7px; border-radius: 15%; word-break: break-all; color: red;'>" + messagevo.getMessage() +"</div> <div style='display: inline-block; padding: 20px 0 0 5px; font-size: 7pt;'>"+currentTime+"</div> <div>&nbsp;</div>" ));  
//			                                                                                                                                                                                                                                                                                                                                            /* word-break: break-all; �� ������� ����θ� �Ǿ��� ��� �ش籸���� ���������Ƿ� �̰��� �������ؼ� ����Ѵ�. */
//			          break; // ������ Ư�����(������ �ӼӸ���� IP address ��)�� 1���̹Ƿ� 
//			                 // Ư�����(������ �ӼӸ���� IP address ��)���Ը� �޽����� ������  break;�� �Ѵ�.
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
