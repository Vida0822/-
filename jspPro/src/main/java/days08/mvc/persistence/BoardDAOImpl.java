package days08.mvc.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import days08.mvc.domain.BoardDTO;
 
public class BoardDAOImpl  implements BoardDAO{

	private Connection conn;
	// getter
	public Connection getConn() {
		return conn;
	}

	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAOImpl() {
		super();		
	}
	// 생성자를 통해서 BoardService 전달(주입)  DI
	public BoardDAOImpl(Connection conn) {
		super();		
		this.conn = conn;
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
		int begin =  ( currentPage-1 ) * numberPerPage + 1 ;
		int  end  = begin + numberPerPage-1;

		String sql = "SELECT * "
				+ "FROM ( "
				+ "        SELECT  ROWNUM no ,  t.* "
				+ "        FROM (  "
				+ "                SELECT seq,writer, email, title, readed, writedate   "
				+ "                FROM cstvsboard  "
				+ "                ORDER BY seq DESC  "
				+ "             ) t "
				+ "     ) m     "
				+ "WHERE m.no BETWEEN ? AND ?";

		try {
			this.pstmt =  this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, begin);
			this.pstmt.setInt(2, end);
			this.rs =  this.pstmt.executeQuery();
	        
			if( rs.next() ) {
				list = new ArrayList<BoardDTO>();
				do {
					seq = rs.getInt("seq");
					writer =  rs.getString("writer");
					email =  rs.getString("email");
					title =  rs.getString("title");
					readed = rs.getInt("readed");
					writedate = rs.getDate("writedate");				
					dto = new BoardDTO(seq, writer, email, title, writedate, readed);
					list.add(dto);
				} while ( rs.next() );
			} // if
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		this.pstmt.close();
		this.rs.close();

		return list;
	}

