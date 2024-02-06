package days03.board;

import java.sql.SQLException;
import java.util.ArrayList;

public class BoardService {

	private BoardDAO dao = null;
	public BoardService() {}
	public BoardService( BoardDAO dao ) {
		this.dao = dao;
	}

	// 게시글 목록을 조회하는 서비스 메서드
	public ArrayList<BoardDTO> selectService() {
		ArrayList<BoardDTO> list = null;
		// 1) 로그 기록
		// 2) list dao.select()
		try {
			System.out.println("> 로그 기록 : 게시글 목록 조회");
			list = this.dao.select();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 게시글 목록을 조회하는 서비스 메서드 + 페이징 처리
	public ArrayList<BoardDTO> selectService(int currentPage, int numberPerPage) {
		ArrayList<BoardDTO> list = null;
		// 1) 로그 기록
		// 2) list dao.select()
		try {
			System.out.println("> 로그 기록 : 게시글 목록 조회");
			list = this.dao.select(currentPage, numberPerPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 게시글 목록을 페이징 처리하는 메서드 [1] 2 3 4 5 6 7 8 9 10 >
	public String pageService(int currentPage, int numberPerPage, int numberOfPageBlock) {
		String pagingBlock = "\t\t";

		int totalPages;
		try {
			totalPages = this.dao.getTotalPages(numberPerPage);
			int start = (currentPage -1) /numberOfPageBlock * numberOfPageBlock +1 ;
			int end = start + numberOfPageBlock - 1;
			end = end > totalPages ? totalPages : end;

			if (start != 1) pagingBlock += "< ";
			for (int j = start; j <= end; j++) {
				pagingBlock += String.format(currentPage==j ? "[%d] " : "%d ", j);
			}
			if (end != totalPages) pagingBlock += ">";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pagingBlock;
	}

	// 게시글을 작성하는 서비스 메서드
	public int insertService(BoardDTO dto) {
		int rowCount = 0;
		System.out.println("> 로그 기록 : 게시글 새글쓰기");
		try {
			rowCount = this.dao.insert(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	// 게시글을 상세보기하는 서비스 메서드
	public BoardDTO viewService(int seq) {
		BoardDTO dto = null;
		System.out.println("> 로그 기록 : 게시글 상세보기" + seq);
		try {
			// this.dao.getConn();
			((BoardDAOImpl)this.dao).getConn().setAutoCommit(false); // 트랜잭션 1
			// 해당 게시글의 조회수를 1 증가시키는 작업
			this.dao.increaseReaded(seq); // UPDATE
			// 해당 게시글의 정보를 얻어오는 작업
			dto = this.dao.view(seq); // SELECT
			((BoardDAOImpl)this.dao).getConn().commit(); // 트랜잭션 2
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				((BoardDAOImpl)this.dao).getConn().rollback(); // 트랜잭션 3
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return dto;
	}

	// 게시글을 삭제하는 서비스 메서드
	public int deleteService(int seq) {
		int rowCount = 0;
		System.out.println("> 로그 기록 : 게시글 삭제하기" + seq);
		try {
			rowCount = this.dao.delete(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	// 게시글을 검색하는 서비스 메서드
	public ArrayList<BoardDTO> searchService(int searchCondition, String searchWord) {
		ArrayList<BoardDTO> list = null;
		try {
			System.out.println("> 로그 기록 : 게시글 검색");
			list = this.dao.search(searchCondition, searchWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 게시글을 검색하는 서비스 메서드 + 페이징 처리
	public ArrayList<BoardDTO> searchService(int searchCondition, String searchWord, int currentPage, int numberPerPage) {
		ArrayList<BoardDTO> list = null;
		try {
			System.out.println("> 로그 기록 : 게시글 검색");
			list = this.dao.search(searchCondition, searchWord, currentPage, numberPerPage);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 게시글 검색을 페이징 처리하는 메서드 [1] 2 3 4 5 6 7 8 9 10 >
	public String pageService(int searchCondition, String searchWord, int currentPage, int numberPerPage, int numberOfPageBlock) {
		String pagingBlock = "\t\t";

		int totalPages;
		try {
			totalPages = this.dao.getTotalPages(searchCondition, searchWord, numberPerPage);
			int start = (currentPage -1) /numberOfPageBlock * numberOfPageBlock +1 ;
			int end = start + numberOfPageBlock - 1;
			end = end > totalPages ? totalPages : end;

			if (start != 1) pagingBlock += "< ";
			for (int j = start; j <= end; j++) {
				pagingBlock += String.format(currentPage==j ? "[%d] " : "%d ", j);
			}
			if (end != totalPages) pagingBlock += ">";

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pagingBlock;
	}

	// 게시글을 수정하는 서비스 메서드
	public int updateService(BoardDTO dto) {
		int rowCount = 0;
		try {
			System.out.println("> 로그 기록 : 게시글 수정");
			rowCount = this.dao.update(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}


}
