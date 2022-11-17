package org.tetris.domain.suggestions;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SuggestionsVO {

	private long s_num;
	private String e_id;
	private String s_title;
	private String s_contents;
	private Date s_regdate;
	private Date s_moddate;	
}
