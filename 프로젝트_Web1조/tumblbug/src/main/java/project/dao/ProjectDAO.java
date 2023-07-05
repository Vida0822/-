package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import project.model.DetailCategory;
import project.model.Project;

public class ProjectDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;


	public ProjectDAO() {
		super();		
	}

	public ProjectDAO(Connection conn) { // 
		super();		
		this.conn = conn;
	}

	// insert
	public Project insert(Connection conn, Project project) throws SQLException {
		PreparedStatement pstmt = null ;
		Statement stmt = null;
		ResultSet rs = null ;

		try {
			// 수정필요 : 회원코드 삽입(DB) & DTO, DAO 수정  
			String sql = "insert into project(PRO_CD, PRO_SM, DTL_CTG_CODE, M_CD ) "
					+ "values('PRO'||SEQ_PROJECT.NEXTVAL,? ,?, ? ) ";
			pstmt =  conn.prepareStatement(sql); 
			pstmt.setString(1, project.getPro_sm());
			pstmt.setString(2, project.getDtl_ctg_code());
			pstmt.setString(3, project.getM_cd());
			int insertedCount = pstmt.executeUpdate();

			if (insertedCount > 0) {
				stmt = conn.createStatement();
				rs = stmt.executeQuery("select SEQ_PROJECT.currval from project "); // 현재 insert한 글레코드의 시퀀스번호를 조회해서 rs에 담고 
				if (rs.next()) {
					String newCode = "PRO"+rs.getString(1); // 그 rs의 첫번째 첫번째 칼럼을 얻어와? newNo에 담는...다? 
					return new Project(newCode, // 
							project.getPro_sm(),
							project.getDtl_ctg_code(),
							project.getM_cd()
							);
				}
			} // if 
			return null; 
		}finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt);
		} // finally 
	} // insert
	

	// select (목록출력용) 
	public ArrayList<Project> selectList(Connection conn, int searchCondition, String searchWord) throws SQLException {
		// searchWord? = 세부카테고리코드 
		ArrayList<Project> list = null;
		Project dto = null;
		String sql = "SELECT p.* "
				+ "FROM project p "; 

		if(searchWord!=null) {	
			switch(searchCondition) {
			case 0 :
				sql+= "ORDER BY TO_NUMBER(SUBSTR(pro_cd,4)) ASC ";
				break; 
			case 1 : // 카테고리별 
				if (searchWord.equals("전체")) {
				sql+= "ORDER BY TO_NUMBER(SUBSTR(pro_cd,4)) ASC ";
				} else {
				sql+= "LEFT JOIN DTL_CTG d on p.DTL_CTG_CODE = d.DTL_CTG_CODE "
						+"LEFT JOIN CTG c on d.CTG_CODE = c.CTG_CODE "
						+"WHERE CTG_NAME LIKE '%" + searchWord + "%' ";
				}
				break; 
			case 2 :  // 세부 카테고리별 
				sql+= "LEFT JOIN DTL_CTG d on p.DTL_CTG_CODE = d.DTL_CTG_CODE "
						+"WHERE DTL_CTG_NAME LIKE '%" + searchWord + "%' "; 
				break;
			case 3 : // 인기( 후원자수 ) 
				sql+= "ORDER BY pro_sup DESC NULLS LAST "; 
				break; 
			case 4 : //  시기별 (신규 , 마감임박) 
				sql += "WHERE PRO_STATUS = '진행중' "; 						
				if(searchWord.equals("new")) {
					sql += "ORDER BY pro_start DESC "; 
				}else if(searchWord.equals("end")) {
					sql += "ORDER BY pro_end ASC "; 
				} // if 
				break;
			case 5 : // 상태별 
				sql+= "WHERE PRO_STATUS LIKE '%" + searchWord + "%' ";   // 테스트 필요  
				break;
			case 6 :  // 검색어별 
				if(!searchWord.isBlank()) { // 테스트 
					sql+= "WHERE PRO_LONG LIKE '%" + searchWord + "%' "
				            + " OR PRO_SHORT LIKE '%" + searchWord + "%' "
				            + " OR PRO_SM LIKE '%" + searchWord + "%' "
				            + " OR M_NAME LIKE '%" + searchWord + "%' " ;  
				}
				break;
			case 7 :  // 멤버별 
				sql+= "LEFT JOIN member m on p.m_cd = m.m_cd  "
						+ "WHERE M_CD LIKE '%" + searchWord + "%' ";  // ex) 다른 창작자 
				break;
		}  // switch 
		} // if 
		try {
			this.pstmt = conn.prepareStatement(sql);
			this.rs =  this.pstmt.executeQuery();

			if( rs.next() ) {
				list = new ArrayList<Project>();
				do {
					dto = new Project(
							rs.getString("pro_cd"),
							rs.getString("pro_long"),
							rs.getString("pro_short"), 
							rs.getString("pro_sm"), 
							rs.getString("pro_adult"),
							rs.getString("pro_status"),
							rs.getString("pro_addr"), 
							rs.getString("pro_tag"),
							rs.getString("pro_ct_intro"),
							rs.getString("pro_ct_area"), 							
							rs.getInt("pro_price"),							
							rs.getDate("pro_start"),							
							rs.getDate("pro_end"),							
							rs.getInt("pro_sup")	,
							rs.getString("pay_cd"), 
							rs.getString("dtl_ctg_code"),
							rs.getString("m_cd")
							);
					list.add(dto);
				} while ( rs.next() );
			} // if
		} catch (Exception e) {
			System.out.println(e.toString());
		}finally {
		    JdbcUtil.close(pstmt);
		    JdbcUtil.close(rs);
		}
		return list;
	} // selectList()

	// selectByCd (상세보기용) 
	public Project selectByCd(Connection conn, String pro_cd) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * "
					+ "FROM project "
					+ "WHERE pro_cd =? " ; 
			
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,pro_cd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Project project =  new Project(
						rs.getString("pro_cd"),
						rs.getString("pro_long"),
						rs.getString("pro_short"), 
						rs.getString("pro_sm"), 
						rs.getString("pro_adult"),
						rs.getString("pro_status"),
						rs.getString("pro_addr"), 
						rs.getString("pro_tag"),
						rs.getString("pro_ct_intro"),
						rs.getString("pro_ct_area"), 							
						rs.getInt("pro_price"),							
						rs.getDate("pro_start"),							
						rs.getDate("pro_end"),							
						rs.getInt("pro_sup")	,
						rs.getString("pay_cd"), 
						rs.getString("dtl_ctg_code"),
						rs.getString("m_cd")
						);
				return project;
			}// if
			
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		} // tryfinally 
		return null; // 만약 결과가 없는 경우 null을 반환
	} // selectByCd
	 
	// 요금제 선택 
	public int update(Connection conn, String pay_cd, String pro_cd  ) throws SQLException {
		try (PreparedStatement pstmt = 
				conn.prepareStatement(
						"update project set PAY_CD = ? "
								+ "where pro_cd = ? ")) {
			pstmt.setString(1, pay_cd);
			pstmt.setString(2, pro_cd);
			return pstmt.executeUpdate();
		}
	} // update


}// ProjectDAO
