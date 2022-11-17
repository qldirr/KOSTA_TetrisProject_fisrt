package org.tetris.mapper;

import java.util.List;

import org.tetris.domain.DepartmentVO;
import org.tetris.domain.user.UserVO;

public interface OrgMapper {

	public List<DepartmentVO> listDept();
	public List<UserVO> listAllMember();
	public UserVO read(String e_id);
}
