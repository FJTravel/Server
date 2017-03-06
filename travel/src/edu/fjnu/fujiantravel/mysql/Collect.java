package edu.fjnu.fujiantravel.mysql;

public class Collect {
	private String user_id;
	private int type;
	private String collectid;

	public Collect() {

	}

	public Collect(String user_id, int type, String collectid) {
		this.user_id = user_id;
		this.type = type;
		this.collectid = collectid;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public void settype(int type) {
		this.type = type;
	}

	public void setcollectid(String collectid) {
		this.collectid = collectid;
	}

	public String getuser_id() {
		return this.user_id;
	}

	public int gettype() {
		return this.type;
	}

	public String getcollectid() {
		return this.collectid;
	}
}
