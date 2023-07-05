package project.model;

public class Payment {
	
	
	// 필드 
	private String pay_cd;  // 요금제코드
	private String pay_name;  // 요금제이름
	private String pay_fee;  //  수수료
	
	
	// 생성자 
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(String pay_cd, String pay_name, String pay_fee) {
		super();
		this.pay_cd = pay_cd;
		this.pay_name = pay_name;
		this.pay_fee = pay_fee;
	}
	
	// getter, setter 
	public String getPay_cd() {
		return pay_cd;
	}
	public void setPay_cd(String pay_cd) {
		this.pay_cd = pay_cd;
	}
	public String getPay_name() {
		return pay_name;
	}
	public void setPay_name(String pay_name) {
		this.pay_name = pay_name;
	}
	public String getPay_fee() {
		return pay_fee;
	}
	public void setPay_fee(String pay_fee) {
		this.pay_fee = pay_fee;
	}
	
	
	
	
	
}
