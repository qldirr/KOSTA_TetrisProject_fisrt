package org.tetris.mapper;

import org.tetris.domain.AuthVO;
import org.tetris.domain.UserVO;


public interface UserMapper {

	public UserVO read(String userId);
	public void insertUser(UserVO user);
	public void insertAuthmapping(AuthVO auth);
}
