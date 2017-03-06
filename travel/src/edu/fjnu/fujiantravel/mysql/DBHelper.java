package edu.fjnu.fujiantravel.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	private static  String url = "jdbc:mysql://172.17.195.95:3306/travel";
	private static  String name = "com.mysql.jdbc.Driver";
	private static  String user = "root";
	private static  String password = "root";

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(name);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return conn;
	}
}
