package org.tetris.domain.project;

import lombok.Data;

@Data
public class BoardAttachVO {

	private String pf_uuid;
	private String pf_path;
	private String pf_name;
	private String pf_type;
  
	private Long pb_num;
  
}