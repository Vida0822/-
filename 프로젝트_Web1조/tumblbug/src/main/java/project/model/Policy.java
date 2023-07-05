package project.model;

public class Policy {
	// 필드 
	private String pro_cd; 
	private String tas_policy; 
	private String tas_exc;
	
	// 생성자 
	public Policy() {
		super();
	}
	
	
	
	public Policy(String pro_cd, String tas_policy, String tas_exc) {
		super();
		this.pro_cd = pro_cd;
		this.tas_policy = tas_policy;
		this.tas_exc = tas_exc;
	}



	// 메서드 
	public String getPro_cd() {
		return pro_cd;
	}

	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getTas_policy() {
		return tas_policy;
	}

	public void setTas_policy(String tas_policy) {
		this.tas_policy = tas_policy;
	}

	public String getTas_exc() {
		return tas_exc;
	}

	public void setTas_exc(String tas_exc) {
		this.tas_exc = tas_exc;
	} 
	
	
	
	
} // Policy
