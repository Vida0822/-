package days03.board;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardDAO {
	
	// 1. 추상메서드 - 게시글 목록 조회
	ArrayList<BoardDTO> select() throws SQLException;
	
	// 1-2. 추상메서드 - 게시글 목록 조회 + 페이징 처리 구현까지 한 함수
	ArrayList<BoardDTO> select(int currentPage, int numberPerPage) throws SQLException;
	
	// 1-3. 추상메서드 - 총페이지수 반환
	int getTotalPages(int numberPerPage) throws SQLException;

	// 2. 추상메서드 - 게시글 새글쓰기
	int insert(BoardDTO dto) throws SQLException;

	// 3. 추상메서드 - 게시글 상세보기
	BoardDTO view(int seq) throws SQLException;

	// 4. 추상메서드 - 조회수 증가
	void increaseReaded(int seq) throws SQLException;

	// 5. 추상메서드 - 게시글 삭제
	int delete(int seq) throws SQLException;

	// 6. 추상메서드 - 게시글 검색
	ArrayList<BoardDTO> search(int searchCondition, String searchWord) throws SQLException;
	
	// 6-2. 추상메서드 - 게시글 검색 + 페이징 처리 구현
	ArrayList<BoardDTO> search(int searchCondition, String searchWord, int currentPage, int numberPerPage) throws SQLException;
	
	// 6-3. 추상메서드 - 총페이지수 반환
	int getTotalPages(int searchCondition, String searchWord, int numberPerPage) throws SQLException;

	// 7. 추상메서드 - 게시글 수정
	int update(BoardDTO dto) throws SQLException;
	
}
