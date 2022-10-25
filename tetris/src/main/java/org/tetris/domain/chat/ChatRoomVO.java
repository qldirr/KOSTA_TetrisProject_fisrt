package org.tetris.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoomVO {
	
	private String cr_num;
	private String cr_title;
	private String cr_unread;
	private String cr_isbookmark;

}
