package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RoomBookVO {
	private Long rb_num;
	private String mr_num;
		
	private String rb_startday;
	private String rb_endday;
	private String rb_starttime;
	private String rb_endtime;
	private Date rb_moddate;

	private String e_id;		
}

