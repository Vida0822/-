package project.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import file.dao.FileDAO;
import file.model.File;
import member.dao.MemberDAO;
import member.model.Member;
import project.dao.DetailCategoryDAO;
import project.dao.ItemSetDAO;
import project.dao.PayDAO;
import project.dao.PlanDAO;
import project.dao.PolicyDAO;
import project.model.DetailCategory;
import project.model.Gift;
import project.model.ItemSet;
import project.model.Plan;
import project.model.Policy;
import project.model.Project;

public class ViewProjectService {
		
	private PayDAO payDAO = new PayDAO(); 
	private DetailCategoryDAO detailCategoryDao = new DetailCategoryDAO(); 
	private FileDAO fileDAO = new FileDAO(); 
	private MemberDAO memberDao = new MemberDAO(); 
	private PlanDAO planDao = new PlanDAO(); 
	private PolicyDAO policyDao = new PolicyDAO(); 
	private ItemSetDAO itemSetDAO = new ItemSetDAO(); 
	

	public ViewInfo getViewInfo(Connection conn, Project project)  {
			
			// 해당 프로젝트의 세부카테고리 객체 (프로젝트가 아닌 이유: 중분류 name 값 얻어오기 위함 ) 
			ViewInfo viewInfo  = null; // 결과 객체 
			
			DetailCategory detailCategory = null;
			String pro_long = null ; 
			ArrayList<File> imageFiles = null ;
			int paySum=0; 
			int ach_rate =0 ; 
			int left_days =0 ; 
			int pro_sup =0; 
			int pro_price =0 ; 
			Date pro_start = null; 
			Date pro_end = null;
			Date pay_date = null ;
			
			
			try {
			// 세부 카테고리 이름 
			detailCategory = detailCategoryDao.selectByProCd(conn, project.getPro_cd());
	
			// 긴제목
			pro_long = project.getPro_long();
			
			// 대표이미지 
			imageFiles = fileDAO.selectAllByPro_cd(conn, project.getPro_cd()); 
			
			// 모인금액 
			paySum = payDAO.SumByProCd(conn, project.getPro_cd()); 
			
			// 달성률
			ach_rate =   (int)(paySum/(float)project.getPro_price()*100);  
			
			// 남은기간 
			left_days = (int) ((project.getPro_end().getTime() - new Date().getTime())/1000/60/60/24)+1;
			
			// 후원자수 
			pro_sup = project.getPro_sup(); 
			
			// 목표금액
			pro_price = project.getPro_price(); 
			
			// 시작일 
			pro_start = project.getPro_start();
			
			// 종료일 
			pro_end = project.getPro_end(); 
			
			// 결제 예상일 = 종료일 + 하루 
			long oneday = 24L * 60 * 60 * 1000 ; 
			pay_date = new Date( pro_end.getTime() +oneday); 
			// System.out.println(pay_date.toString());
			
			} catch (SQLException e) {
				System.out.println("getViewInfo() 쿼리작업 진행 중 오류발생  ");
				e.printStackTrace();
			}
			
			try {
				viewInfo = new ViewInfo(
							detailCategory
							, pro_long
							, imageFiles
							, (int)paySum 
							, ach_rate
							, left_days
							, pro_sup
							, pro_price
							, pro_start
							, pro_end
							, pay_date);
			} catch (Exception e) {
				System.out.println("ViewInfo 객체가 만들어지지 않음");
			}
		return viewInfo ; 
	} //  getViewInfo
	
	
	
	
	
	public ViewCreator getViewCreator(Connection conn, Project project)  {
		
		ViewCreator viewCreator = null;  // 결과 객체 
		
		Member member = null ; 
		File creatorPhoto = null; 
		int lastSession = 0 ; 
		String pro_ct_intro = null; ; 
		
		try {
		// 회원이름 (위한 멤버객체) 
		member = memberDao.selectByCd(conn, project.getM_cd()) ; 
		
		// 회원사진 
		creatorPhoto = fileDAO.selectByMemCd(conn, project.getM_cd()); 
		
		// 마지막 로그인 시간 
		lastSession = 3; 
		
		// 창작자 소개 
		pro_ct_intro = project.getPro_ct_intro(); 
		
		}catch (SQLException e) {
			System.out.println("getViewInfo() 쿼리작업 진행 중 오류발생  ");
		} // trycatch 
		
		try {
		viewCreator = new ViewCreator(member, creatorPhoto, lastSession, pro_ct_intro); 
		}catch (Exception e) {
			System.out.println("viewCreator 객체가 만들어지지 않음");
		} // trycatch 	
		return viewCreator ; 	
	} // getViewCreator
	
	

		public ViewPlan getViewPlan(Connection conn, Project project) {
			
			ViewPlan viewPlan = null; 
			
			Plan projectPlan = null ; 
			Policy policy = null ;
			
			try {
			projectPlan = planDao.selectByCd(conn, project.getPro_cd()); 
			policy = policyDao.selectByCd(conn, project.getPro_cd()); 
			}catch (Exception e) {
				System.out.println("getViewPlan() 쿼리작업 진행 중 오류발생  ");
			}
			try {
			viewPlan = new ViewPlan(projectPlan,policy) ; 
			} catch (Exception e) {
				System.out.println("ViewPlan 객체가 만들어지지 않음");
			}
			return viewPlan ; 
		} // getViewPlan
	
		
		public ArrayList<GiftCard> getGiftCard(Connection conn, ArrayList<Gift> giftList)  {
			
			ArrayList<GiftCard> giftCards = new ArrayList<GiftCard>() ;  // 결과값 List 
			Iterator<Gift> ir = giftList.iterator(); 
			
			while(ir.hasNext()) {
				
				Gift gift = ir.next(); 
				int buyAmount =0 ; 
				int leftAmount =0; 
				int gift_min =0 ;
				String gift_desc = null ; 
				ArrayList<ItemSet> items  = null; 
				
				try {
				// 선물별 후원자수 
				buyAmount = payDAO.countByGiftCd(conn, gift.getGift_cd()) ; 
				
				// 남는 선물개수 
				leftAmount = gift.getGift_amount() - buyAmount ; 
				
				// 선물가격 
				gift_min = gift.getGift_min(); 
				
				// 선물 설명 
				gift_desc = gift.getGift_desc(); 
				
				// 아이템 목록 : 아이템 설정 테이블에서 '선물코드'로 조회 
				items = itemSetDAO.selectByGiftCd(conn, gift.getGift_cd()); 
				
				}catch (Exception e) {
					System.out.println("getGiftCard() 쿼리작업 진행 중 오류발생  ");
				}
				
				try {
				GiftCard giftCard = new GiftCard (gift,buyAmount,leftAmount,gift_min, gift_desc , items) ; 
				giftCards.add(giftCard) ; 
				}catch (Exception e) {
					System.out.println("giftCard 객체가 만들어지지 않음");
				}
			} // while			
			return giftCards ; 
		} // getViewPresent
	
	
		
	
	
	
	
	
} // ViewProjectService
