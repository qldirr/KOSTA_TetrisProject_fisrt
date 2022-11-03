package org.tetris.domain;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {

	private int pageNum;
	private int amount;
	private String e_id;
	
	private String type;
	//부서번호
	private String d_num;
	//일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hr_date;
	//사원이름
	private String e_name;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
}
