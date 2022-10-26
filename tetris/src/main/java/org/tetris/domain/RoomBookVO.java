package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RoomBookVO {
	private String rb_num;
	private String mr_num;
		
	private Date rb_bookdate;
	private Date rb_starttime;
	private Date rb_endtime;
	private Date rb_moddate;
	
	private String e_id;
		
}
