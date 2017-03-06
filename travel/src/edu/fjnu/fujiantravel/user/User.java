package edu.fjnu.fujiantravel.user;

public class User {
	// user register information
	public final static int USERREGISTER = 10;
	public final static int REGISTER_SUCCESS = 100;
	public final static int REGISTER_ERROR = -100;

	// user log
	public final static int USERLOG = 11;
	public final static int LOG_SUCCESS = 110;
	public final static int LOG_ERROR = -110;
	
	// update user information
	public final static int EDITUSERINFO = 12;

	private String id;
	private String passwd;
	private int tourist;
	private int guide;
	private UserDetail detail;

	public User() {

	}

	public User(String id, String passwd, int tourist, int guide) {
		this.id = id;
		this.passwd = passwd;
		this.tourist = tourist;
		this.guide = guide;
	}

	public void setid(String id) {
		this.id = id;
	}

	public void setpasswd(String passwd) {
		this.passwd = passwd;
	}

	public void settourist(int tourist) {
		this.tourist = tourist;
	}

	public void setguide(int guide) {
		this.guide = guide;
	}

	public String getid() {
		return this.id;
	}

	public String getpasswd() {
		return this.passwd;
	}

	public int gettourist() {
		return this.tourist;
	}

	public int getguide() {
		return this.guide;
	}

	public UserDetail getdetail() {
		return this.detail;
	}

	public void setdetail(UserDetail userdetail) {
		this.detail = userdetail;
	}
}
