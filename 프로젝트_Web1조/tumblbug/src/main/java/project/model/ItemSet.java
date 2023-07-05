package project.model;

public class ItemSet {
	
	// 필드 
	private String item_set_cd ; 
	private int item_cnt ; 
	private String gift_cd ; 
	private String item_cd ;
	
	private String item_name ; // 아이템 테이블에 있는 칼럼 (조인해서 얻어올 예정) 
	
	
	// 생성자 
	public ItemSet() {
		super();
	}
	
	public ItemSet(String item_set_cd, int item_cnt, String gift_cd, String item_cd, String item_name) {
		super();
		this.item_set_cd = item_set_cd;
		this.item_cnt = item_cnt;
		this.gift_cd = gift_cd;
		this.item_cd = item_cd;
		this.item_name = item_name;
	}



	// getter, setter 
	public String getItem_set_cd() {
		return item_set_cd;
	}

	public void setItem_set_cd(String item_set_cd) {
		this.item_set_cd = item_set_cd;
	}

	public int getItem_cnt() {
		return item_cnt;
	}

	public void setItem_cnt(int item_cnt) {
		this.item_cnt = item_cnt;
	}

	public String getGift_cd() {
		return gift_cd;
	}

	public void setGift_cd(String gift_cd) {
		this.gift_cd = gift_cd;
	}

	public String getItem_cd() {
		return item_cd;
	}

	public void setItem_cd(String item_cd) {
		this.item_cd = item_cd;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	} 
	
	

	
	
	
		
} // Item 
