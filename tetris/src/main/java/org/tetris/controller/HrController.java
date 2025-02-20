package org.tetris.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.Criteria;
import org.tetris.domain.PageDTO;
import org.tetris.domain.attendance.HrVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.HrService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/attendance/*")
@AllArgsConstructor
public class HrController {
	
	private HrService service;
	
	
	@GetMapping("/person")
	public void get( Model model) {
		log.info("/person");
		
		CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String e_id = user.getUsername();
		
		model.addAttribute("hrVO", service.getHr(e_id));
		model.addAttribute("list", service.getHrList(e_id));
		
		log.info(service.getHr(e_id));
	}
	
	//占쏙옙占쏙옙歐占�
//	@PostMapping("/insertAction.do")
//	@ResponseBody
//	public String insertAction(@RequestBody HrVO hr, Model model, RedirectAttributes rttr) {
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
//		log.info("insertAction.do");
//		log.info("e_id: " + hr.getE_id());
//		hr.setHr_Time(formatter.format(date));
//		log.info(hr.getHr_Time());
//		service.startDate(hr.getE_id());
//		rttr.addFlashAttribute("e_id", hr.getE_id());
//		
//		//rttr.addFlashAttribute("result", hr.getE_id());
//		return "redirect:/attendance/person";
//	}


	@PostMapping("/insertAction.do")
	   @ResponseBody
	   public String insertAction(Model model, RedirectAttributes rttr) {
	      Date date = new Date();
	      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	      log.info("insertAction.do");
	      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String e_id = user.getUsername();
	      HrVO hr = new HrVO();
	      
	      hr.setE_id(e_id);
	      log.info("e_id: " + hr.getE_id());
	      hr.setHr_Time(formatter.format(date));
	      log.info(hr.getHr_Time());
	      service.startDate(hr.getE_id());
	      rttr.addFlashAttribute("e_id", hr.getE_id());
	      
	      //rttr.addFlashAttribute("result", hr.getE_id());
	      return "redirect:/attendance/person";
	   }

	//�ܱ�
	   @PostMapping("/outAction.do")
	   @ResponseBody
	   public String outAction(Model model, RedirectAttributes rttr) {
	      log.info("outAction.do...");
	      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String e_id = user.getUsername();
	      HrVO hr = new HrVO();
	      hr.setE_id(e_id);
	      
	      service.outDate(hr.getE_id());
	      rttr.addFlashAttribute("e_id", hr.getE_id());
	      
	      return "redirect:/attendance/person";
	   }

	//����ϱ�
	   @PostMapping("/endAction.do")
	   @ResponseBody
	   public String endDate(Model model, RedirectAttributes rttr) {
	      log.info("/endAction.do");
	      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	      String e_id = user.getUsername();
	      HrVO hr = new HrVO();
	      hr.setE_id(e_id);
	      
	      log.info("e_id: " + hr.getE_id());
	      service.endDate(hr.getE_id());
	      rttr.addFlashAttribute("e_id", hr.getE_id());

	      return "redirect:/attendance/get";
	   } 
	
//personal.jsp 
	
	@GetMapping("/personal")
	public void getPersonal(@RequestParam("e_id") String e_id, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/personal");
		log.info("e_id: " + e_id);
		model.addAttribute("hrVO", service.getHr(e_id));
		model.addAttribute("list", service.getPersonal(e_id));
		model.addAttribute("hrVO2", service.getAttendance(e_id));
		model.addAttribute("hrVA", service.getHrVA(e_id));
	}
	
	
	
//personAll.jsp 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占�
	
	  @GetMapping("/personAll") 
	  public void getAll( Criteria cri, Model model) {
	  
		  log.info("list: " + cri);
		  model.addAttribute("list", service.getHrWithPaging(cri));
		  int total = service.getTotal(cri);
		  log.info("total: " + total);
		  model.addAttribute("pageMaker", new PageDTO(cri, total));
	  }
	  
	  @GetMapping("/searchAction.do")
	  public String searchAction() {
		  log.info("/searchAction.do");
		  
		  return "redirect: /personAll";
	  }
	 
//vacation list 占쏙옙占쏙옙占쏙옙占쏙옙占�
	  @GetMapping("/vacation")
	  public void getVac(@RequestParam("e_id") String e_id, Model model) {
		  log.info("getVac");
		  model.addAttribute("list", service.getVac(e_id));
	  }
	
	
}