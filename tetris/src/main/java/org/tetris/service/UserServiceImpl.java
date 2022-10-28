package org.tetris.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.AuthVO;
import org.tetris.domain.UserVO;
import org.tetris.mapper.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired 
	private UserMapper mapper;
	@Override
	public void insertUser(UserVO vo) {
		mapper.insertUser(vo);
		
	}
	@Override
	public void insertAuthmapping(AuthVO auth) {
		mapper.insertAuthmapping(auth);
		
	}

}
