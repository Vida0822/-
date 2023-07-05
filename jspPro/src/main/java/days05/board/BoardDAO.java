package days05.board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDAO {

	// 1. 글 목록 + 페이징 처리
	ArrayList<BoardDTO> select( int currentPage, int numberPerPage ) throws SQLException;

	// 2. 글 쓰기
	int insert(BoardDTO dto) throws SQLException;

	// 3. 글 보기
	BoardDTO view(int seq) throws SQLException;

	// 4. 조회수 증가 
	void increaseReaded(int seq) throws SQLException;
	
	// 5. 수정하기.
	int update(BoardDTO dto) throws SQLException;
	
	// 6. 원래 비밀번호를 반환하는 메서드 
    String getOriginalPwd(int seq) throws SQLException;
    // 6-2
    int delete(int seq)  throws SQLException;
    
    // 7, 전체 페이지수를 반환하는 메서드 
    public int getTotal()  throws SQLException;
    
    //8. 검색기능이 추가된 select() 
    public ArrayList<BoardDTO> search(int currentPage, int numberPerPage, int searchCondition, String searchWord)  throws SQLException;

    // 9.검색기능이 추가된 getTotal() 
    public int getSearchTotal(int searchCondition, String searchWord)  throws SQLException;
}
