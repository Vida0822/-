package file.model;

public class File {
	// 필드 
	private String af_cd; // 첨부파일_코드
	private String af_ex_name; // 기존파일이름
	private String af_sys_name; // 시스템파일이름
	private String af_path; // 파일경로
	private String af_type; // 파일분류
	private String af_rep; // 대표파일
	private String m_cd; // 회원코드
	private String cra_cd; // 입금계좌코드
	private String tb_cd; // 세금계산서_코드
	private String cpst_cd; // 커뮤니티_게시글_코드
	private String pro_cd; // 프로젝트코드
	private String review_cd; // 후기_코드
	
	// 생성자 
	public File() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public File(String af_cd, String af_ex_name, String af_sys_name, String af_path, String af_type, String af_rep, String m_cd,
			String cra_cd, String tb_cd, String cpst_cd, String pro_cd, String review_cd) {
		super();
		this.af_cd = af_cd;
		this.af_ex_name = af_ex_name;
		this.af_sys_name = af_sys_name;
		this.af_path = af_path;
		this.af_type = af_type;
		this.af_rep = af_rep;
		this.m_cd = m_cd;
		this.cra_cd = cra_cd;
		this.tb_cd = tb_cd;
		this.cpst_cd = cpst_cd;
		this.pro_cd = pro_cd;
		this.review_cd = review_cd;
	}



	// getter, setter 
	public String getAf_cd() {
		return af_cd;
	}

	public void setAf_cd(String af_cd) {
		this.af_cd = af_cd;
	}

	public String getAf_ex() {
		return af_ex_name;
	}

	public void setAf_ex(String af_ex) {
		this.af_ex_name = af_ex;
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

	public String getCra_cd() {
		return cra_cd;
	}

	public void setCra_cd(String cra_cd) {
		this.cra_cd = cra_cd;
	}

	public String getTb_cd() {
		return tb_cd;
	}

	public void setTb_cd(String tb_cd) {
		this.tb_cd = tb_cd;
	}

	public String getCpst_cd() {
		return cpst_cd;
	}

	public void setCpst_cd(String cpst_cd) {
		this.cpst_cd = cpst_cd;
	}

	public String getPo_cd() {
		return pro_cd;
	}

	public void setPo_cd(String pro_cd) {
		this.pro_cd = pro_cd;
	}

	public String getReview_cd() {
		return review_cd;
	}

	public void setReview_cd(String review_cd) {
		this.review_cd = review_cd;
	}


	public String getAf_rep() {
		return af_rep;
	}


	public void setAf_rep(String af_rep) {
		this.af_rep = af_rep;
	}
	
} // File
