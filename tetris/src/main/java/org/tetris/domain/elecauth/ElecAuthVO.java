package org.tetris.domain.elecauth;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElecAuthVO {
	
	private Long el_num;
	private String el_name;
	private String el_contents;
	private String el_regdate;
	private String el_status;
	private String l_num;
	private String el_startdate;
	private String el_enddate;
	private String e_id;
	private String dm_num;

}
