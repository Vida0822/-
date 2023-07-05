package org.doit.ik.persistence;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.transaction.annotation.Transactional; 

// @Transactional
public interface NoticeDao {
	
   
   // 검색한 결과의 총레코드 수 를 반환하는 메서드 
   public int getCount(String field, String query) throws ClassNotFoundException, SQLException;
   
   // 페이징 처리 + 공지사항 목록
   public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
   
   // 공지사항 삭제
   public int delete(String seq) throws ClassNotFoundException, SQLException;
   
   // 공지사항 수정
   public int update( NoticeVO notice ) throws ClassNotFoundException, SQLException;
   
   // 해당 공지사항 상세보기. 
   public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;

   // 공지사항 글쓰기
   public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException;
   
   /*
   // 트랜잭션 처리를 위한 메서드 추가
   // @Transactional
   public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException;
*/
   
} // class