package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardMapper {

	List<BoardVO> getList();
	
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO board);
	
	// 페이징 처리 추상메서드 추가
	// 현재 페이지 번호, 한 페이지에 출력할 게시글 수 -> Criteria 클래스 선언
	List<BoardVO> getListWithPaging(Criteria criteria);
	
	int getTotalCount(Criteria criteria); // 총 게시글 수
	
}
