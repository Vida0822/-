package project.model;

import java.util.Date;

public class Project {
	
	private String pro_cd; // insert 
	private String pro_long;
	private String pro_short;
	private String pro_sm; // insert 
	private String pro_adult; //default 
	private String pro_status;// default 
	private String pro_addr;
	private String pro_tag;
	private String pro_ct_intro; 
	private String pro_ct_area;
	private String pay_cd;
	private String dtl_ctg_code; //insert 
	private String m_cd;  
	private int pro_price ; /* 목표금액 */
	private Date pro_start ;   /* 시작일 */
	private Date pro_end ; /* 종료일 */
	private int pro_sup ; 
	
	// 생성자 
	
	public Project() {
		super();
	}
	
	// insert 용 
	public Project( String pro_sm, String dtl_ctg_code, String m_cd) {
		super();
		this.pro_cd = pro_cd; 
		this.pro_sm = pro_sm;
		this.dtl_ctg_code = dtl_ctg_code;
		this.m_cd = m_cd;
	}
	public Project(String pro_cd, String pro_sm, String dtl_ctg_code, String m_cd) {
		super();
		this.pro_cd = pro_cd; 
		this.pro_sm = pro_sm;
		this.dtl_ctg_code = dtl_ctg_code;
		this.m_cd = m_cd;
	}

	
	
	// List select 용 
	public Project(String pro_cd, String pro_long, String pro_short, String pro_sm, String pro_adult, String pro_status,
			String pro_addr, String pro_tag, String pro_ct_intro, String pro_ct_area, String pay_cd,
			String dtl_ctg_code, String m_cd) {
		super();
		this.pro_cd = pro_cd;
		this.pro_long = pro_long;
		this.pro_short = pro_short;
		this.pro_sm = pro_sm;
		this.pro_adult = pro_adult;
		this.pro_status = pro_status;
		this.pro_addr = pro_addr;
		this.pro_tag = pro_tag;
		this.pro_ct_intro = pro_ct_intro;
		this.pro_ct_area = pro_ct_area;
		this.pay_cd = pay_cd;
		this.dtl_ctg_code = dtl_ctg_code;
		this.m_cd = m_cd;
	}
	
	
	public Project(String pro_cd, String pro_long, String pro_short, String pro_sm, String pro_adult, String pro_status,
			String pro_addr, String pro_tag, String pro_ct_intro, String pro_ct_area,
			 int pro_price, Date pro_start, Date pro_end, int pro_sup,  String pay_cd,String dtl_ctg_code,String m_cd) {
		super();
		this.pro_cd = pro_cd;
		this.pro_long = pro_long;
		this.pro_short = pro_short;
		this.pro_sm = pro_sm;
		this.pro_adult = pro_adult;
		this.pro_status = pro_status;
		this.pro_addr = pro_addr;
		this.pro_tag = pro_tag;
		this.pro_ct_intro = pro_ct_intro;
		this.pro_ct_area = pro_ct_area;
		this.pay_cd = pay_cd;
		this.dtl_ctg_code = dtl_ctg_code;
		this.m_cd = m_cd;
		this.pro_price = pro_price;
		this.pro_start = pro_start;
		this.pro_end = pro_end;
		this.pro_sup = pro_sup;
	}

	// getter, setter 
	public String getPro_cd() {
		return pro_cd;
	}
	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getPro_long() {
		return pro_long;
	}

	public void setPro_long(String pro_long) {
		this.pro_long = pro_long;
	}

	public String getPro_short() {
		return pro_short;
	}

	public void setPro_short(String pro_short) {
		this.pro_short = pro_short;
	}

	public String getPro_sm() {
		return pro_sm;
	}

	public void setPro_sm(String pro_sm) {
		this.pro_sm = pro_sm;
	}

	public String getPro_adult() {
		return pro_adult;
	}

	public void setPro_adult(String pro_adult) {
		this.pro_adult = pro_adult;
	}

	public String getPro_status() {
		return pro_status;
	}

	public void setPro_status(String pro_status) {
		this.pro_status = pro_status;
	}

	public String getPro_addr() {
		return pro_addr;
	}

	public void setPro_addr(String pro_addr) {
		this.pro_addr = pro_addr;
	}

	public String getPro_tag() {
		return pro_tag;
	}

	public void setPro_tag(String pro_tag) {
		this.pro_tag = pro_tag;
	}

	public String getPro_ct_intro() {
		return pro_ct_intro;
	}

	public void setPro_ct_intro(String pro_ct_intro) {
		this.pro_ct_intro = pro_ct_intro;
	}

	public String getPro_ct_area() {
		return pro_ct_area;
	}

	public void setPro_ct_area(String pro_ct_area) {
		this.pro_ct_area = pro_ct_area;
	}

	public String getPay_cd() {
		return pay_cd;
	}

	public void setPay_cd(String pay_cd) {
		this.pay_cd = pay_cd;
	}

	public String getDtl_ctg_code() {
		return dtl_ctg_code;
	}

	public void setDtl_ctg_code(String dtl_ctg_code) {
		this.dtl_ctg_code = dtl_ctg_code;
	}

	public String getM_cd() {
		return m_cd;
	}

	public void setM_cd(String m_cd) {
		this.m_cd = m_cd;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}

	public Date getPro_start() {
		return pro_start;
	}

	public void setPro_start(Date pro_start) {
		this.pro_start = pro_start;
	}

	public Date getPro_end() {
		return pro_end;
	}

	public void setPro_end(Date pro_end) {
		this.pro_end = pro_end;
	}

	public int getPro_sup() {
		return pro_sup;
	}

	public void setPro_sup(int pro_sup) {
		this.pro_sup = pro_sup;
	}
	
	
	
	
	
	
}// Project
