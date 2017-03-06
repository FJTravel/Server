package edu.fjnu.fujiantravel.scenic;

public class Scenic {
	// 查询景点
	public static final int QUERYSCENIC = 30;
	public static final int QUERYSCENIC_SUCCESS = 300;
	public static final int QUERYSCENIC_ERROR = 301;

	/**
	 * scenicid 景点编号
	 * name 景点名称 
	 * province 景点所在省份
	 * city 景点所在地级市 
	 * country 景点所在区\县
	 * town 景点所在镇 
	 * address 景点详细地址
	 * detail 景点详细信息
	 */
	private String scenicid;
	private String name;
	private String province;
	private String city;
	private String country;
	private String town;
	private String address;
	private ScenicDetail detail;

	public Scenic() {

	}

	public void setscenic(String scneicid) {
		this.scenicid = scneicid;
	}

	public String getscenic() {
		return this.scenicid;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return this.name;
	}

	public void setprovince(String province) {
		this.province = province;
	}

	public String getprovince() {
		return this.province;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getcity() {
		return this.city;
	}

	public void setcountry(String country) {
		this.country = country;
	}

	public String getcountry() {
		return this.country;
	}

	public void settown(String town) {
		this.town = town;
	}

	public String gettown() {
		return this.town;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getaddress() {
		return this.address;
	}

	public void setdetail(ScenicDetail detail) {
		this.detail = detail;
	}

	public ScenicDetail getdetail() {
		return this.detail;
	}
}
