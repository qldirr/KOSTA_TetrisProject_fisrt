package org.tetris.domain.project;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectBoardVO {
	
	private Long pb_num;
	private String pb_writer;
	private String pb_contents;
	private String pb_status;
	private Long pj_num;
	
	private List<BoardAttachVO> attachList;
	
}
