package com.github.jeffmagina.restaurant.main;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		File orderForm = new File("OrderForm.txt");
		IO parser = new IO();

		// Parse order
		CustomerOrder custOrder = new CustomerOrder();
		custOrder = parser.ParseCustOrderForm(orderForm);

		//Cashier interactions with customer
		cashier.interaction(custOrder);
		
		//Testing reading from AWS database
		String url = "jdbc:postgresql://3.134.83.141:5432/jeffMagina";
		String user = "jeffMagina";
		String password = "jeffMagina";

		try (Connection conn = DriverManager.getConnection(url, user, password);) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orderhistory");
			while (rs.next()) {
				System.out.println(rs.getString("order_id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("ordercost"));
				System.out.println(rs.getString("paymentamount"));
				System.out.println(rs.getString("changegiven"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
