package edu.fjnu.fujiantravel.user;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.fjnu.fujiantravel.mysql.DBHelper;
import edu.fjnu.fujiantravel.server.Json;
import edu.fjnu.fujiantravel.server.MyMessage;

public class UserHandler {

	// User log request
	public static void userlog(DataOutputStream out, MyMessage msg) throws SQLException, IOException {
		User user = new User();
		String JsonStr = msg.getdetail();
		user = (User) Json.JsontoObject(JsonStr, user.getClass());
		int type = msg.gethead();
		String detail = null;
		if (UserHandler.judgeuser(user)) {
			switch (type) {
			case Tourist.TOURISTLOG:
				if (UserHandler.judgetourist(user.getid()))
					type = Tourist.LOG_SUCCESS;
				else
					type = Tourist.LOG_ERROR;
				break;
			case Guide.GUIDELOG:
				if (UserHandler.judgeguide(user.getid()))
					type = Guide.LOG_SUCCESS;
				else
					type = Guide.LOG_ERROR;
				break;
			}
			detail = Json.ObjecttoJson(UserHandler.queryuser(user.getid()));
		} else {
			type = User.LOG_ERROR;
		}
		msg.sethead(type);
		msg.setdetail(detail);
		JsonStr = Json.ObjecttoJson(msg);
		out.writeUTF(JsonStr);
		out.flush();
	}

	// Determine whether a user exists
	public static Boolean judgeuser(User user) throws SQLException {
		Connection conn = DBHelper.getConn();
		String id = user.getid();
		String passwd = user.getpasswd();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select count(*) as count from user_master where id = '" + id + "'");
		rs.next();
		int count = rs.getInt("count");
		if (count <= 0) {
			return false;
		}
		rs = sta.executeQuery("select passwd from user_master where id = '" + id + "'");
		rs.next();
		String str = rs.getString("passwd");
		if (!passwd.equals(str)) {
			return false;
		}
		conn.close();
		return true;
	}

	public static Boolean judgetourist(String id) throws SQLException {
		Connection conn = DBHelper.getConn();
		Statement sta = conn.createStatement();
		ResultSet rs = sta
				.executeQuery("select count(*) as count from user_master where id = '" + id + "' and tourist = 1");
		rs.next();
		int count = rs.getInt("count");
		if (count <= 0) {
			return false;
		}
		conn.close();
		return true;
	}

	public static Boolean judgeguide(String id) throws SQLException {
		Connection conn = DBHelper.getConn();
		Statement sta = conn.createStatement();
		ResultSet rs = sta
				.executeQuery("select count(*) as count from user_master where id = '" + id + "' and guide = 1");
		rs.next();
		int count = rs.getInt("count");
		if (count <= 0) {
			return false;
		}
		conn.close();
		return true;
	}

	// Query user information
	public static User queryuser(String id) throws SQLException {
		Connection conn = DBHelper.getConn();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select * from user_master where id = '" + id + "'");
		rs.next();
		User user = new User(rs.getString("id"), rs.getString("passwd"), rs.getInt("tourist"), rs.getInt("guide"));
		return user;
	}

	// User register request
	public static void userregister(DataOutputStream out, MyMessage msg) throws SQLException, IOException {
		User user = new User();
		String JsonStr = msg.getdetail();
		user = (User) Json.JsontoObject(JsonStr, user.getClass());
		int type;
		if (UserHandler.registeruser(user)) {
			type = User.REGISTER_SUCCESS;
		} else {
			type = User.REGISTER_ERROR;
		}
		msg.sethead(type);
		msg.setdetail(null);
		JsonStr = Json.ObjecttoJson(msg);
		out.writeUTF(JsonStr);
		out.flush();
	}

	// Register user information
	public static Boolean registeruser(User user) throws SQLException {
		Connection conn = DBHelper.getConn();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select count(*) as count from user_master where id = '" + user.getid() + "'");
		rs.next();
		int count = rs.getInt("count");
		if (count > 0) {
			return false;
		}
		sta.executeUpdate("insert into user_info (id) values('"+user.getid()+"')");
		String insertSql = "insert into user_master values(?,?,?,?,now(),?)";
		PreparedStatement psta = conn.prepareStatement(insertSql);
		psta.setString(1, user.getid());
		psta.setString(2, user.getpasswd());
		psta.setInt(3, 0);
		psta.setInt(4, 0);
		psta.setInt(5, 0);
		psta.addBatch();
		psta.executeBatch();
		psta.close();	
		conn.close();
		if (!UserHandler.activatetourist(user.getid()))
			return false;
		return true;
	}

	// activate tourist identity
	public static Boolean activatetourist(String id) throws SQLException {
		Boolean flag = false;
		Connection conn = DBHelper.getConn();
		String sql = "update user_master set tourist = 1 where id = ?";
		PreparedStatement psta = conn.prepareStatement(sql);
		psta.setString(1, id);
		psta.addBatch();
		psta.executeBatch();
		psta.close();
		conn.close();
		flag = true;
		return flag;
	}

	// activate guide identity
	public static Boolean activateguide(String id) throws SQLException {
		Boolean flag = false;
		Connection conn = DBHelper.getConn();
		String sql = "update user_master set guide = 1 where id = ?";
		PreparedStatement psta = conn.prepareStatement(sql);
		psta.setString(1, id);
		psta.addBatch();
		psta.executeBatch();
		psta.close();
		conn.close();
		flag = true;
		return flag;
	}

}
