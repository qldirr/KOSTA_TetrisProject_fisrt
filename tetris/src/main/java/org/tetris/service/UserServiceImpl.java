package org.tetris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tetris.domain.user.AuthVO;
import org.tetris.domain.user.UserVO;
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

	@Override
	public List<UserVO> getList() {

		return mapper.getList();
	}

	@Override
	public UserVO detailUser(String e_id) {
		// TODO Auto-generated method stub

		return mapper.detailUser(e_id);
	}
	
	 @Override public AuthVO detailAuth(String e_id) {
		 return
	 mapper.detailAuth(e_id);

	  
	  }

	@Override
	public void updateUser(UserVO user) {
		mapper.updateUser(user);
	}

	@Override
	public int idCheck(UserVO user) {
		// TODO Auto-generated method stub
		return mapper.idCheck(user);
	}


}