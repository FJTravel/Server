package edu.fjnu.fujiantravel.user;

import java.util.List;

import edu.fjnu.fujiantravel.mysql.Collect;
import edu.fjnu.fujiantravel.mysql.Evaluate;

public class Tourist {
	public static final int ACTIVATETOURIST = 13;
	public static final int ACTIVATETOURIST_SUCCESS = 130;
	public static final int ACTIVATETOURIST_ERROR = 131;
	public static final int TOURISTLOG = 133;
	public static final int LOG_SUCCESS = 134;
	public static final int LOG_ERROR = 135;

	private String user_id;
	private int level;
	private int EXP;
	private double point;
	private int state;
	private List<Collect> collects;
	private List<Evaluate> evaluates;

	public Tourist() {

	}

	public Tourist(String user_id, int level, int EXP, double point, int state) {
		this.user_id = user_id;
		this.level = level;
		this.EXP = EXP;
		this.point = point;
		this.state = state;
	}

	public String getid() {
		return this.user_id;
	}

	public int getlevel() {
		return this.level;
	}

	public int getEXP() {
		return this.EXP;
	}

	public double getpoint() {
		return this.point;
	}

	public int getstate() {
		return this.state;
	}

	public void setid(String user_id) {
		this.user_id = user_id;
	}

	public void setlevel(int level) {
		this.level = level;
	}

	public void setEXP(int EXP) {
		this.EXP = EXP;
	}

	public void setpoint(double point) {
		this.point = point;
	}

	public void setstate(int state) {
		this.state = state;
	}

	public void setcollects(List<Collect> collects) {
		this.collects = collects;
	}

	public void setevaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

	public List<Collect> getcollects() {
		return this.collects;
	}

	public List<Evaluate> getevaluates() {
		return this.evaluates;
	}
}
