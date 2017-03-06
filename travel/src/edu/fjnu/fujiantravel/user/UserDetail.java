package edu.fjnu.fujiantravel.user;

public class UserDetail {

	private String name;
	private byte[] portrait;
	private String IDnumber;
	private double balance;

	public UserDetail() {

	}

	public void setname(String name) {
		this.name = name;
	}

	public void setportrait(byte[] portrait) {
		this.portrait = portrait;
	}

	public void setIDnumber(String IDnumber) {
		this.IDnumber = IDnumber;
	}

	public void setbalance(double balance) {
		this.balance = balance;
	}

	public double getbalance() {
		return this.balance;
	}

	public String getname() {
		return this.name;
	}

	public String getIDnumber() {
		return this.IDnumber;
	}

	public byte[] getportrait() {
		return this.portrait;
	}
}
