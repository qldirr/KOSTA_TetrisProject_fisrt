package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private long r_num;
	private String s_num;
	private String r_writer;
	private String r_contents;
	private Date r_regdate;
	private Date r_moddate;	
}
