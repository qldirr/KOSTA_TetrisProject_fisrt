package org.tetris.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
public class ChatFileVO {
	
	private String cf_num;
	private String e_id;
	private String cr_id;
	private String cf_uuid;
	private String cf_name;
	private Long cf_size;
	private String cf_regdate;
	private String cf_status;
	private String cf_image;
	private String cf_path;

}
