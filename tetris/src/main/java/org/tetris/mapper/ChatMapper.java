package org.tetris.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatContentsVO;
import org.tetris.domain.chat.ChatFileVO;
import org.tetris.domain.chat.ChatMsgVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;

public interface ChatMapper {
	
	public List<EmployeeVO> getListEmp();
	public List<DepartmentVO> getListDept();
	public EmployeeVO getEmp(String e_id);
	public int registerCRoom(ChatRoomVO chatRoomVO);
	public int registerCPart(ChatParticipantVO chatPartVO);
	public List<ChatRoomVO> getListCRoom(String e_id);
	public ChatRoomVO getCRoom(String cr_id);
	public int registerMsg(ChatContentsVO chatContentsVO);
	public List<ChatMsgVO> getListMsg(String cr_id);
	public int registerCFile(ChatContentsVO chatContentsVO);
	public List<ChatFileVO> getListCFile(String cr_id);
	public List<ChatContentsVO> getListCC(String cr_id);

}
