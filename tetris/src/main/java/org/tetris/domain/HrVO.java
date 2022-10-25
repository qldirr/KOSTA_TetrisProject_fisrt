package org.tetris.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrVO {
	//사원번호
	private String e_id;
	//쌓이는 hr번호
	private long hr_num;
	//시작시간 및 당일날짜
	private String hr_date;
	//퇴근시간
	private String hr_leave;
	//근무상태
	private String hr_status;
	//비고
	private String hr_note;
}
