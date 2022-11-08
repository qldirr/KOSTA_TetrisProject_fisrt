package org.tetris.security.domain;

import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.tetris.domain.UserVO;

import lombok.Getter;
@Getter
public class CustomUser extends User {
	
	private static final long serialVersionUID = 1L;
	
	private UserVO user;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		
	}
	public CustomUser(UserVO vo) {
		super(vo.getE_id(),vo.getE_pw(), vo.getAuthList().stream().map(auth->new SimpleGrantedAuthority(auth.getA_auth())).collect(Collectors.toList()));
		
		this.user =vo;
	}
	

}