package com.github.jeffmagina.io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private static String url;
	private static String user;
	private static String password;

	static {
		url = System.getProperty("database.url", "jdbc:postgresql://3.134.86.104:5432/jeffMagina");
		user = System.getProperty("database.username", "jeffMagina");
		password = System.getProperty("database.password", "jeffMagina");
	}

	private DataSource() {
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);

	}

}
