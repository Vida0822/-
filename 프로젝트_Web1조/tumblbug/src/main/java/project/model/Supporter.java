package project.model;

public class Supporter {

	private String m_tel;
	private String m_email;
	private String addr_cd;
	private String addr_rec;
	private String addr_postal;
	private String addr_detail;
	private String addr_tel;
	private String addr_default;
	private String pm_cd;
	private String pm_default;
	private long card_number;
	private String acnt_bank;
	private long acnt_number;
	
	public Supporter() {
		super();
	}
	public Supporter(String m_tel, String m_email, String addr_cd, String addr_rec, String addr_postal, String addr_detail,
			String addr_tel, String addr_default, String pm_cd, String pm_default, long card_number, String acnt_bank, long acnt_number) {
		super();
		this.m_tel = m_tel;
		this.m_email = m_email;
		this.addr_cd = addr_cd;
		this.addr_rec = addr_rec;
		this.addr_postal = addr_postal;
		this.addr_detail = addr_detail;
		this.addr_tel = addr_tel;
		this.addr_default = addr_default;
		this.pm_cd = pm_cd;
		this.pm_default = pm_default;
		this.card_number = card_number;
		this.acnt_bank = acnt_bank;
		this.acnt_number = acnt_number;
	}
	
	public String getPm_cd() {
		return pm_cd;
	}
	public void setPm_cd(String pm_cd) {
		this.pm_cd = pm_cd;
	}
	public String getAddr_cd() {
		return addr_cd;
	}
	public void setAddr_cd(String addr_cd) {
		this.addr_cd = addr_cd;
	}
	public String getAddr_default() {
		return addr_default;
	}
	public void setAddr_default(String addr_default) {
		this.addr_default = addr_default;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getAddr_rec() {
		return addr_rec;
	}
	public void setAddr_rec(String addr_rec) {
		this.addr_rec = addr_rec;
	}
	public String getAddr_postal() {
		return addr_postal;
	}
	public void setAddr_postal(String addr_postal) {
		this.addr_postal = addr_postal;
	}
	public String getAddr_detail() {
		return addr_detail;
	}
	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	public String getAddr_tel() {
		return addr_tel;
	}
	public void setAddr_tel(String addr_tel) {
		this.addr_tel = addr_tel;
	}
	public String getPm_default() {
		return pm_default;
	}
	public void setPm_default(String pm_default) {
		this.pm_default = pm_default;
	}
	public long getCard_number() {
		return card_number;
	}
	public void setCard_number(long card_number) {
		this.card_number = card_number;
	}
	public String getAcnt_bank() {
		return acnt_bank;
	}
	public void setAcnt_bank(String acnt_bank) {
		this.acnt_bank = acnt_bank;
	}
	public long getAcnt_number() {
		return acnt_number;
	}
	public void setAcnt_number(long acnt_number) {
		this.acnt_number = acnt_number;
	}
	
} // class
