package org.tetris.domain;

import java.sql.Date;
import java.util.List;

import lombok.Data;
@Data
public class UserVO {
	
	private String userId;
	private String userName;
	private String userPass;
	private String userPhoneNumber;
	private String userHireddate;
	private String userResigndate;
	private int userTotalvaction;
	private int userUsevacation;
	private String userBirth;
	private String userNumber;
	private String userPicture;
	private String userPosition;
	private String departmentNumber;
	private boolean enabled;
	
	private List<AuthVO> authList;
	
	

	
	
}
