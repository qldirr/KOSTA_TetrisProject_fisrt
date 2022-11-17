package org.tetris.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatContentsVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.mapper.ChatMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatMapper mapper;
	
	@Override
	public List<EmployeeVO> getListEmp() {
		List<EmployeeVO> listEmp = mapper.getListEmp();
		return listEmp;
	}
	
	@Override
	public EmployeeVO getEmp(String e_id) {
		EmployeeVO emp = mapper.getEmp(e_id);
		return emp;
	}

	@Override
	public List<DepartmentVO> getListDept() {
		List<DepartmentVO> listDept = mapper.getListDept();
		return listDept;
	}

	@Override
	public int registerCRoom(ChatRoomVO chatRoomVO) {
		return mapper.registerCRoom(chatRoomVO);
	}

	@Override
	public int registerCPart(ChatParticipantVO chatPartVO) {
		return mapper.registerCPart(chatPartVO);
	}

	@Override
	public List<ChatRoomVO> getListCRoom(String e_id) {
		List<ChatRoomVO> listChatRoom = mapper.getListCRoom(e_id);
		return listChatRoom;
	}

	@Override
	public ChatRoomVO getCRoom(String cr_id) {
		return mapper.getCRoom(cr_id);
	}

	@Override
	public int registerMsg(ChatContentsVO chatContentsVO) {
		return mapper.registerMsg(chatContentsVO);
	}

	@Override
	public int registerCFile(ChatContentsVO chatContentsVO) {
		return mapper.registerCFile(chatContentsVO);
	}

	@Override
	public List<ChatContentsVO> getListCC(String cr_id) {
		return mapper.getListCC(cr_id);
	}

	@Override
	public List<ChatParticipantVO> getListCPart(String cr_id) {
		return mapper.getListCPart(cr_id);
	}

}
