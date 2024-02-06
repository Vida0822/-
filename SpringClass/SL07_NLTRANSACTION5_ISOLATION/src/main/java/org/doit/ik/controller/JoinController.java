package org.doit.ik.controller;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.persistence.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.NoArgsConstructor;

@Controller
@RequestMapping("/joinus/*")
@NoArgsConstructor
public class JoinController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/login.htm")
	public String login() throws Exception {
		return "login.jsp";
	}
	
	@GetMapping("/join.htm")
	public String join() throws Exception {
		return "join.jsp";
	}
	
	// 문제) 회원가입 -> home 으로 이동
	@PostMapping("/join.htm")
	public String join(MemberVO member) throws Exception {
		int insertCount = this.memberDao.insert(member);
		if (insertCount == 1) {
			// redirect: == response.sendRedirect()
			return "redirect:../index.htm";			
		} else {
			return "redirect:/join.jsp?error";
		}
		
	}

}
