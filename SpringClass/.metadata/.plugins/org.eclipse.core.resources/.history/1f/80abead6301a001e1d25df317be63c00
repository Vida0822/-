package org.doit.ik;

import org.doit.ik.domain.Project;
import org.doit.ik.domain.ViewInfo;
import org.doit.ik.mapper.BoardMapper;
import org.doit.ik.service.ViewProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/tumblbug/*")
@Log4j
@AllArgsConstructor
public class ProjectController {
	
	private ViewProjectService viewProjectService ; 
	
	/* 핸들러 함수들 구현하세요 ~ */

	
	// 목록보기 핸들러 
	
	
	// 검색하기 핸들러 
	
	
	// 상세보기 핸들러 
	@GetMapping("/view")
	public void view(@RequestParam("pro_cd") String pro_cd
					, Model model) {
		log.info("> /tumblbug/view GET...");
		
		// 1. 프로젝트 얻어와서 
		Project project = viewProjectService.getProject(pro_cd) ; 	
		
		// 2. viewInfo, ... 등등 얻어와서 model에 붙이기 
		// model.addAttribute("viewInfo",viewProjectService.getViewInfo(project)) ;
		// this: ProjectController.view() 
		
	
	} // view
	
	// 후원요청 핸들러 
	
	
	// 후원승인 핸들러 
	
	
	
	
	
}
