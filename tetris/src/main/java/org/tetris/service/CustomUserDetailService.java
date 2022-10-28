package org.tetris.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.tetris.domain.UserVO;
import org.tetris.mapper.UserMapper;
import org.tetris.security.domain.CustomUser;

import lombok.extern.log4j.Log4j;
@Log4j
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserMapper usermapper;
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		log.warn("Load User By UserName : " + userid);
		
		UserVO vo = usermapper.read(userid);
		
		log.warn("queried by user mapper: " + vo);
		
		return vo == null? null: new CustomUser(vo);
	}

}
