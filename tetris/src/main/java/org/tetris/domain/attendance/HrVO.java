package org.tetris.domain.attendance;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrVO {
	
	private long hr_num;

	private String e_id;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss")
	private Date hr_date;

	@DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm:ss")
	private Date hr_leave;
	
	private String hr_status;

	private String hr_note;
	
	private String e_name;
	private String d_name;
	private String e_position;
	
	private Date e_hiredate;
	private String e_num;
	//지각비교시간
	private String hr_Time;
}
