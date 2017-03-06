package edu.fjnu.fujiantravel.push;

import java.util.Map;

import edu.fjnu.fujiantravel.server.Json;

public class PushNotificationMessage {
	private String title = null;// 通知标题，默认为应用名称
	private String description = null;// 必选；通知的文本内容
	private int notification_builder_id;// 可选；客户端自定义通知样式
	private int notification_basic_style;// 可选；只有notification_builder_id为0时有效，值为(响铃:4，振动:2，可清除:1或者相加)
	private int open_type;// 可选；1:打开网页；2：打开Android组件
	private String url = null;// 可选；open_type = 1时有效；打开网页的URL
	private String pkg_content = null;// 可选；open_type=2时有效；pkg_content=null时直接打开应用；pkg_content值为Intent.toURL()的值，打开指定组件。
	private String custom_content = null;// 可选；自定义内容，键值对，Json对象形式(可选)；在android客户端，这些键值对将以Intent中的extra进行传递.

	public PushNotificationMessage() {
		this.notification_builder_id = 0;
		this.notification_basic_style = 7;
		this.open_type = 0;
	}

	public void settitle(String title) {
		this.title = title;
	}

	public String gettitle() {
		return this.title;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getdescription() {
		return this.description;
	}

	public void setnotification_builder_id(int id) {
		this.notification_builder_id = id;
	}

	public int getnotification_builder_id() {
		return this.notification_builder_id;
	}

	public void setnotification_basic_style(int style) {
		this.notification_basic_style = style;
	}

	public int getnotification_basic_style() {
		return this.notification_basic_style;
	}

	public void setopen_type(int type) {
		this.open_type = type;
	}

	public int getopen_type() {
		return this.open_type;
	}

	public void seturl(String url) {
		this.url = url;
	}

	public String geturl() {
		return this.url;
	}

	public void setpkg_content(String intent) {
		this.pkg_content = intent;
	}

	public String getpkg_content() {
		return this.pkg_content;
	}

	public void setcustom_content(Map<String, String> content) {
		this.custom_content = Json.MaptoJson(content);
	}

	public String getcuston_content() {
		return this.custom_content;
	}

	public String toJson() {
		if (this.description == null) {
			System.out.println("通知内容不能为空！");
			return null;
		}
		return Json.ObjecttoJson(this);
	}
}
