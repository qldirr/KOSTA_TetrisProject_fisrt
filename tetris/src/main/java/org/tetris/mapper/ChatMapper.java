package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatRoomVO;

public interface ChatMapper {
	
	public EmployeeVO login(String user);
	public List<EmployeeVO> getListEmp();
	public List<DepartmentVO> getListDept();
	public EmployeeVO getEmp(String e_id);
	public int registerCR(ChatRoomVO chatroom);

}
