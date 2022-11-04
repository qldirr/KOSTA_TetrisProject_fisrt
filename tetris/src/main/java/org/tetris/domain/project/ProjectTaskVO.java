package org.tetris.domain.project;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTaskVO {
	
	private Long ts_num;
	private String ts_name;
	private String ts_contents;
	private String ts_startdate;
	private String ts_enddate;
	private String ts_status;
	private String ts_importance;
	private String ts_manager;
	private Long pj_num;
	

}
