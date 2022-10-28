package org.tetris.domain.chat;

import com.google.gson.Gson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMsgVO {
	
	private String cm_num;
	private String e_id;
	private String cr_num;
	private String cm_writer;
	private String cm_contents;
	private String cm_regdate;
	private String cm_status;
	
	public static ChatMsgVO convertMsg(String source) {
		ChatMsgVO message = new ChatMsgVO();
	    Gson gson = new Gson();
	    message = gson.fromJson(source, ChatMsgVO.class);
	 
	    return message;
	}

}
