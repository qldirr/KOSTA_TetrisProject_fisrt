package org.tetris.domain.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatParticipantVO {
	
	private String cp_num;
	private String cr_id;
	private String e_id;
	private String cp_unread;
	private String cp_isbookmark;

}
