package settings.model;

import java.sql.SQLException;

public class PageDTO {
	
	private int currentPage = 1; // 현재 페이지 번호
	private int numberPerPage = 10; // 한 페이지 출력할 게시글 수
	private int numberOfPageBlock = 10; // 페이지 블럭 수
	private int start;
	private int end;
	private boolean prev, next; // 이전버튼, 다음버튼 보이게 할건지 말건지
	// total = 총 레코드 수
	
	public PageDTO(int currentPage, int numberPerPage, int numberOfPageBlock, int total) {
		int totalPages; // 총 페이지수
		totalPages = (int)Math.ceil( (double)total / numberPerPage );
		
		this.currentPage = currentPage; // 이거 없으면 currentPage 계속 1
		this.start = (currentPage - 1) / numberOfPageBlock * numberOfPageBlock + 1;
		this.end= start + numberOfPageBlock - 1;
		this.end = end > totalPages ? totalPages : end;

		this.prev = this.start > 1;
		this.next = end < totalPages;

	} // constructor

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumberPerPage() {
		return numberPerPage;
	}

	public void setNumberPerPage(int numberPerPage) {
		this.numberPerPage = numberPerPage;
	}

	public int getNumberOfPageBlock() {
		return numberOfPageBlock;
	}

	public void setNumberOfPageBlock(int numberOfPageBlock) {
		this.numberOfPageBlock = numberOfPageBlock;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}
	
} // class
