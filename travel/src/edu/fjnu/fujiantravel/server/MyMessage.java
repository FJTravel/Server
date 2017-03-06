package edu.fjnu.fujiantravel.server;

public class MyMessage {
	private int head;
	private String detail;

	public MyMessage(int head, String detail) {
		this.head = head;
		this.detail = detail;
	}

	public MyMessage() {
	}

	public int gethead() {
		return this.head;
	}

	public String getdetail() {
		return this.detail;
	}

	public void sethead(int head) {
		this.head = head;
	}

	public void setdetail(String detail) {
		this.detail=detail;
	}
}
