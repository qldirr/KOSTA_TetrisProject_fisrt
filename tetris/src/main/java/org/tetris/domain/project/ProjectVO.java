package org.tetris.domain.project;

import java.util.List;

import org.tetris.domain.user.UserVO;

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
	private String pj_contents;
	private int pj_finishedTask;
	private String e_id;
	
	private List<UserVO> pj_members;

}
