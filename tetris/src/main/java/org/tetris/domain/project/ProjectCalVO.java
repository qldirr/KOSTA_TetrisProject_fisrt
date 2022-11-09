package org.tetris.domain.project;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectCalVO {
	
	private Long pc_num;
	private String pc_name;
	private String pc_startdate;
	private String pc_enddate;
	private String pc_starttime;
	private String pc_endtime;
	private Long pj_num;	

}
