package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class TablechartVO {

	private long t_num;
	private String e_id;
	private String t_title;
	private String t_contents;
	private Date t_regdate;
	private Date t_moddate;	
}
