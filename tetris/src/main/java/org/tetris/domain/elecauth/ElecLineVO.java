package org.tetris.domain.elecauth;

import java.util.Date;
import java.util.List;

import org.tetris.domain.project.BoardReplyVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElecLineVO {
	
	private String l_num;
	private String l_status;
	private String l_checkdate;
	private String l_seq;
	private String e_id;
	private String e_position;
	private String e_name;
	
	private List<String> lines;

}
