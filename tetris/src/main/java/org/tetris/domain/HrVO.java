package org.tetris.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrVO {
	
	//쌓이는 hr번호
	private long hr_num;

	//사원번호
	private String e_id;
	
	//시작시간 및 당일날짜
	@DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss")
	private Date hr_date;
	//퇴근시간
	@DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss")
	private Date hr_leave;
	
	//근무상태
	private String hr_status;
	//비고
	private String hr_note;
	
	private String e_name;
	private String d_name;
	private String e_position;
	
	private Date e_hiredate;
	private String e_num;
}
