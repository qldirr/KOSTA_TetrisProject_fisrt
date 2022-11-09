package org.tetris.domain.project;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardReplyVO {
	
	private Long pr_num;
	private String pr_writer;
	private String pr_contents;
	private Date pr_regdate;
	private Date pr_moddate;
	private Long pb_num;

}
