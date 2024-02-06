package org.doit.ik.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/common/*")
@Log4j
public class CommonController {
	
//	 	/common/accessError.htm -> 에러 발생시 시켜줄 요청 
	@GetMapping("/accessError.htm")
	public String accessDenied(Model model, Authentication auth) throws Exception{
		log.info("> /common/accessEror.htm...Get") ; 
		model.addAttribute("msg", "Access Denied"); 
		return "/common/accessError" ;
		
		
	} // accessDenied 
} //  CommonController
