package edu.fjnu.fujiantravel.push;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.fjnu.fujiantravel.mysql.DBHelper;
import edu.fjnu.fujiantravel.server.Json;
import edu.fjnu.fujiantravel.server.MyMessage;

public class PushHandler {
	public static Boolean binduser(PushMessage msg) throws SQLException {
		Boolean flag = false;
		Connection conn = DBHelper.getConn();
		Statement sta = conn.createStatement();
		String sql = "update user_info set appid = '" + msg.getappId() + "'," + "userid ='" + msg.getuserId()
				+ "',channelid ='" + msg.getchannelId() + "'," + "requestid='" + msg.getrequestId() + "'where id ='"
				+ msg.getid() + "'";
		sta.executeUpdate(sql);
		flag = true;
		conn.close();
		return flag;
	}

	public static void binduser(DataOutputStream out, MyMessage msg) throws SQLException, IOException {
		PushMessage pushmessage = new PushMessage();
		pushmessage = (PushMessage) Json.JsontoObject(msg.getdetail(), pushmessage.getClass());
		int type;
		if (binduser(pushmessage))
			type = PushMessage.PUSHBIND_SUCCESS;
		else
			type = PushMessage.PUSHBIND_ERROR;
		msg.sethead(type);
		msg.setdetail(null);
		out.writeUTF(Json.ObjecttoJson(msg));
		out.flush();
	}
}
