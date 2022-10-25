package org.tetris.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacationVO {

	private long v_num;
	private String v_startdate;
	private String v_enddate;
	private long dm_num;

}
