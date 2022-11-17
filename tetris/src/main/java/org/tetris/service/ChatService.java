package org.tetris.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.chat.ChatContentsVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.domain.user.DepartmentVO;
import org.tetris.domain.user.UserVO;

public interface ChatService {
	
	public List<UserVO> getListEmp();
	public List<DepartmentVO> getListDept();
	public UserVO getEmp(String e_id);
	public int registerCRoom(ChatRoomVO chatRoomVO);
	public int registerCPart(ChatParticipantVO chatPartVO);
	public List<ChatRoomVO> getListCRoom(String e_id);
	public ChatRoomVO getCRoom(String cr_id);
	public int registerMsg(ChatContentsVO chatContentsVO);
	public int registerCFile(ChatContentsVO chatContentsVO);
	public List<ChatContentsVO> getListCC(String cr_id);
	public List<ChatParticipantVO> getListCPart(String cr_id);

}
