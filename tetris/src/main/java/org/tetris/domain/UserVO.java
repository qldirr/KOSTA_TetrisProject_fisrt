package org.tetris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	private String e_id;
	private String e_name;
	private String e_birth;
	private String e_picfile;
	private String e_pnum;
	private String e_position;
	private String d_num;
	private String d_name;
	
	
}
