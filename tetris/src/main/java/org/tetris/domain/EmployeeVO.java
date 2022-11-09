package org.tetris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
	
	private String e_id;
	private String e_name;
	private String e_pw;
	private String e_pnum;
	private String e_hireddate;
	private String e_resigndate;
	private int e_totalvac;
	private int e_usevac;
	private String e_birth;
	private String e_num;
	private String e_picfile;
	private String e_position;
	private String d_num;

}
