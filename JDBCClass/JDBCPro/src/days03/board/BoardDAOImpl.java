package days03.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAOImpl implements BoardDAO { // DB처리 담당

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public Connection getConn() {
		return conn;
	}
	
	public BoardDAOImpl() {
		super();
	}
	// 생성자를 통해 BoardService에서 전달(주입) 받는다 DI( 의존성 주입 )
	public BoardDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	// 단위테스트
	@Override
	public ArrayList<BoardDTO> select() throws SQLException {
		ArrayList<BoardDTO> list = null;
		BoardDTO dto = null;
		int seq;   
		String writer;
		String email;
		String title;
		Date writedate;         
		int readed;

		String sql = "SELECT seq, writer, email, title, readed, writedate "
				+ "FROM cstvsboard "
				+ "ORDER BY seq DESC ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.rs = this.pstmt.executeQuery();

		if (rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				seq = rs.getInt("seq");
				writer = rs.getString("writer");
				email = rs.getString("email");
				title = rs.getString("title");
				writedate = rs.getDate("writedate");
				readed = rs.getInt("readed");

				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				list.add(dto);
			} while (rs.next());
		}//if

		this.rs.close();
		this.pstmt.close();

		return list;
	}

	@Override
	public ArrayList<BoardDTO> select(int currentPage, int numberPerPage) throws SQLException {
		ArrayList<BoardDTO> list = null;
		BoardDTO dto = null;
		int seq;   
		String writer;
		String email;
		String title;
		Date writedate;         
		int readed;
		// BETWEEN ? AND ?
		int begin = numberPerPage * ( currentPage - 1 ) + 1;
		int end = numberPerPage * currentPage; // begin + numberPerPage - 1

		String sql = "SELECT * "
				+ "FROM ( "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM ( "
				+ "        SELECT seq, writer, email, title, readed, writedate "
				+ "        FROM cstvsboard "
				+ "        ORDER BY seq DESC "
				+ "    ) t "
				+ ") m "
				+ "WHERE m.no BETWEEN ? AND ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, begin);
		this.pstmt.setInt(2, end);
		this.rs = this.pstmt.executeQuery();

		if (rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				seq = rs.getInt("seq");
				writer = rs.getString("writer");
				email = rs.getString("email");
				title = rs.getString("title");
				writedate = rs.getDate("writedate");
				readed = rs.getInt("readed");

				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				list.add(dto);
			} while (rs.next());
		}//if

		this.rs.close();
		this.pstmt.close();

		return list;
	}

	@Override
	public int getTotalPages(int numberPerPage) throws SQLException {
		String sql = "SELECT  COUNT(*) n,   CEIL( COUNT(*) / ? ) m " 
				+ " FROM  cstvsboard";
		int totalPages = 0;

		this.pstmt =  this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, numberPerPage);
		this.rs =  this.pstmt.executeQuery();

		this.rs.next();
		totalPages = rs.getInt("m");

		this.rs.close();
		this.pstmt.close();

		return totalPages; 
	}

	@Override
	public int insert(BoardDTO dto) throws SQLException {
		int rowCount = 0;
		String sql = "INSERT INTO cstvsboard (seq, writer, pwd, email, title, tag, content) "
				+ "VALUES (SEQ_CSTVSBOARD.NEXTVAL, ?, ?, ? , ? , ? , ? )";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1,  dto.getWriter() );
		this.pstmt.setString(2,  dto.getPwd() );
		this.pstmt.setString(3,  dto.getEmail() );
		this.pstmt.setString(4,  dto.getTitle() );
		this.pstmt.setInt(5, dto.getTag());
		this.pstmt.setString(6,  dto.getContent() );

		rowCount = this.pstmt.executeUpdate(); 
		this.pstmt.close();
		return rowCount;
	}

	@Override
	public BoardDTO view(int seq) throws SQLException {
		String sql =     "SELECT seq,  writer, email, title, readed , writedate , content "
				+ " FROM cstvsboard "
				+ " WHERE seq =  ? ";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq);  //  WHERE seq = ? 
		this.rs = this.pstmt.executeQuery();

		BoardDTO dto = null;
		if( this.rs.next() ) {
			dto = new BoardDTO();
			dto.setSeq(seq);
			dto.setWriter(this.rs.getString("writer"));
			dto.setEmail(this.rs.getString("email"));
			dto.setTitle(this.rs.getString("title"));
			dto.setReaded(this.rs.getInt("readed"));
			dto.setWritedate(this.rs.getDate("writedate"));
			dto.setContent(this.rs.getString("content"));
		} // 

		return dto;
	}

	@Override
	public void increaseReaded(int seq) throws SQLException {
		String sql = "UPDATE cstvsboard "
				+ "SET readed = readed + 1 "
				+ "WHERE seq = ? ";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq);
		int rowCount = this.pstmt.executeUpdate();
		this.pstmt.close();
	}

	@Override
	public int delete(int seq) throws SQLException {
		String sql = "DELETE FROM cstvsboard "
				+ "WHERE seq = ? ";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq);
		int rowCount = this.pstmt.executeUpdate();
		this.pstmt.close();
		return rowCount;
	}
	@Override
	public ArrayList<BoardDTO> search(int searchCondition, String searchWord) throws SQLException {
		ArrayList<BoardDTO> list = null;
		BoardDTO dto = null;
		int seq;   
		String writer;
		String email;
		String title;
		Date writedate;         
		int readed;

		String sql = "SELECT seq, writer, email, title, readed, writedate "
				+ "FROM cstvsboard ";
		// 검색조건, 검색어 WHERE 조건절 추가
		switch (searchCondition) {
		case 1: // 제목
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') ";
			break;
		case 2: // 내용
			sql += "WHERE REGEXP_LIKE(content, ?, 'i') ";
			break;
		case 3: // 작성자
			sql += "WHERE REGEXP_LIKE(writer, ?, 'i') ";
			break;
		case 4: // 제목 + 내용
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') OR REGEXP_LIKE(content, ?, 'i') ";
			break;
		}
		/*
		if (searchCondition == 1) {
			sql += "WHERE title LIKE ? ";
		} else if (searchCondition == 2) {
			sql += "WHERE content LIKE ? ";
		} else if (searchCondition == 3) {
			sql += "WHERE writer LIKE ? ";
		} else if (searchCondition == 4) {
			sql += "WHERE title LIKE ? OR content LIKE ? ";
		}
		 */
		sql += "ORDER BY seq DESC ";
		// System.out.println(sql); // 쿼리 확인

		this.pstmt = this.conn.prepareStatement(sql);
		// ?, ? 파라미터
		this.pstmt.setString(1, searchWord);
		if (searchCondition == 4) {
			this.pstmt.setString(2, searchWord);
		}
		/*
		this.pstmt.setString(1, "%" + searchWord + "%");
		if (searchCondition == 4) {
			this.pstmt.setString(2, "%" + searchWord + "%");
		}
		 */
		this.rs = this.pstmt.executeQuery();

		if (rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				seq = rs.getInt("seq");
				writer = rs.getString("writer");
				email = rs.getString("email");
				title = rs.getString("title");
				writedate = rs.getDate("writedate");
				readed = rs.getInt("readed");

				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				list.add(dto);
			} while (rs.next());
		}//if

		this.rs.close();
		this.pstmt.close();

		return list;
	}

	@Override
	public ArrayList<BoardDTO> search(int searchCondition, String searchWord, int currentPage, int numberPerPage) throws SQLException {
		ArrayList<BoardDTO> list = null;
		BoardDTO dto = null;
		int seq;   
		String writer;
		String email;
		String title;
		Date writedate;         
		int readed;
		// BETWEEN ? AND ?
		int begin = numberPerPage * ( currentPage - 1 ) + 1;
		int end = numberPerPage * currentPage; // begin + numberPerPage - 1

		String sql = "SELECT * "
				+ "FROM ( "
				+ "    SELECT ROWNUM no, t.* "
				+ "    FROM ( "
				+ "        SELECT seq, writer, email, title, readed, writedate "
				+ "        FROM cstvsboard ";
		// 검색조건, 검색어 WHERE 조건절 추가
		switch (searchCondition) {
		case 1: // 제목
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') ";
			break;
		case 2: // 내용
			sql += "WHERE REGEXP_LIKE(content, ?, 'i') ";
			break;
		case 3: // 작성자
			sql += "WHERE REGEXP_LIKE(writer, ?, 'i') ";
			break;
		case 4: // 제목 + 내용
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') OR REGEXP_LIKE(content, ?, 'i') ";
			break;
		}
		sql += "        ORDER BY seq DESC "
				+ "    ) t "
				+ ") m "
				+ "WHERE m.no BETWEEN ? AND ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, searchWord);
		if (searchCondition == 4) {
			this.pstmt.setString(2, searchWord);
			this.pstmt.setInt(3, begin);
			this.pstmt.setInt(4, end);
		} else {
			this.pstmt.setInt(2, begin);
			this.pstmt.setInt(3, end);
		}

		this.rs = this.pstmt.executeQuery();

		// System.out.println(sql); // 쿼리 확인

		if (rs.next()) {
			list = new ArrayList<BoardDTO>();
			do {
				seq = rs.getInt("seq");
				writer = rs.getString("writer");
				email = rs.getString("email");
				title = rs.getString("title");
				writedate = rs.getDate("writedate");
				readed = rs.getInt("readed");

				dto = new BoardDTO(seq, writer, email, title, writedate, readed);
				list.add(dto);
			} while (rs.next());
		}//if

		this.rs.close();
		this.pstmt.close();

		return list;
	}
	
	@Override
	public int getTotalPages(int searchCondition, String searchWord, int numberPerPage) throws SQLException {
		String sql = "SELECT  COUNT(*) n,   CEIL( COUNT(*) / ? ) m " 
				+ " FROM  cstvsboard ";
		// 검색조건, 검색어 WHERE 조건절 추가
		switch (searchCondition) {
		case 1: // 제목
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') ";
			break;
		case 2: // 내용
			sql += "WHERE REGEXP_LIKE(content, ?, 'i') ";
			break;
		case 3: // 작성자
			sql += "WHERE REGEXP_LIKE(writer, ?, 'i') ";
			break;
		case 4: // 제목 + 내용
			sql += "WHERE REGEXP_LIKE(title, ?, 'i') OR REGEXP_LIKE(content, ?, 'i') ";
			break;
		}
		
		int totalPages = 0;

		this.pstmt =  this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, numberPerPage);
		this.pstmt.setString(2, searchWord);
		if (searchCondition == 4) {
			this.pstmt.setString(3, searchWord);
		}
		this.rs =  this.pstmt.executeQuery();

		this.rs.next();
		totalPages = rs.getInt("m");

		this.rs.close();
		this.pstmt.close();

		return totalPages; 
	}

	@Override
	public int update(BoardDTO dto) throws SQLException {
		String sql = "UPDATE cstvsboard "
				+ "SET title = ?, content = ?, email = ? "
				+ "WHERE seq = ? ";

		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dto.getTitle());
		this.pstmt.setString(2, dto.getContent());
		this.pstmt.setString(3, dto.getEmail());
		this.pstmt.setInt(4, dto.getSeq());
		int rowCount = this.pstmt.executeUpdate();
		this.pstmt.close();
		return rowCount;
	}


}
