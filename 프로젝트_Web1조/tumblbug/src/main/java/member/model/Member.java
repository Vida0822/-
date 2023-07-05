package member.model;

public class Member {
	
	
	// 필드 
	private String m_cd; 
    private String m_email; 
    private String m_password; 
    private String m_tel; 
    private String m_name; 
    private String m_url; 
    private String m_intro; 
    private String idus_url; 
    private String web_url; 
    private String m_privacy;
    private String m_message; 
    private String m_up; 
    private String m_pro; 
    private String m_liked; 
    private String m_follow; 
    private String m_mk;
    
	

	public Member(String m_cd, String m_email, String m_password, String m_tel, String m_name, String m_url,
			String m_intro, String idus_url, String web_url, String m_privacy, String m_message, String m_up,
			String m_pro, String m_liked, String m_follow, String m_mk) {
		super();
		this.m_cd = m_cd;
		this.m_email = m_email;
		this.m_password = m_password;
		this.m_tel = m_tel;
		this.m_name = m_name;
		this.m_url = m_url;
		this.m_intro = m_intro;
		this.idus_url = idus_url;
		this.web_url = web_url;
		this.m_privacy = m_privacy;
		this.m_message = m_message;
		this.m_up = m_up;
		this.m_pro = m_pro;
		this.m_liked = m_liked;
		this.m_follow = m_follow;
		this.m_mk = m_mk;
	}

	// 생성자 
	public Member() {
		super();
	}

	// 회원가입 (계정생성) 
	public Member( String m_email, String m_password, String m_name) {
		super();
		this.m_email = m_email;
		this.m_password = m_password;
		this.m_name = m_name;
	}

	// 로그인용 
	public Member(String m_email, String m_password) {
		super();
		this.m_email = m_email;
		this.m_password = m_password;
	}
	
	// 로그인용 
	public Member(String m_cd, String m_email, String m_password,String m_name) {
		super();
		this.m_cd = m_cd;
		this.m_email = m_email;
		this.m_password = m_password;
		this.m_name = m_name;
	}
	
	
	
	public Member(String m_cd, String m_email, String m_password, String m_tel, String m_name, String m_url,
			String m_intro, String idus_url, String web_url, String m_privacy) {
		super();
		this.m_cd = m_cd;
		this.m_email = m_email;
		this.m_password = m_password;
		this.m_tel = m_tel;
		this.m_name = m_name;
		this.m_url = m_url;
		this.m_intro = m_intro;
		this.idus_url = idus_url;
		this.web_url = web_url;
		this.m_privacy = m_privacy;
	}

	// getter , setter 
	public String getM_cd() {
		return m_cd;
	}

	public void setM_cd(String m_cd) {
		this.m_cd = m_cd;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_url() {
		return m_url;
	}

	public void setM_url(String m_url) {
		this.m_url = m_url;
	}

	public String getM_intro() {
		return m_intro;
	}

	public void setM_intro(String m_intro) {
		this.m_intro = m_intro;
	}

	public String getIdus_url() {
		return idus_url;
	}

	public void setIdus_url(String idus_url) {
		this.idus_url = idus_url;
	}

	public String getWeb_url() {
		return web_url;
	}

	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	public String getM_privacy() {
		return m_privacy;
	}

	public void setM_privacy(String m_privacy) {
		this.m_privacy = m_privacy;
	} 
	
	public String getM_message() {
		return m_message;
	}

	public void setM_message(String m_message) {
		this.m_message = m_message;
	}

	public String getM_up() {
		return m_up;
	}

	public void setM_up(String m_up) {
		this.m_up = m_up;
	}

	public String getM_pro() {
		return m_pro;
	}

	public void setM_pro(String m_pro) {
		this.m_pro = m_pro;
	}

	public String getM_liked() {
		return m_liked;
	}

	public void setM_liked(String m_liked) {
		this.m_liked = m_liked;
	}

	public String getM_follow() {
		return m_follow;
	}

	public void setM_follow(String m_follow) {
		this.m_follow = m_follow;
	}

	public String getM_mk() {
		return m_mk;
	}

	public void setM_mk(String m_mk) {
		this.m_mk = m_mk;
	}
	
	public boolean matchPassword(String pwd) {
		return m_password.equals(pwd);
	}		
	
	
}
