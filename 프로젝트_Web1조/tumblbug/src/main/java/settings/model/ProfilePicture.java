package settings.model;

public class ProfilePicture {

	private String af_cd; // 기본키
	private String af_ex_name; // 원래이름
	private String af_sys_name; // 시스템이름
	private String af_path; // 파일경로
	private String af_type; // 파일분류
	private String m_cd; // 회원코드

	// 예비
	private String af_image; // 1, 0 - 이미지인지 아닌지
	private String uuid; // uuid
	
	public ProfilePicture() {
		super();
	}
	public ProfilePicture(String af_cd, String af_ex_name, String af_sys_name, String af_path, String af_type,
			String m_cd, String af_image) {
		super();
		this.af_cd = af_cd;
		this.af_ex_name = af_ex_name;
		this.af_sys_name = af_sys_name;
		this.af_path = af_path;
		this.af_type = af_type;
		this.m_cd = m_cd;
		this.af_image = af_image;
	}

	public String getAf_cd() {
		return af_cd;
	}
	public void setAf_cd(String af_cd) {
		this.af_cd = af_cd;
	}
	public String getAf_ex_name() {
		return af_ex_name;
	}
	public void setAf_ex_name(String af_ex_name) {
		this.af_ex_name = af_ex_name;
	}
	public String getAf_sys_name() {
		return af_sys_name;
	}
	public void setAf_sys_name(String af_sys_name) {
		this.af_sys_name = af_sys_name;
	}
	public String getAf_path() {
		return af_path;
	}
	public void setAf_path(String af_path) {
		this.af_path = af_path;
	}
	public String getAf_type() {
		return af_type;
	}
	public void setAf_type(String af_type) {
		this.af_type = af_type;
	}
	public String getM_cd() {
		return m_cd;
	}
	public void setM_cd(String m_cd) {
		this.m_cd = m_cd;
	}
	public String getAf_image() {
		return af_image;
	}
	public void setAf_image(String af_image) {
		this.af_image = af_image;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
}
