package project.model;

public class Plan {
	
	// 필드 
	private String pro_cd ; 
	private String pp_intro ; 
	private String pp_budget ; 
	private String pp_schd ; 
	private String pp_tintro ; 
	private String pp_gift ;
	
	// 생성자 
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Plan(String pro_cd, String pp_intro, String pp_budget, String pp_schd, String pp_tintro, String pp_gift) {
		super();
		this.pro_cd = pro_cd;
		this.pp_intro = pp_intro;
		this.pp_budget = pp_budget;
		this.pp_schd = pp_schd;
		this.pp_tintro = pp_tintro;
		this.pp_gift = pp_gift;
	}



	// getter, setter 
	public String getPro_cd() {
		return pro_cd;
	}

	public void setPro_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getPp_intro() {
		return pp_intro;
	}

	public void setPp_intro(String pp_intro) {
		this.pp_intro = pp_intro;
	}

	public String getPp_budget() {
		return pp_budget;
	}

	public void setPp_budget(String pp_budget) {
		this.pp_budget = pp_budget;
	}

	public String getPp_schd() {
		return pp_schd;
	}

	public void setPp_schd(String pp_schd) {
		this.pp_schd = pp_schd;
	}

	public String getPp_tintro() {
		return pp_tintro;
	}

	public void setPp_tintro(String pp_tintro) {
		this.pp_tintro = pp_tintro;
	}

	public String getPp_gift() {
		return pp_gift;
	}

	public void setPp_gift(String pp_gift) {
		this.pp_gift = pp_gift;
	} 
} // Plan
