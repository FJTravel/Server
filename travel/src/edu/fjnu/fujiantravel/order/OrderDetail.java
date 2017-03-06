package edu.fjnu.fujiantravel.order;

public class OrderDetail {
	private String routeID;
	private String scenicID;
	private double price;

	public OrderDetail() {

	}

	public OrderDetail(String routeID, String scenicID, double price) {
		this.routeID = routeID;
		this.scenicID = scenicID;
		this.price = price;
	}

	public String getrouteID() {
		return this.routeID;
	}

	public String getscenicID() {
		return this.scenicID;
	}

	public double getprice() {
		return this.price;
	}

	public void setrouteID(String routeID) {
		this.routeID = routeID;
	}

	public void setscenicID(String scenicID) {
		this.scenicID = scenicID;
	}

	public void setprice(double price) {
		this.price = price;
	}
}
