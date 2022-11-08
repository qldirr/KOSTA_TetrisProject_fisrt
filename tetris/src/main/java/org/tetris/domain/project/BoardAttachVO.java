package org.tetris.domain.project;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardAttachVO {

	private String pf_uuid;
	private String pf_path;
	private String pf_name;
	private String pf_type;
  
	private Long pb_num;
  
}