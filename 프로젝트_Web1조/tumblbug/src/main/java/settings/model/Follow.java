package settings.model;

public class Follow {

	private String f_cd;
	private String f_following;
	private String f_follower;
	
	public Follow() {
		super();
	}
	public Follow(String f_cd, String f_following, String f_follower) {
		super();
		this.f_cd = f_cd;
		this.f_following = f_following;
		this.f_follower = f_follower;
	}

	public String getF_cd() {
		return f_cd;
	}

	public void setF_cd(String f_cd) {
		this.f_cd = f_cd;
	}

	public String getF_following() {
		return f_following;
	}

	public void setF_following(String f_following) {
		this.f_following = f_following;
	}

	public String getF_follower() {
		return f_follower;
	}

	public void setF_follower(String f_follower) {
		this.f_follower = f_follower;
	}
	
}
