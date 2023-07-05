package org.doit.ik.service;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardService {
	
	List<BoardVO> getList();
	
	void register(BoardVO board);
	
	BoardVO get(Long bno);
	
	boolean remove(Long bno);
	
	boolean modify(BoardVO board);
	
	// 페이징 처리
	List<BoardVO> getListWithPage(Criteria criteria);
	
	int getTotal(Criteria criteria);

}
