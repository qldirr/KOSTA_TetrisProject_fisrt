package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CarAppVO {
	
	private Long cp_num;
	private Long cb_num;
	private String cp_ok;
	private Date cp_okday;

}
