package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

 // notice.htm 요청 -> 요청 처리하는 컨트롤러 
public class NoticeController implements Controller {

	// 필드 
	private NoticeDao noticeDao ; 
	
	
	public NoticeController() { }
	// 생성자 DI : 생성자 통한 의존성 주입  
	public NoticeController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao ; 
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
				HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView() ; 
		mav.addObject("message", "hello world~") ; // 값을 저장할 model 
		
		//											현재페이지번호	검색조건		검색어
		// 	요청 : /customer/notice.htm?page=2&field=title&query=홍길동   
		String ppage = request.getParameter("page") ; 
		String pfield = request.getParameter("field") ; 
		String pquery = request.getParameter("query") ; 
		
		int page = 1; 
		String field = "title" ; 
		String query = "" ; 
		
		if(ppage != null && ppage.equals("")) {
			page = Integer.parseInt(ppage) ; 
		} // if 
		
		if(pfield != null && pfield.equals("")) {
			field = pfield ; 
		} // if 
		
		if(pquery != null && pquery.equals("")) {
			query = pquery ; 
		} // if 
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query); 		
		mav.addObject("list", list); 
		
		mav.setViewName("notice.jsp"); // 뷰 페이지 
	
		return mav;
	} // handleRequest

	
	
} // NoticeController
