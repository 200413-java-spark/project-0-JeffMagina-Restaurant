package com.github.jeffmagina.takeout.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataSource {

	private static String url;
	private static String user;
	private static String password;

	static {
		url = System.getProperty("database.url", "jdbc:postgresql://52.15.176.248:5432/jeffMagina");
		user = System.getProperty("database.username", "jeffMagina");
		password = System.getProperty("database.password", "jeffMagina");
	}

	private SqlDataSource() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

}
