package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	/*
	// 컨트롤러 메서드
	// @RequestMapping(value = {"/notice.htm"}, method = RequestMethod.GET)
	// @RequestMapping("/customer/notice.htm")
	@GetMapping("/customer/notice.htm")
	public ModelAndView notices(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("message","hello world");
		
		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");
		
		int page = 1;
		String field = "title";
		String query = "";
		
		if (ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage); }
		
		if (pfield != null && !pfield.equals("")) { field = pfield; }
		
		if (pquery != null && !pquery.equals("")) { query = pquery; }
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		mav.addObject("list",list);
		
		mav.setViewName("notice.jsp");
		
		return mav;
		
	}
	*/
	
	// 컨트롤러 메서드
	// @RequestMapping(value = {"/customer/notice.htm"}, method = RequestMethod.GET)
	// @RequestMapping("/customer/notice.htm")
	@GetMapping("/notice.htm")
	public String notices(
			@RequestParam(value = "page", defaultValue = "1") int page
			, @RequestParam(value = "field", defaultValue = "title") String field
			, @RequestParam(value = "query", defaultValue = "") String query
			, Model model) throws Exception {
			
		model.addAttribute("message","hello world");
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		model.addAttribute("list",list);
		
		return "notice.jsp";
		
	}
	
	@GetMapping("/noticeDetail.htm")
	public String noticeDetail(
			@RequestParam("seq") String seq
			, Model model) throws Exception {
		
		NoticeVO notice = this.noticeDao.getNotice(seq);
		
		model.addAttribute("notice",notice);
		
		return "noticeDetail.jsp";
		
	}
	
	// notice.jsp에서 링크태그 [글쓰기] 버튼 클릭
	// @RequestMapping(value = {"/noticeReg.htm"}, method = RequestMethod.GET)
	@GetMapping("/noticeReg.htm")
	public String noticeReg() throws Exception {
		
		return "noticeReg.jsp";
		
	}
	
	// p358 컨트롤러 메서드 파라미터( 커맨드 객체 사용 예 )
	// @RequestMapping(value = {"/noticeReg.htm"}, method = RequestMethod.POST)
	@PostMapping("/noticeReg.htm")
	public String noticeReg(NoticeVO notice) throws Exception {
		
		// 로그인 인증 - 세션
		notice.setWriter("hyeok");
		
		int insertCount = this.noticeDao.insert(notice);
		if (insertCount == 1) {
			// redirect: == response.sendRedirect()
			return "redirect:notice.htm";			
		} else {
			return "noticeReg.jsp?error";
		}
		
	}
	
	// ?seq=1
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(@RequestParam("seq") String seq
			, Model model) throws Exception {
		
		NoticeVO notice = this.noticeDao.getNotice(seq);
		
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
		
	}
	
	// ?seq=1
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(NoticeVO notice
			, Model model) throws Exception {
		
		int updateCount = this.noticeDao.update(notice);
		
		if (updateCount == 1) {
			// redirect: == response.sendRedirect()
			return "redirect:noticeDetail.htm?seq=" + notice.getSeq();			
		} else {
			return "redirect:notice.htm";
		}
		
	} // noticeEdit
	
	@GetMapping("/noticeDel.htm")
	public  String noticeDel(@RequestParam("seq") String seq) throws Exception  {
		
		int deleteCount = this.noticeDao.delete(seq) ; 
		
		if(deleteCount == 1) {
			return "redirect:notice.htm";			
		}else {
			return "redirect:noticeDetail.htm?seq=" + seq+"&error" ; 
		} // ifelse 
	}// noticeDel

}
