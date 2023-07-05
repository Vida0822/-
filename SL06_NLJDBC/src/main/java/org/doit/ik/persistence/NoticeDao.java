package org.doit.ik.persistence;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository; 

// @Component
@Repository
public class NoticeDao {
   
	@Autowired
	private JdbcTemplate jdbcTemplate ; 
	
   // 검색한 결과의 총레코드 수 를 반환하는 메서드 
   public int getCount(String field, String query) throws ClassNotFoundException, SQLException
   {
      String sql = "SELECT COUNT(*) CNT "
                     + " FROM NOTICES "
                     + " WHERE "+field+" LIKE ?";
      
      return this.jdbcTemplate.queryForObject(sql,Integer.class, "%"+query+"%") ; 
   }
   
   // 페이징 처리 + 공지사항 목록
   public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
   {               
      
      int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
      int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...
      
      String sql = " SELECT * "
                     + "  FROM ( "
                     + "                 SELECT ROWNUM NUM, N.* "
                     + "                 FROM ("
                     + "                          SELECT * "
                     + "                          FROM NOTICES "
                     + "                          WHERE "+field+" LIKE ? "
                           + "                   ORDER BY REGDATE DESC"
                           + "                    ) N"
                           + "      ) "
                     +  " WHERE NUM BETWEEN ? AND ? ";
       
      // 이거 해줘서 커넥션 객체 생성 , 예외처리. 일꾼객체... 이 모든 과정 생략 
      List<NoticeVO> list = this.jdbcTemplate.query(sql
    		  , new Object[]{"%"+query+"%", srow, erow}
      		  , new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class)
    		  );
      		// BeanPropertyRowMapper : 만들어진 결과물을 대입되는 List<NoticeVO> 에 자동으로 매핑해줌 
      		//  => 필드명을 다 일치시켜놨기 때문에 자동적으로 빈 객체가 만들어진다 ? ? ? 
      
      return list ; 
   
   } // getNotices
   
   // 공지사항 삭제
   public int delete(String seq) throws ClassNotFoundException, SQLException
   {
       
      String sql = " DELETE  FROM NOTICES "
                       + " WHERE SEQ=?";
      return this.jdbcTemplate.update(sql, seq); 
   }
   
   // 공지사항 수정
   public int update( NoticeVO notice ) throws ClassNotFoundException, SQLException{
      
       
      String sql = "UPDATE NOTICES "
                      + " SET TITLE=?, CONTENT=?, FILESRC=? "
                      + " WHERE SEQ=?";
       
      return this.jdbcTemplate.update(sql, notice.getTitle(),notice.getContent(), notice.getFilesrc(), notice.getSeq() ) ; 
   }
   
   // 해당 공지사항 상세보기. 
   public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
   {
      String sql = " SELECT * "
                     + " FROM NOTICES "
                     + " WHERE SEQ=? ";
    
      return this.jdbcTemplate.queryForObject(
    		  sql 
    		  , new Object[] {seq}
    		  , new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class));  
   }

   // 공지사항 글쓰기
   public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException {
      
      String sql = "INSERT INTO NOTICES"
            + " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
            + " VALUES"
            + " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), ?, ?, ?, SYSDATE, 0, ?)";
      
      return this.jdbcTemplate.update(sql,notice.getTitle(), notice.getContent(), notice.getWriter(), notice.getFilesrc()); 
   }

} // class