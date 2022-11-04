package org.tetris.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatContentsVO {
	
	private String cc_num;
	private String e_id;
	private String cr_id;
	private String cc_to;
	private String cc_uuid;
	private String cc_contents;
	private Long cc_size;
	private String cc_regdate;
	private String cc_status;
	private String cc_image;
	private String cc_path;
	private String cc_file;

}
