package org.tetris.domain.notification;

import java.util.List;

import org.tetris.domain.elecauth.ElecLineVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlarmVO {
	
	private Long al_num;
	private String e_id;
	private String al_contents;
	private String al_status;
	private String al_type;

}
