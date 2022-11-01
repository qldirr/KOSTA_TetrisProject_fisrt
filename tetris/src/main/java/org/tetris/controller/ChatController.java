package org.tetris.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.DepartmentVO;
import org.tetris.domain.EmployeeVO;
import org.tetris.domain.chat.ChatMsgVO;
import org.tetris.domain.chat.ChatParticipantVO;
import org.tetris.domain.chat.ChatRoomVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ChatService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/messanger/**")
@Log4j
@AllArgsConstructor
public class ChatController {
	
	@Autowired
	private ChatService chatService;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping({"/main", "/main/emplist"})
	public String main(Model model) {
		List<EmployeeVO> listEmp = chatService.getListEmp();
		List<DepartmentVO> listDept = chatService.getListDept();
		model.addAttribute("listEmp", listEmp);
		model.addAttribute("listDept", listDept);
		return "/messanger/main/emplist";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/main/chatroomlist")
	public void chatRoomList(HttpSession session, Model model, Principal principal) {
//		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String e_id = loginUser.getUsername();
		String e_id = principal.getName();
		model.addAttribute("listChatRoom", chatService.getListCRoom(e_id));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/register")
	@ResponseBody
	public void registerCR(@RequestBody Map<String, Object> map, HttpSession session, Model model, Principal principal) {
		List<EmployeeVO> chatPart = new ArrayList<>();
//		CustomUser loginUser = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		EmployeeVO loginUserVO = chatService.getEmp(principal.getName()/* loginUser.getUser().getUserId() */);
		chatPart.add(loginUserVO);
		
		String e_id = (String)map.get("e_id");
		EmployeeVO empVO = chatService.getEmp(e_id);
		chatPart.add(empVO);
		
		String cr_title = "";
		for(int i=0;i<chatPart.size();i++) {
			cr_title += chatPart.get(i).getE_name();
			cr_title += ", ";
		}
		
		String cr_id = UUID.randomUUID().toString();
		ChatRoomVO chatRoomVO = new ChatRoomVO();
		chatRoomVO.setCr_id(cr_id);
		chatRoomVO.setCr_title(cr_title);
		chatService.registerCRoom(chatRoomVO);
		
		ChatParticipantVO chatPartVO = new ChatParticipantVO();
		for(int i=0;i<chatPart.size();i++) {
			chatPartVO.setCr_id(cr_id);
			chatPartVO.setE_id(chatPart.get(i).getE_id());
			chatService.registerCPart(chatPartVO);
		}
		
		session.setAttribute("cr_id", cr_id);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/chatting")
	@ResponseBody
	public void chatting(@RequestBody Map<String, Object> map, HttpSession session, Model model, HttpServletResponse response) throws IOException {
		String cr_id = (String)map.get("cr_id");
		session.setAttribute("cr_id", cr_id);
		List<ChatMsgVO> listChatMsg = chatService.getListMsg(cr_id);
		response.setContentType("application/json; charset=utf-8");
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(listChatMsg, response.getWriter());
		model.addAttribute("listChatMsg", listChatMsg);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/chatting")
	public void chatting() {
		
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@PostMapping("/registerMsg")
	@ResponseBody
	public void registerMsg(@RequestBody ChatMsgVO chatMsgVO) {
//		String cr_id = (String)map.get("cr_id");
//		String e_id = (String)map.get("e_id");
//		String cm_contents = (String)map.get("cm_contents");
//		ChatMsgVO chatMsgVO = new ChatMsgVO();
//		chatMsgVO.setCr_id(cr_id);
//		chatMsgVO.setE_id(e_id);
//		chatMsgVO.setCm_contents(cm_contents);
		chatService.registerMsg(chatMsgVO);
	}

}
