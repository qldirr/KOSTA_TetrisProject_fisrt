package org.tetris.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.tetris.domain.HrVO;
import org.tetris.domain.NoticeVO;
import org.tetris.domain.SuggestionsVO;
import org.tetris.domain.elecauth.ElecAuthVO;
import org.tetris.domain.project.ProjectVO;
import org.tetris.security.domain.CustomUser;
import org.tetris.service.ElecAuthService;
import org.tetris.service.HrService;
import org.tetris.service.NoticeService;
import org.tetris.service.ProjectBoardService;
import org.tetris.service.ProjectService;
import org.tetris.service.SuggestionsService;
import org.tetris.service.UserService;

import jdk.jshell.SourceCodeAnalysis.Suggestion;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   
   @Autowired
   private ElecAuthService elecService;
   
   @Autowired
   private ProjectService projectService;
   
   @Autowired
   private ProjectBoardService boardService;
   
   @Autowired
   private NoticeService notService;
   
   @Autowired
   private UserService userService;
   
   @Autowired
   private HrService hrService;
   @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model ) {
      //org.tetris.domain.UserVO user = userService.detailUser(e_id);
      //String userId = user.getE_id();
      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String e_id = user.getUsername();
       String userName = user.getUser().getE_name();
      
       HrVO vo= hrService.getHr(e_id);
       List<ElecAuthVO> list = elecService.getListUncheckedList(e_id);
       List<ProjectVO> projectList = projectService.getListProject(e_id); //해당하는 사용자가 속한
       
       List<Integer> task = new ArrayList<Integer>();
         
         for(int i=0; i<projectList.size(); i++) {
            
            projectList.get(i).setPj_finishedTask(boardService.countTaskFinished(projectList.get(i).getPj_num()));
            
         
         }
       
       
       List<NoticeVO> notlist = notService.getList();
       int disapproved = elecService.countListDisapproved(e_id);
       int unchecked = elecService.countListUncheckedList(e_id);
       int proceeding = elecService.countListProceeding(e_id);
       
       
      model.addAttribute("hrVO", hrService.getHr(e_id));
       
       
       //int taskFinished = boardService.countTaskFinished(pj_num);
       
       //model.addAttribute("hrVO",hrVO);
       model.addAttribute("notlist",notlist);
       model.addAttribute("list", projectList);
      // model.addAttribute("task", taskFinished);
            
       model.addAttribute("authlist", list);
       model.addAttribute("userName", userName);
       model.addAttribute("userid", e_id);
       model.addAttribute("dis", disapproved);
       model.addAttribute("uncheck", unchecked);
       model.addAttribute("proceed", proceeding);
      
      return "main";
   }
   
   
   @PostMapping("/insertAction.do")
   @ResponseBody
   public String insertAction(Model model, RedirectAttributes rttr) {
      Date date = new Date();
      SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String e_id = user.getUsername();
      HrVO hr = new HrVO();
      
      hr.setE_id(e_id);
      hr.setHr_Time(formatter.format(date));
      hrService.startDate(hr.getE_id());
      rttr.addFlashAttribute("e_id", hr.getE_id());
      
      //rttr.addFlashAttribute("result", hr.getE_id());
      return "main";
   }
   

   @PostMapping("/outAction.do")
   @ResponseBody
   public String outAction(Model model, RedirectAttributes rttr) {
      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String e_id = user.getUsername();
      HrVO hr = new HrVO();
      hr.setE_id(e_id);
      
      hrService.outDate(hr.getE_id());
      rttr.addFlashAttribute("e_id", hr.getE_id());
      
      return "main";
   }

   
   @PostMapping("/endAction.do")
   @ResponseBody
   public String endDate(Model model, RedirectAttributes rttr) {
      CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      String e_id = user.getUsername();
      HrVO hr = new HrVO();
      hr.setE_id(e_id);
      
      hrService.endDate(hr.getE_id());
      rttr.addFlashAttribute("e_id", hr.getE_id());

      return "main";
   } 
}