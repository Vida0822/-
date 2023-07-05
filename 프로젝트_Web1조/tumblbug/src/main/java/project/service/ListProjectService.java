package project.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;

import file.dao.FileDAO;
import file.model.File;
import jdbc.connection.ConnectionProvider;
import member.dao.MemberDAO;
import member.model.Member;
import project.dao.DetailCategoryDAO;
import project.dao.PayDAO;
import project.dao.ProjectDAO;
import project.model.DetailCategory;
import project.model.Project;

public class ListProjectService {

	private FileDAO fileDao = new FileDAO(); 
	private DetailCategoryDAO detailCategoryDAO = new DetailCategoryDAO(); 
	private MemberDAO memberDAO = new MemberDAO(); 
	private PayDAO payDAO = new PayDAO(); 


	
	public ArrayList<ProjectCard> getProjectCardList(ArrayList<Project> projectList) { // 나중에 검색조건 들어감 
		try (Connection conn = ConnectionProvider.getConnection()) {
			ArrayList<ProjectCard> projectCardList =  new ArrayList<ProjectCard>(); 		
			Iterator<Project> ir = projectList.iterator();
			
			while(ir.hasNext()) {
				Project project = ir.next(); 
				
				// 이미지 /*수정 필요!!*/
				File file = fileDao.selectByProCd(conn, project.getPro_cd()); 
		//		ArrayList<File> files = null; 

				
				// 세부 카테고리 
				DetailCategory detailCategory= detailCategoryDAO.selectByCd(conn, project.getDtl_ctg_code()); 
				
				// 창작자(멤버) 
				Member member = memberDAO.selectByCd(conn, project.getM_cd()); 
				
				// 모인금액 (총결제예정금액, 총후원금) 
				int paySum = payDAO.SumByProCd(conn, project.getPro_cd());  
				
				// 달성률 
				int ach_rate =  (int)((float)paySum/project.getPro_price()*100); 
				
				// 남은기간
				int pro_end = (int) project.getPro_end().getTime()/1000/60/60/24;
				int now = (int) new Date().getTime()/1000/60/60/24;
				int left_days = pro_end - now;
				
				ProjectCard projectCard = new ProjectCard(file,detailCategory,member,project, ach_rate, paySum, left_days) ; 
				projectCardList.add(projectCard);
			} // while 
		return projectCardList; 
		}catch (Exception e) {
			System.out.println("> ListProjectService() Exception...");
			e.printStackTrace();
			return null;
		} // try 
	}
} // ListProjectService
