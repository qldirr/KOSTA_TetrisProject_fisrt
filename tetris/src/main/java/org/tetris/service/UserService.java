package org.tetris.service;

import org.tetris.domain.AuthVO;
import org.tetris.domain.UserVO;

public interface UserService {

	public void insertUser(UserVO user);
	public void insertAuthmapping(AuthVO auth);
}

