package edu.fjnu.fujiantravel.mysql;

public class Evaluate {
	private String user_id;
	private int type;
	private double point;
	private String content;

	public Evaluate() {

	}

	public Evaluate(String user_id, int type, double point, String content) {
		this.user_id = user_id;
		this.type = type;
		this.point = point;
		this.content = content;
	}

	public void setuser_id(String user_id) {
		this.user_id = user_id;
	}

	public void settype(int type) {
		this.type = type;
	}

	public void setpoint(double point) {
		this.point = point;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public String getuser_id() {
		return this.user_id;
	}

	public int gettype() {
		return this.type;
	}

	public double getpoint() {
		return this.point;
	}

	public String getcontent() {
		return this.content;
	}
}
