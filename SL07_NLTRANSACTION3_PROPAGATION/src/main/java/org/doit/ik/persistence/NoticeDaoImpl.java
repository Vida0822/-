package org.doit.ik.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.doit.ik.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate; 

// @Component
@Repository
public class NoticeDaoImpl implements NoticeDao {

	@Autowired
	private NamedParameterJdbcTemplate npJdbcTemplate;

	//	@Autowired
	//	private DataSourceTransactionManager transactionManager ; 

	// @Autowired
	// private TransactionTemplate transactionTemplate ; 

	// 검색한 결과의 총레코드 수 를 반환하는 메서드 
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT COUNT(*) CNT "
				+ " FROM NOTICES "
				+ " WHERE "+field+" LIKE :query";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("query", "%"+query+"%");

		return this.npJdbcTemplate.queryForObject(sql, parameterSource , Integer.class);
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
				+ "                          WHERE "+field+" LIKE :query "
				+ "                   ORDER BY REGDATE DESC"
				+ "                    ) N"
				+ "      ) "
				+  " WHERE NUM BETWEEN :srow AND :erow ";

		Map<String, Object> paramMap = new HashMap<String, Object> ();
		paramMap.put("query", "%"+query+"%");
		paramMap.put("srow", srow);
		paramMap.put("erow", erow);

		return this.npJdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<NoticeVO> (NoticeVO.class));

	}

	// 공지사항 삭제
	public int delete(String seq) throws ClassNotFoundException, SQLException
	{

		String sql = " DELETE  FROM NOTICES "
				+ " WHERE SEQ=:seq";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("seq", seq);

		return this.npJdbcTemplate.update(sql, parameterSource);

	}

	// 공지사항 수정
	public int update( NoticeVO notice ) throws ClassNotFoundException, SQLException{


		String sql = "UPDATE NOTICES "
				+ " SET TITLE=:title, CONTENT=:content, FILESRC=:filesrc "
				+ " WHERE SEQ=:seq";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);

		return this.npJdbcTemplate.update(sql, parameterSource);

		/*
      MapSqlParameterSource parameterSource = new MapSqlParameterSource();
      parameterSource.addValue("title", notice.getTitle());
      parameterSource.addValue("content", notice.getContent());
      parameterSource.addValue("filesrc", notice.getFilesrc());
      parameterSource.addValue("seq", notice.getSeq());

      return this.npJdbcTemplate.update(sql, parameterSource);
		 */

	}

	// 해당 공지사항 상세보기. 
	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT * "
				+ " FROM NOTICES "
				+ " WHERE SEQ=:seq";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("seq", seq);

		return this.npJdbcTemplate.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<NoticeVO> (NoticeVO.class));

	}

	// 공지사항 글쓰기
	public int insert(NoticeVO notice) throws ClassNotFoundException, SQLException {

		String sql = "INSERT INTO NOTICES"
				+ " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				+ " VALUES"
				+ " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";

		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);

		return this.npJdbcTemplate.update(sql, parameterSource);

	}

	// 트랜잭션 처리가 안된 메서드 
	/*
@Override
public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {

	// A. 공지사항 쓰기 
	String sql = "INSERT INTO NOTICES"
            + " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
            + " VALUES"
            + " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";

      SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
      int insertCount = this.npJdbcTemplate.update(sql, parameterSource);

     // B. 포인트 증가 
      sql = " UPDATE member "
      		+ " SET point = point+1 "
      		+ " WHERE id=:id  " ; 

      MapSqlParameterSource paramSource = new MapSqlParameterSource();
      paramSource.addValue("id", id);      
      int updateCount = this.npJdbcTemplate.update(sql, paramSource);

} // insertAndPointUpOfMember
	 */

	/*
   // 2. transactionManager를 사용해서 트랜잭션 처리 
   @Override
   public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {

	   // A. 공지사항 쓰기 
	   String sql = "INSERT INTO NOTICES"
			   + " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
			   + " VALUES"
			   + " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";

	   // B. 포인트 증가 
	   String sql2 = " UPDATE member "
			   + " SET point = point+1 "
			   + " WHERE id= :id  " ; 

	   TransactionDefinition definition = new DefaultTransactionDefinition(); 
	   TransactionStatus status = this.transactionManager.getTransaction(definition) ; 
	   // 다른 트랜잭션과 충돌(중첩)될 경우 어떻게 트랜잭션을 처리할지 
	   // 격리성 관련 설정 상태 
	   try {
		   // A 
		   SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
		   int insertCount = this.npJdbcTemplate.update(sql, parameterSource);

		   // B 
		   MapSqlParameterSource paramSource = new MapSqlParameterSource();
		   paramSource.addValue("id", id);      
		   int updateCount = this.npJdbcTemplate.update(sql2, paramSource);

		   // 커밋 
		   this.transactionManager.commit(status);
	} catch (Exception e) {
		// 롤백 
		this.transactionManager.rollback(status); 
	}

   } // insertAndPointUpOfMember
	 */
	/*
	// 3. transactionTemplate를 사용해서 트랜잭션 처리 
	@Override
	public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {

		// A. 공지사항 쓰기 
		String sql = "INSERT INTO NOTICES"
				+ " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				+ " VALUES"
				+ " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";

		// B. 포인트 증가 
		String sql2 = " UPDATE member "
				+ " SET point = point+1 "
				+ " WHERE id= :id  " ; 

		// p. 517 
		this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
		
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// A 
				SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
				int insertCount = npJdbcTemplate.update(sql, parameterSource);

				// B 
				MapSqlParameterSource paramSource = new MapSqlParameterSource();
				paramSource.addValue("id", id);      
				int updateCount = npJdbcTemplate.update(sql2, paramSource);
				
			} // doInTransactionWithoutResult
		}) ;  // execute

	} // insertAndPointUpOfMember
	*/
	/*
	// 4. 선언적 트랜잭션 처리 中 설정파일 (tx:advice 태그) 
	@Override
	public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {

		// A. 공지사항 쓰기 
		String sql = "INSERT INTO NOTICES"
	            + " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
	            + " VALUES"
	            + " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";

	      SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
	      int insertCount = this.npJdbcTemplate.update(sql, parameterSource);

	     // B. 포인트 증가 
	      sql = " UPDATE member "
	      		+ " SET point = point+1 "
	      		+ " WHERE id=:id  " ; 

	      MapSqlParameterSource paramSource = new MapSqlParameterSource();
	      paramSource.addValue("id", id);      
	      int updateCount = this.npJdbcTemplate.update(sql, paramSource);

	} // insertAndPointUpOfMember
	*/
	// 5. annotation 사용 - 트랜잭션 처리 
	@Override
	@Transactional(propagation = Propagation.REQUIRED )
	public void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException {
		
		// A. 공지사항 쓰기 
		String sql = "INSERT INTO NOTICES"
				+ " ( SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				+ " VALUES"
				+ " ( (SELECT MAX(TO_NUMBER(SEQ))+1 FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
		int insertCount = this.npJdbcTemplate.update(sql, parameterSource);
		
		// B. 포인트 증가 
		sql = " UPDATE member "
				+ " SET point = point+1 "
				+ " WHERE id=:id  " ; 
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);      
		int updateCount = this.npJdbcTemplate.update(sql, paramSource);
		
	} // insertAndPointUpOfMember
} // class