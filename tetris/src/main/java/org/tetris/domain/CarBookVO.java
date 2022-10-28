package org.tetris.domain;

import java.util.Date;

import lombok.Data;

@Data
public class CarBookVO {
	
	private Long CB_NUM;
	private String CB_STARTDAY;
	private String CB_ENDDAY;
	private String CB_REQDAY;
	private String CB_OKDAY;
	private String CB_OK;
	private String CB_RETURNDAY;
	private Date CB_MODIFYDAY;
	private String CA_NUM;
	private String E_ID;

}
