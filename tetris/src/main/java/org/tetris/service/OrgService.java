package org.tetris.service;

import java.util.List;

import org.tetris.domain.DepartmentVO;
import org.tetris.domain.user.UserVO;

public interface OrgService {

	public List<UserVO> listAllMember();
	public List<DepartmentVO> listDept();
	public UserVO read(String e_id);
}
