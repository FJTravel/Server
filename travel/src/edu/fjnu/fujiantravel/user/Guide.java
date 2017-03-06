package edu.fjnu.fujiantravel.user;

import java.util.List;

import edu.fjnu.fujiantravel.mysql.Evaluate;

public class Guide {
	public static final int ACTIVATEGUIDE = 14;
	public static final int ACTIVATEGUIDE_SUCCESS = 140;
	public static final int ACTIVATEGUIDE_ERROR = 141;
	public static final int GUIDELOG = 142;
	public static final int LOG_SUCCESS = 143;
	public static final int LOG_ERROR = 144;

	private String user_id;
	private int level;
	private int EXP;
	private double point;
	private int state;
	private List<String> labels;
	private List<String> routes;
	private List<Evaluate> evaluates;

	public Guide() {

	}

	public Guide(String user_id, int level, int EXP, double point, int state) {
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

	public void setlabels(List<String> labels) {
		this.labels = labels;
	}

	public void setroutes(List<String> routes) {
		this.routes = routes;
	}

	public List<String> getlabels() {
		return this.labels;
	}

	public List<String> getroutes() {
		return this.routes;
	}

	public List<Evaluate> getevaluates() {
		return this.evaluates;
	}

	public void setevaluates(List<Evaluate> evaluates) {
		this.evaluates = evaluates;
	}

}