	@Override
	public int insert(BoardDTO dto) throws SQLException{
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
				+ " WHERE seq =  ?  ";

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
				+ " SET readed = readed + 1 "
				+ " WHERE seq = ? ";

		this.pstmt  = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, seq);
		int rowCount = this.pstmt.executeUpdate();
		this.pstmt.close();
	}
	
	@Override
	public int update(BoardDTO dto) throws SQLException {
		String sql = "UPDATE cstvsboard "
				+ "SET title=?, email=?, content=?, tag = ? "
				+ "WHERE seq = ? AND pwd = ? ";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, dto.getTitle() );
		this.pstmt.setString(2, dto.getEmail() );
		this.pstmt.setString(3, dto.getContent() );
			this.pstmt.setInt(4, dto.getTag());
		this.pstmt.setInt(5, dto.getSeq());
			this.pstmt.setString(6, dto.getPwd());
		
		int rowCount =  this.pstmt.executeUpdate();
		this.pstmt.close();
		return rowCount;
	}
	
	@Override
	public String getOriginalPwd(int seq) throws SQLException {
		String pwd = null;

		String sql = "SELECT pwd "
				+ " FROM cstvsboard "
				+ " WHERE seq =  ? ";

		this.pstmt = this.conn.prepareStatement(sql); 
		this.pstmt.setInt(1, seq);
		this.rs = this.pstmt.executeQuery()	;		
		if( rs.next() ) {
			pwd = rs.getString("pwd");
		}		
		this.pstmt.close();
		this.rs.close();
		return pwd;
	}
	@Override
	public int delete(int seq) throws SQLException {
		String sql = "DELETE FROM  cstvsboard  " 
				+ " WHERE seq =  ? ";		
		this.pstmt = this.conn.prepareStatement(sql); 
		this.pstmt.setInt(1, seq);
		int rowCount   = this.pstmt.executeUpdate();		
		this.pstmt.close();		
		return rowCount; 
		
	}
	@Override
	public int getTotal() throws SQLException {
		String sql = " SELECT  COUNT(*)  "
				+ " FROM  cstvsboard  " ; 
		int total = 0; 
		this.pstmt = this.conn.prepareStatement(sql); 
		this.rs = this.pstmt.executeQuery()	;		
		if( rs.next() ) {
			total = this.rs.getInt(1); 
		}		
		this.pstmt.close();
		this.rs.close();
		return total; 
	} // getTotal
	
	
	
	@Override
	public ArrayList<BoardDTO> search(int currentPage, int numberPerPage
			, int searchCondition, String searchWord) throws SQLException {
		
		ArrayList<BoardDTO> list = null;
		BoardDTO dto = null;

		int seq;        
		String writer;   
		String email; 
		String title; 
		Date writedate; 
		int readed; 
		// BETWEEN ? AND ?
		int begin =  ( currentPage-1 ) * numberPerPage + 1 ;
		int  end  = begin + numberPerPage-1;

		String sql = "SELECT * "
				+ "FROM ( "
				+ "        SELECT  ROWNUM no ,  t.* "
				+ "        FROM (  "
				+ "                SELECT seq,writer, email, title, readed, writedate   "
				+ "                FROM cstvsboard  ";
		
				switch (searchCondition) {
				case 1: // title 
					sql += " WHERE REGEXP_LIKE( title, ?, 'i')  " ;
					break;
				case 2: // content 
					sql += " WHERE REGEXP_LIKE( content, ?, 'i')  " ;
					break;
				case 3: // writer 
					sql += " WHERE REGEXP_LIKE( writer, ?, 'i')  " ;					
					break;
				case 4: // title + content 
					sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR REGEXP_LIKE( content, ?, 'i') " ;					
					break;
				}	// switch 
				
				sql +=  "                ORDER BY seq DESC  "
				+ "             ) t "
				+ "     ) m     "
				+ "WHERE m.no BETWEEN ? AND ?";

		try {
			this.pstmt =  this.conn.prepareStatement(sql);
			
			this.pstmt.setString (1, searchWord );
			if( searchCondition ==4 ) {
				this.pstmt.setString (2, searchWord );
				this.pstmt.setInt(3, begin);
				this.pstmt.setInt(4, end);
			}else {			
				this.pstmt.setInt(2, begin);
				this.pstmt.setInt(3, end);
			}
			this.rs =  this.pstmt.executeQuery();
	        
			if( rs.next() ) {
				list = new ArrayList<BoardDTO>();
				do {
					seq = rs.getInt("seq");
					writer =  rs.getString("writer");
					email =  rs.getString("email");
					title =  rs.getString("title");
					
					// search 추가 : 입력한 검색어 부분 하이라이트 기능 
					if (searchCondition == 1) { 
						title = title.replaceAll(searchWord 
								, String.format("<span style='color:yellow; background-color:red'>%s</span>", searchWord) ); 
					}
					readed = rs.getInt("readed");
					writedate = rs.getDate("writedate");				
					dto = new BoardDTO(seq, writer, email, title, writedate, readed);
					list.add(dto);
				} while ( rs.next() );
			} // if
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		

		this.pstmt.close();
		this.rs.close();

		return list;
	} // search 
	
	
	@Override
	public int getSearchTotal(int searchCondition, String searchWord) throws SQLException{
		String sql = " SELECT  COUNT(*)  "
				+ " FROM  cstvsboard  " ; 
		
		switch (searchCondition) {
		case 1: // title 
			sql += " WHERE REGEXP_LIKE( title, ?, 'i')  " ;
			break;
		case 2: // content 
			sql += " WHERE REGEXP_LIKE( content, ?, 'i')  " ;
			break;
		case 3: // writer 
			sql += " WHERE REGEXP_LIKE( writer, ?, 'i')  " ;					
			break;
		case 4: // title + content 
			sql += " WHERE REGEXP_LIKE( title, ?, 'i') OR REGEXP_LIKE( content, ?, 'i') " ;					
			break;
		}	// switch 
		
		int total = 0; 
		this.pstmt = this.conn.prepareStatement(sql); 
		
		this.pstmt.setString (1, searchWord );
		if( searchCondition ==4 ) {
			this.pstmt.setString (2, searchWord );
		} // if 
		
		this.rs = this.pstmt.executeQuery()	;		
		if( rs.next() ) {
			total = this.rs.getInt(1); 
		}	// if 
		
		this.pstmt.close();
		this.rs.close();
		return total; 
	} // getSearchTotal 


} // BoardDAOImpl 





