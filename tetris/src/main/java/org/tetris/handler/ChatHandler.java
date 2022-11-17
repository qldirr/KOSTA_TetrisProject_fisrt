package org.tetris.handler;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatContentsVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
//		EmployeeVO loginUser = getLoginUser(wsession);
		
//		for(WebSocketSession chatPart : userList) {
//			if(!chatPart.getId().equals(wsession.getId())) {
//				chatPart.sendMessage(new TextMessage(loginUser.getE_name() + "님이 입장하셨습니다."));
//			}
//		}
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession wsession, TextMessage message) throws Exception {
		String roomId = getRoomId(wsession);
		EmployeeVO loginUser = getLoginUser(wsession);
		List<WebSocketSession> userList = userMap.get(roomId);
		System.out.println("text: " + message);
		System.out.println("text: " + message.getPayload());
		
		
		
//		Gson gson = new Gson();
//		ChatContentsVO msgVO = gson.fromJson(message.getPayload(), ChatContentsVO.class);
//		TextMessage sendMsg = new TextMessage(gson.toJson(msgVO));
		TextMessage sendMsg = new TextMessage(message.getPayload());
//		System.out.println(msgVO);
//		System.out.println(message.getPayload());
//		System.out.println(sendMsg);
		
		
		Gson gson = new Gson();
		
		
		
		for(WebSocketSession chatPart : userList) {
			if(!chatPart.getId().equals(wsession.getId())) {
//				chatPart.sendMessage(new TextMessage(/* loginUser.getE_name() + ": " + */message.getPayload()));
				chatPart.sendMessage(sendMsg);
			}
		}
	}
	
	
	
	
	
	
	private static final String FILE_UPLOAD_PATH = "C:\\upload";
	static int fileUploadIdx = 0;
	static String fileUploadSession = "";
	
	
	@Override
	protected void handleBinaryMessage(WebSocketSession wsession, BinaryMessage message) {
		System.out.println(message);
		System.out.println(message.getPayload());
		
		ByteBuffer byteBuffer = message.getPayload();
		System.out.println(byteBuffer);
		
		
		String fileName = "temp.jpg";
		File dir = new File(FILE_UPLOAD_PATH);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		File file = new File(FILE_UPLOAD_PATH, fileName);
		FileOutputStream out = null;
		FileChannel outChannel = null;
		try {
			byteBuffer.flip();//byteBuffer를 읽기 위해 세팅
			out = new FileOutputStream(file, true);//생성을 위해 OutputStream open
			outChannel = out.getChannel();//Channel open
			byteBuffer.compact();//파일 복사
			outChannel.write(byteBuffer);//파일 쓰기
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
					out.close();
				}
				if(outChannel != null) {
					outChannel.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		byteBuffer.position(0);//파일을 저장하면서 변경된 position값 초기화
		//파일 쓰기 종료 후 파일 전송
		String roomId = getRoomId(wsession);
//		EmployeeVO loginUser = getLoginUser(wsession);
		List<WebSocketSession> userList = userMap.get(roomId);
		for(WebSocketSession chatPart : userList) {
			try {
				if(!chatPart.getId().equals(wsession.getId())) {
					chatPart.sendMessage(new BinaryMessage(byteBuffer));//초기화된 버퍼 발송
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public void afterConnectionClosed(WebSocketSession wsession, CloseStatus status) throws Exception {
		String roomId = getRoomId(wsession);
		List<WebSocketSession> userList = userMap.get(roomId);
//		EmployeeVO loginUser = getLoginUser(wsession);
		userList.remove(wsession);
		if(userList.size() == 0) {
			userMap.remove(roomId);
		}
		
//		for(WebSocketSession chatPart : userList) {
//			if(!chatPart.getId().equals(wsession.getId())) {
//				chatPart.sendMessage(new TextMessage(loginUser.getE_name() + "님이 나가셨습니다."));
//			}
//		}
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