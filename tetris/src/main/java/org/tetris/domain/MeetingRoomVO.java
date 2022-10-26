package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MeetingRoomVO {
	
	private String mr_num;
	private String mr_name;
	private String mr_total;
	private Date mr_regdate;
	private Date mr_moddate;	
}

