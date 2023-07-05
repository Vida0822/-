package project.model;

import java.util.Date;

public class Pay {
	
	// 필드 
	private String sp_cd; /* 후원_코드 */
	private Date sp_date; /* 후원일 */
	private int sp_total; /* 총결제예정금액 */
	private int sp_add; /* 추가후원금 */
	private Date sp_gift_dlv; /* 선물전달완료일 */
	private String sp_status;  /* 결제상태 */
	private String m_cd; /* 회원코드 */
	private String pro_cd;  /* 프로젝트코드 */
	private String addr_cd; /* 배송지코드 */
	private String tkt_cd; /* 응원권_코드 */
	private String pm_cd;  /* 결제수단코드 */
	private String gift_cd; /* 선물코드 */
	
	// 생성 
	public Pay() {
		super();
		// TODO Auto-generated constructor stub
	}

	// getter, setter 
	public String getSp_cd() {
		return sp_cd;
	}

	public void setSp_cd(String sp_cd) {
		this.sp_cd = sp_cd;
	}

	public Date getSp_date() {
		return sp_date;
	}

	public void setSp_date(Date sp_date) {
		this.sp_date = sp_date;
	}

	public int getSp_total() {
		return sp_total;
	}

	public void setSp_total(int sp_total) {
		this.sp_total = sp_total;
	}

	public int getSp_add() {
		return sp_add;
	}

	public void setSp_add(int sp_add) {
		this.sp_add = sp_add;
	}

	public Date getSp_gift_dlv() {
		return sp_gift_dlv;
	}

	public void setSp_gift_dlv(Date sp_gift_dlv) {
		this.sp_gift_dlv = sp_gift_dlv;
	}

	public String getSp_status() {
		return sp_status;
	}

	public void setSp_status(String sp_status) {
		this.sp_status = sp_status;
	}

	public String getM_cd() {
		return m_cd;
	}

	public void setM_cd(String m_cd) {
		this.m_cd = m_cd;
	}

	public String getPro_cd() {
		return pro_cd;
	}

	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getAddr_cd() {
		return addr_cd;
	}

	public void setAddr_cd(String addr_cd) {
		this.addr_cd = addr_cd;
	}

	public String getTkt_cd() {
		return tkt_cd;
	}

	public void setTkt_cd(String tkt_cd) {
		this.tkt_cd = tkt_cd;
	}

	public String getPm_cd() {
		return pm_cd;
	}

	public void setPm_cd(String pm_cd) {
		this.pm_cd = pm_cd;
	}

	public String getGift_cd() {
		return gift_cd;
	}

	public void setGift_cd(String gift_cd) {
		this.gift_cd = gift_cd;
	}
	

	
	
}
