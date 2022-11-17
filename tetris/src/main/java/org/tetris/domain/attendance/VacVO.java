package org.tetris.domain.attendance;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacVO {

	private long v_num;
	private Date v_startdate;
	private Date v_enddate;
	private long dm_num;
	private long e_num;
	private String e_name;
	private long el_num;
	
}
