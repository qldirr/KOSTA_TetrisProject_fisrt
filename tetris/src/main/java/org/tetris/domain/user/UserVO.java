package org.tetris.domain.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private String e_id;
	private String e_name;
	private String d_num;
	private String e_position;

}
