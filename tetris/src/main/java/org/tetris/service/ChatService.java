package org.tetris.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatFileVO;
import org.tetris.domain.chat.ChatMsgVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;

public interface ChatService {
	
	public EmployeeVO login(String user);
	public List<EmployeeVO> getListEmp();
	public List<DepartmentVO> getListDept();
	public EmployeeVO getEmp(String e_id);
	public int registerCRoom(ChatRoomVO chatRoomVO);
	public int registerCPart(ChatParticipantVO chatPartVO);
	public List<ChatRoomVO> getListCRoom(String e_id);
	public ChatRoomVO getCRoom(String cr_id);
	public int registerMsg(ChatMsgVO chatMsgVO);
	public List<ChatMsgVO> getListMsg(String cr_id);
	public int registerCFile(ChatFileVO chatFileVO);
	public List<ChatFileVO> getListCFile(String cr_id);

}
