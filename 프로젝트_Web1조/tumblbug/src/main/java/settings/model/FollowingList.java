package settings.model;

public class FollowingList {

	private String m_cd;
	private String m_name;
	private String m_intro;
	private int followCount;
	
	public FollowingList() {
		super();
	}
	public FollowingList(String m_cd, String m_name, String m_intro, int followCount) {
		super();
		this.m_cd = m_cd;
		this.m_name = m_name;
		this.m_intro = m_intro;
		this.followCount = followCount;
	}
	
	public String getM_cd() {
		return m_cd;
	}
	public void setM_cd(String m_cd) {
		this.m_cd = m_cd;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_intro() {
		return m_intro;
	}
	public void setM_intro(String m_intro) {
		this.m_intro = m_intro;
	}
	public int getFollowCount() {
		return followCount;
	}
	public void setFollowCount(int followCount) {
		this.followCount = followCount;
	}
	
} // class
