package days05.board;

public class PageDTO {

	// 필드
	private int currentPage = 1 ; 
	private int numberPerPage = 10; 
	private int numberOfPageBlock = 10; 

	private int start ;
	private int end ;
	private boolean prev, next ;  
	// 이전 버튼을 보이게 할건지 , 다음 버튼을 보이게 할건지 boolean으로 줌

	// 생성자 
	public PageDTO(int currentPage
			, int numberPerPage
			, int numberOfPageBlock
			, int total  	// 총 페이지수와 총 레코드 수를 가져오던 jdbc 과 달리 여기선 총 레코드수만 받을거임 -> 이걸로 총 페이지수 도출 
			) {
		
		// [문제] 페이지 블럭을 클릭해도 그 블럭이 active가 안들어옴 (그냥 게시글 목록만 바뀜) 
		/*
		 * 1. f12 -> 다른 페이지 블럭을 누르면 active 속성이 그 블럭으로 이동하는지 확인 -> ㄴㄴ 
		 * 2. <c:if test="${ pdto.currentPage eq i }">
		 *  -> 이 if문의 값이 true가 안나옴 : 입력(클릭) 해준
		 *  : currentPage를 객체의 멤버변수값으로 등록 안해주고 
		 *  그녕 매개변수로만 사용하고 끝냈기 때문에 pdto.currentPage는 계속 null!		 */ 
		this.currentPage = currentPage; // 문제1 해결 : 이거 삽입 (객체값으로 넣어줌)   this: pageDTO

		int totalPages; // 총 페이지 수 
		totalPages = (int) Math.ceil( (double)total / numberPerPage );  // 총 게시글 수 / 한 페이지당 뿌려지는 게시글 -> 총 페이지 수 
		
		
		this.start = (currentPage -1) /numberOfPageBlock * numberOfPageBlock +1 ;
		this.end = start + numberOfPageBlock - 1;
		end = end > totalPages ? totalPages : end;

		// 버튼 보이게 할 거야? 
		this.prev = this.start > 1;  
		// 만약 페이지 블럭의 첫번째 페이지 번호가 1 이상이면 다음 페이지 블럭으로 넘어가 있는 상태이므로 prev 버튼 띄워야함 
		this.next = this.end < totalPages ; 
		// 만약 페이지 블럭의 마지막 페이지 번호가 총 페이지수이면 다음 페이지 블럭으로 넘어가 있는 상태이므로 prev 버튼 띄워야함 

	} // pageDTO() 


	// getter, setter 
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
} // pageDTO 
