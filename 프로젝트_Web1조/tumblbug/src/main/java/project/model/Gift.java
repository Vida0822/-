package project.model;

import java.util.Date;

public class Gift {
	// 필드 
	private String gift_cd ; /* 선물코드 */
	private String gift_desc ;  /* 선물_설명 */
	private int gift_amount ;  /* 선물_수량 */
	private Date gift_dlv ;  /* 선물_예상_전달일 */
	private String gift_status ;  /* 선물_배송여부 */
	private int gift_min ;  /* 최소_후원금액 */
	private String pro_cd ; /* 프로젝트코드 */
	
	
	// 생성자 
	public Gift() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Gift(String gift_cd, String gift_desc, int gift_amount, Date gift_dlv, String gift_status, int gift_min,
			String pro_cd) {
		super();
		this.gift_cd = gift_cd;
		this.gift_desc = gift_desc;
		this.gift_amount = gift_amount;
		this.gift_dlv = gift_dlv;
		this.gift_status = gift_status;
		this.gift_min = gift_min;
		this.pro_cd = pro_cd;
	}



	// getter, setter 
	public String getGift_cd() {
		return gift_cd;
	}


	public void setGift_cd(String gift_cd) {
		this.gift_cd = gift_cd;
	}


	public String getGift_desc() {
		return gift_desc;
	}


	public void setGift_desc(String gift_desc) {
		this.gift_desc = gift_desc;
	}


	public int getGift_amount() {
		return gift_amount;
	}


	public void setGift_amount(int gift_amount) {
		this.gift_amount = gift_amount;
	}


	public Date getGift_dlv() {
		return gift_dlv;
	}


	public void setGift_dlv(Date gift_dlv) {
		this.gift_dlv = gift_dlv;
	}


	public String getGift_status() {
		return gift_status;
	}


	public void setGift_status(String gift_status) {
		this.gift_status = gift_status;
	}


	public int getGift_min() {
		return gift_min;
	}


	public void setGift_min(int gift_min) {
		this.gift_min = gift_min;
	}


	public String getPro_cd() {
		return pro_cd;
	}


	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}
	
	
	
	
	
	
}
