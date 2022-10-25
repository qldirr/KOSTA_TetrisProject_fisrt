package org.tetris.mapper;

import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatRoomVO;

public interface ChatMapper {
	
	public EmployeeVO login(String user);
	public int registerCR(ChatRoomVO chatroom);

}
