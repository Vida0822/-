package org.doit.ik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

 // noticeDetail.htm 요청 -> 요청 처리하는 컨트롤러 
public class NoticeDetailController implements Controller {

	// 필드 
	private NoticeDao noticeDao ; 
	
	// 생성자 
	public NoticeDetailController() { }
	
	// setter을 통한 주입 
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
				HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("noticeDetail.jsp") ; 
		String seq = request.getParameter("seq") ; 
		NoticeVO notice = this.noticeDao.getNotice(seq); 		
		mav.addObject("notice", notice); 
			
		return mav;
	} // handleRequest

	
	
} // NoticeController
