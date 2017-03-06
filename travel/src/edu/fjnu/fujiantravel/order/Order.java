package edu.fjnu.fujiantravel.order;

import java.util.List;

public class Order {
	// create order
	public final static int CREATEORDER = 20;
	public final static int CREATRORDER_SUCCESS = 200;
	public final static int CREATRORDER_ERROR = 201;

	// update order
	public final static int UPDATEORDER = 21;
	public final static int UPDATEORDRE_SUCCESS = 210;
	public final static int UPDATEORDER_ERROR = 211;

	// query order
	public final static int QUERYORDER = 22;
	public final static int QUERYORDER_TOURIST = 228;
	public final static int QUERYORDER_GUIDE = 229;
	public final static int QUERYORDER_SUCCESS = 220;
	public final static int QUERYORDER_ERROR = 221;

	private String orderid;
	private String touristid;
	private String guideid;
	private int type;
	private int state;
	private double price;
	private double reward;
	private String createtime;
	private String paytime;
	private String finishtime;
	private String remark;
	private int peoplenumbers;
	private int playtime;
	private List<OrderDetail> detail;

	public Order() {

	}

	public void setdetail(List<OrderDetail> detail) {
		this.detail = detail;
	}

	public List<OrderDetail> getdetail() {
		return this.detail;
	}

	public void setpeoplenumbers(int numbers) {
		this.peoplenumbers = numbers;
	}

	public int getpeoplenumbers() {
		return this.peoplenumbers;
	}

	public void setplaytime(int time) {
		this.playtime = time;
	}

	public int getplaytime() {
		return this.playtime;
	}

	public String getorderid() {
		return this.orderid;
	}

	public String gettouristid() {
		return this.touristid;
	}

	public String getguideid() {
		return this.guideid;
	}

	public int gettype() {
		return this.type;
	}

	public int getstate() {
		return this.state;
	}

	public double getprice() {
		return this.price;
	}

	public double getreward() {
		return this.reward;
	}

	public String getcreatetime() {
		return this.createtime;
	}

	public String getpaytime() {
		return this.paytime;
	}

	public String getfinishtime() {
		return this.finishtime;
	}

	public String getremark() {
		return this.remark;
	}

	public void setorderid(String id) {
		this.orderid = id;
	}

	public void setguideid(String id) {
		this.guideid = id;
	}

	public void settouristid(String id) {
		this.touristid = id;
	}

	public void settype(int type) {
		this.type = type;
	}

	public void setstate(int state) {
		this.state = state;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public void setreward(double reward) {
		this.reward = reward;
	}

	public void setcreatetime(String createtime) {
		this.createtime = createtime;
	}

	public void setpaytime(String paytime) {
		this.paytime = paytime;
	}

	public void setfinishtime(String finishtime) {
		this.finishtime = finishtime;
	}

	public void setremark(String remark) {
		this.remark = remark;
	}
}