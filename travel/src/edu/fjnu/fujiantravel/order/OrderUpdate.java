package edu.fjnu.fujiantravel.order;

public class OrderUpdate {
	private String orderID;
	private String head;
	private String detail;

	public OrderUpdate() {
	}

	public OrderUpdate(String orderID, String head, String detail) {
		this.orderID = orderID;
		this.head = head;
		this.detail = detail;
	}

	public void setorderID(String orderID) {
		this.orderID = orderID;
	}

	public void sethead(String head) {
		this.head = head;
	}

	public void setdetail(String detail) {
		this.detail = detail;
	}

	public String getorderID() {
		return this.orderID;
	}

	public String gethead() {
		return this.head;
	}

	public String getdetail() {
		return this.detail;
	}
}
