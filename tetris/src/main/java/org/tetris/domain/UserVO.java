package org.tetris.domain;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class UserVO {
	
	private String e_id;
	private String e_name;
	private String e_pw;
	private String e_pnum;
	private String e_hireddate;
	private String e_resigndate;
	private int e_totalvac;
	private int e_usevac;
	private String e_birth;
	private int e_num;
	private String e_picfile;
	private String e_position;
	private String d_num;
	private boolean enabled;
	private String d_name;
	
	private List<AuthVO> authList;
	

}
