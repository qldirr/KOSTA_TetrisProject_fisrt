package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CarBookVO {
	
	private Long cb_num;
	private Date cb_reqday;
	private Date cb_modifyday;
	private String cb_startday;
	private String cb_endday;	
	private String cb_starttime;
	private String cb_endtime;
	private String cb_state;
	
	
	private String ca_num;
	private String e_id;

}
