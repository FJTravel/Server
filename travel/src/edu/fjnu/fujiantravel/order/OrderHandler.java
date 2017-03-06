package edu.fjnu.fujiantravel.order;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.fjnu.fujiantravel.mysql.DBHelper;
import edu.fjnu.fujiantravel.server.Json;
import edu.fjnu.fujiantravel.server.MyMessage;

public class OrderHandler {
	// ���ݿ����
	public static Boolean createorder(Order order) throws SQLException {
		Boolean flag = true;
		Connection conn = DBHelper.getConn();
		String insertSql = "insert into orders values(?,?,?,?,?,?,?,now(),?,?,?,?,?)";
		PreparedStatement psta = conn.prepareStatement(insertSql);
		psta.setString(1, order.getorderid());
		psta.setString(2, order.gettouristid());
		psta.setString(3, order.getguideid());
		psta.setInt(4, order.gettype());
		psta.setInt(5, order.getstate());
		psta.setDouble(6, order.getprice());
		psta.setDouble(7, order.getreward());
		psta.setString(8, order.getpaytime());
		psta.setString(9, order.getfinishtime());
		psta.setString(10, order.getremark());
		psta.setInt(11, order.getpeoplenumbers());
		psta.setInt(12,order.getplaytime());
		psta.addBatch();
		if (psta.executeBatch()[0] < 0) {
			flag = false;
		}
		psta.close();
		conn.close();
		return flag;
	}

	public static void updateorder(String id, String head, String detail) throws SQLException {
		Connection conn = DBHelper.getConn();
		String updatesql = "update order set " + head + "=? where orderdID=?";
		PreparedStatement psta = conn.prepareStatement(updatesql);
		psta.setString(1, detail);
		psta.setString(2, id);
		psta.addBatch();
		psta.executeBatch();
		psta.close();
		conn.close();
	}

	public static void updateorderstate(String id, int state) throws SQLException {
		Connection conn = DBHelper.getConn();
		String updatesql = "update order set state = ? where orderID = ?";
		PreparedStatement psta = conn.prepareStatement(updatesql);
		psta.setInt(1, state);
		psta.setString(2, id);
		psta.addBatch();
		psta.executeBatch();
		psta.close();
		conn.close();
	}

	public static List<Order> querytouristorder(String id) throws SQLException {
		List<Order> list = new ArrayList<Order>();
		Connection conn = DBHelper.getConn();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select * from orders where tourisID = '" + id + "'");
		while (rs.next()) {
			Order order = new Order();
			order.setorderid(rs.getString("orderID"));
			order.settouristid(rs.getString("touristID"));
			order.setguideid(rs.getString("guideID"));
			order.settype(rs.getInt("ordertype"));
			order.setstate(rs.getInt("orderstate"));
			order.setprice(rs.getDouble("price"));
			order.setreward(rs.getDouble("reward"));
			order.setpaytime(rs.getString("paytime"));
			order.setcreatetime(rs.getString("createtime"));
			order.setfinishtime(rs.getString("finishtime"));
			order.setremark(rs.getString("remark"));
			order.setdetail(OrderHandler.queryorderdetail(rs.getString("orderID")));
			list.add(order);
		}
		return list;
	}

	public static List<Order> queryguideorder(String id) throws SQLException {
		List<Order> list = new ArrayList<Order>();
		Connection conn = DBHelper.getConn();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery("select * from orders where guideID = '" + id + "'");
		while (rs.next()) {
			Order order = new Order();
			order.setorderid(rs.getString("orderID"));
			order.settouristid(rs.getString("touristID"));
			order.setguideid(rs.getString("guideID"));
			order.settype(rs.getInt("ordertype"));
			order.setstate(rs.getInt("orderstate"));
			order.setprice(rs.getDouble("price"));
			order.setreward(rs.getDouble("reward"));
			order.setpaytime(rs.getString("paytime"));
			order.setcreatetime(rs.getString("createtime"));
			order.setfinishtime(rs.getString("finishtime"));
			order.setremark(rs.getString("remark"));
			order.setdetail(OrderHandler.queryorderdetail(rs.getString("orderID")));
			list.add(order);
		}
		return list;
	}

	public static Boolean insertorderdetail(String id, OrderDetail orderdetail) throws SQLException {
		Boolean flag = true;
		Connection conn = DBHelper.getConn();
		String insertSql = "insert into orderdetail values(?,?,?,?)";
		PreparedStatement psta = conn.prepareStatement(insertSql);
		psta.setString(1, id);
		psta.setString(2, orderdetail.getrouteID());
		psta.setString(3, orderdetail.getscenicID());
		psta.setDouble(4, orderdetail.getprice());
		psta.addBatch();
		if (psta.executeBatch()[0] < 0) {
			flag = false;
		}
		psta.close();
		conn.close();
		return flag;
	}

	public static List<OrderDetail> queryorderdetail(String id) throws SQLException {
		Connection conn = DBHelper.getConn();
		String querysql = "select * from orderdetail where orderID = '" + id + "'";
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		Statement sta;
		sta = conn.createStatement();
		ResultSet rs = sta.executeQuery(querysql);
		while (rs.next()) {
			OrderDetail orderdetail = new OrderDetail();
			orderdetail.setrouteID(rs.getString("routeID"));
			orderdetail.setscenicID(rs.getString("scenicID"));
			orderdetail.setprice(rs.getDouble("price"));
			list.add(orderdetail);
		}
		return list;
	}

	// �������
	public static void createorder(DataOutputStream out, MyMessage msg) throws SQLException, IOException {
		Order order = new Order();
		String JsonStr = msg.getdetail();
		order = (Order) Json.JsontoObject(JsonStr, order.getClass());
		int type;
		if (OrderHandler.createorder(order)) {
			type = Order.CREATRORDER_SUCCESS;
		} else {
			type = Order.CREATRORDER_ERROR;
		}
		msg.sethead(type);
		msg.setdetail(null);
		JsonStr = Json.ObjecttoJson(msg);
		out.writeUTF(JsonStr);
		out.flush();
	}

	public static void queryorder(DataOutputStream out, MyMessage msg) throws IOException {
		String id = msg.getdetail();
		List<Order> list = null;
		msg.sethead(Order.QUERYORDER_SUCCESS);
		try {
			if (msg.gethead() == Order.QUERYORDER_TOURIST)
				list = OrderHandler.querytouristorder(id);
			if (msg.gethead() == Order.QUERYORDER_GUIDE)
				list = OrderHandler.queryguideorder(id);
			msg.setdetail(Json.ListtoJson(list));
		} catch (Exception e) {
			e.printStackTrace();
			msg.sethead(Order.QUERYORDER_ERROR);
		}
		String JsonStr = Json.ObjecttoJson(msg);
		out.writeUTF(JsonStr);
		out.flush();
	}

	public static void updateorder(DataOutputStream out, MyMessage msg) throws SQLException, IOException {
		OrderUpdate orderupdate = new OrderUpdate();
		String JsonStr = msg.getdetail();
		orderupdate = (OrderUpdate) Json.JsontoObject(JsonStr, orderupdate.getClass());
		msg.sethead(Order.UPDATEORDRE_SUCCESS);
		try {
			OrderHandler.updateorder(orderupdate.getorderID(), orderupdate.gethead(), orderupdate.getdetail());
		} catch (Exception e) {
			e.printStackTrace();
			msg.sethead(Order.UPDATEORDER_ERROR);
		}
		msg.setdetail(null);
		JsonStr = Json.ObjecttoJson(msg);
		out.writeUTF(JsonStr);
		out.flush();
	}
}
