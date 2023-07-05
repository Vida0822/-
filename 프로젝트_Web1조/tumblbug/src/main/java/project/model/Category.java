package project.model;

public class Category {
	
	// 필드 
	private String ctg_code;
	private String ctg_name;
	
	// 생성자 
	public Category() {
		super();
	}
	
	public Category(String ctg_code, String ctg_name) {
		super();
		this.ctg_code = ctg_code;
		this.ctg_name = ctg_name;
	}
	// getter, setter 
	public String getCtg_code() {
		return ctg_code;
	}

	public void setCtg_code(String ctg_code) {
		this.ctg_code = ctg_code;
	}

	public String getCtg_name() {
		return ctg_name;
	}

	public void setCtg_name(String ctg_name) {
		this.ctg_name = ctg_name;
	}
	
	
	
}
