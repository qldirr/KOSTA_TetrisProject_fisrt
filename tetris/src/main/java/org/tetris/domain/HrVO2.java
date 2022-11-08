package org.tetris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HrVO2 {

	//누적근무시간 
	private long workringHour;
	
	//정상출근
	private long working_day;
	
	//지각
	private long late_day;
	
	//결근
	private long skip_day;
	
	//휴가
	private long holi_day;
	
	//연차총일수
	private long e_totalvac;
	
	//연차사용일수
	private long e_usevac;
	
	//연차잔여일수
	private long left_holiday = e_totalvac - e_usevac;
	
}

