package project.model;

public class DetailCategory {
	
	// 필드 
	private String dtl_ctg_code; 
	private String dtl_ctg_name; 
	private String ctg_code;
	
	// 생성자 
	public DetailCategory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DetailCategory(String ctg_code) {
		super();
		this.ctg_code = ctg_code;
	}
	
	public DetailCategory(String dtl_ctg_code, String dtl_ctg_name, String ctg_code) {
		super();
		this.dtl_ctg_code = dtl_ctg_code;
		this.dtl_ctg_name = dtl_ctg_name;
		this.ctg_code = ctg_code;
	}

	// getter, setter 
	public String getDtl_ctg_code() {
		return dtl_ctg_code;
	}

	public void setDtl_ctg_code(String dtl_ctg_code) {
		this.dtl_ctg_code = dtl_ctg_code;
	}

	public String getDtl_ctg_name() {
		return dtl_ctg_name;
	}

	public void setDtl_ctg_name(String dtl_ctg_name) {
		this.dtl_ctg_name = dtl_ctg_name;
	}

	public String getCtg_code() {
		return ctg_code;
	}

	public void setCtg_code(String ctg_code) {
		this.ctg_code = ctg_code;
	} 
	
	
	
} // DetailCategory
