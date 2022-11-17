package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.user.UserVO;
import org.tetris.mapper.OrgMapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class OrgServiceImpl implements OrgService {

	@Autowired
	OrgMapper mapper;
	
	@Override
	public List<UserVO> listAllMember() {
		return mapper.listAllMember();
	}

	@Override
	public List<DepartmentVO> listDept() {
		
		return mapper.listDept();
	}

	@Override
	public UserVO read(String e_id) {
		
		return mapper.read(e_id);
	}
	
	

}
