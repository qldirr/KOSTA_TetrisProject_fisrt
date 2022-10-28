package org.tetris.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CriteriaVO {

	private int pageNum;
	private int amount;
	
	public CriteriaVO() {
		this(1,10);
	}
	public CriteriaVO(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
}
