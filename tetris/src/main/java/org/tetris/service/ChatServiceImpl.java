package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.mapper.ChatMapper;
import org.tetris.mapper.TestMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {
	
	@Autowired
	private ChatMapper mapper;

	@Override
	public EmployeeVO login(String user) {
		return mapper.login(user);
	}
	
	@Override
	public int registerCR(ChatRoomVO chatroom) {
		return mapper.registerCR(chatroom);
	}

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

}
