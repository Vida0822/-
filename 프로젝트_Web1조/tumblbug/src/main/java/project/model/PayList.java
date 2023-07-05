package project.model;

import java.sql.Date;
import java.util.List;

public class PayList {

	private String dtl_ctg_name; // 세부카테고리명
	private String m_name; // 창작자명
	private String pro_long; // 프로젝트 이름
	private int pro_total; // 총 후원금액
	private int pro_price; // 목표금액
	private int remain; // 남은기간
	private String gift_desc; // 선물 설명
	private List<Item> item; // 아이템 이름과 수량이 담긴 객체 리스트
	private int gift_min; // 선물 기본금액
	private int sp_add; // 추가후원금
	private Date gift_dlv; // 선물 예상 전달일
	private Date pro_end; // 종료일
	private int pro_sup;
	private int achv; // 달성률
	private int total; // 최종 후원 금액
	private Supporter supporter; // 후원자 정보
	
	public PayList() {
		super();
	}
	public PayList(String dtl_ctg_name, String m_name, String pro_long, int pro_total, int pro_price, int remain, String gift_desc,
			int gift_min, Date gift_dlv, Date pro_end, int pro_sup, int achv) {
		super();
		this.dtl_ctg_name = dtl_ctg_name;
		this.m_name = m_name;
		this.pro_long = pro_long;
		this.pro_total = pro_total;
		this.pro_price = pro_price;
		this.remain = remain;
		this.gift_desc = gift_desc;
		this.gift_min = gift_min;
		this.gift_dlv = gift_dlv;
		this.pro_end = pro_end;
		this.pro_sup = pro_sup;
		this.achv = achv;
	}

	public int getPro_sup() {
		return pro_sup;
	}
	public void setPro_sup(int pro_sup) {
		this.pro_sup = pro_sup;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	public String getDtl_ctg_name() {
		return dtl_ctg_name;
	}
	public void setDtl_ctg_name(String dtl_ctg_name) {
		this.dtl_ctg_name = dtl_ctg_name;
	}
	public Date getPro_end() {
		return pro_end;
	}
	public void setPro_end(Date pro_end) {
		this.pro_end = pro_end;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getPro_long() {
		return pro_long;
	}
	public void setPro_long(String pro_long) {
		this.pro_long = pro_long;
	}
	public int getPro_total() {
		return pro_total;
	}
	public void setPro_total(int pro_total) {
		this.pro_total = pro_total;
	}
	public int getPro_price() {
		return pro_price;
	}
	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public String getGift_desc() {
		return gift_desc;
	}
	public void setGift_desc(String gift_desc) {
		this.gift_desc = gift_desc;
	}
	public int getGift_min() {
		return gift_min;
	}
	public void setGift_min(int gift_min) {
		this.gift_min = gift_min;
	}
	public int getSp_add() {
		return sp_add;
	}
	public void setSp_add(int sp_add) {
		this.sp_add = sp_add;
	}
	public Date getGift_dlv() {
		return gift_dlv;
	}
	public void setGift_dlv(Date gift_dlv) {
		this.gift_dlv = gift_dlv;
	}
	public int getAchv() {
		return achv;
	}
	public void setAchv(int achv) {
		this.achv = achv;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Supporter getSupporter() {
		return supporter;
	}
	public void setSupporter(Supporter supporter) {
		this.supporter = supporter;
	}
	
} // class
