package com.ejc.MySqlConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySql {
	public static Connection mysqlConn() {
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "root");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}
}
