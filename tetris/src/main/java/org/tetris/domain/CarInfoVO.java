package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CarInfoVO {
	
	private String ca_num;
	private String ca_model;
	private String ca_type;
	private String ca_age;
	private Date ca_regdate;
	private Date ca_modifydate;

}
