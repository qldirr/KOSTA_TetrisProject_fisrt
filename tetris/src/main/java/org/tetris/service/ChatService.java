package org.tetris.service;

import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatRoomVO;

public interface ChatService {
	
	public EmployeeVO login(String user);
	public int registerCR(ChatRoomVO chatroom);

}
