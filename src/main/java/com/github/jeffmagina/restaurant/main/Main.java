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
		//Cashier cashier = new Cashier();
		//File orderForm = new File("OrderForm.txt");
		//IO parser = new IO();
		
		//Parse order
		//CustomerOrder custOrder = new CustomerOrder();
		//custOrder = parser.ParseCustOrderForm(orderForm);

		// Cashier interactions with customer
		//cashier.interaction(custOrder);
		String url = "jdbc:postgresql://localhost:5432/jeffMagina";
		String user = "jeffMagina";
		String password = "jeffMagina";
		
		try(Connection conn = DriverManager.getConnection(url,user,password);) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orderhistory");
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
