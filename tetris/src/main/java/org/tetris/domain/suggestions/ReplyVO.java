package org.tetris.domain.suggestions;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {

	private Long r_num;
	private Long s_num;
	private String r_reply;
	private String r_replyer;
	private Date r_regdate;
	private Date r_moddate;	
}

