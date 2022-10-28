package org.tetris.domain.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectVO {
	
	private Long pj_num;
	private String pj_name;
	private String pj_type;
	private String pj_startdate;
	private String pj_enddate;
	private String pj_manager;
	private String e_id;

}
