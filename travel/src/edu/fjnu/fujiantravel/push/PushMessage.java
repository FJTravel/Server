package edu.fjnu.fujiantravel.push;

public class PushMessage {
	public static final int PUSHBIND = 40;
	public static final int PUSHBIND_SUCCESS = 400;
	public static final int PUSHBIND_ERROR = 401;

	private String id;
	private String appId;
	private String userId;
	private String channelId;
	private String requestId;

	public PushMessage() {

	}

	public PushMessage(String appId, String userId, String channelId, String requestId) {
		this.appId = appId;
		this.userId = userId;
		this.channelId = channelId;
		this.requestId = requestId;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getid() {
		return this.id;
	}

	public void setappId(String appId) {
		this.appId = appId;
	}

	public String getappId() {
		return this.appId;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getuserId() {
		return this.userId;
	}

	public void setchannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getchannelId() {
		return this.channelId;
	}

	public void setrequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getrequestId() {
		return this.requestId;
	}
}
