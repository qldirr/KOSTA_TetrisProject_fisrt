package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {

	private long n_num;
	private String e_id;
	private String n_title;
	private String n_contents;
	private Date n_regdate;
	private Date n_moddate;	
}
