package org.doit.ik.service;

import org.doit.ik.domain.Project;
import org.doit.ik.domain.ViewInfo;
import org.doit.ik.mapper.BoardMapper;
import org.doit.ik.mapper.MemberMapper;
import org.doit.ik.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class ViewProjectServiceImpl implements ViewProjectService {
	
	private ProjectMapper projectMapper ; 
	private MemberMapper memberMapper ; 
	
	// 프로젝트 얻어오기 
	@Override
	public Project getProject(String pro_cd) {
		log.info("> ViewProjectServiceImpl.getProject()...");
		return this.projectMapper.getProject() ;
	} // getProject

	// 프로젝트 기본정보 
	@Override
	public ViewInfo getViewInfo(Project project) {
		
		
		return null;
	}

} // ViewProjectServiceImpl
