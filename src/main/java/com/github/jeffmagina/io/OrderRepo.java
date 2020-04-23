package com.github.jeffmagina.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.jeffmagina.format.Format;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class OrderRepo {
	
	private ArrayList<CustomerOrder> customerOrders;
	
	public OrderRepo() {
		customerOrders = new ArrayList<CustomerOrder>();
	}

	public void insertAll(List<CustomerOrder> customerOrders) {
		
		try (Connection conn = DataSource.getConnection();) {
			PreparedStatement stmt = conn.prepareStatement("insert into orderhistory(name, cust_order, ordercost, paymentamount, changegiven) values (?, ?, ?, ?, ?)");
				for (CustomerOrder customerOrder : customerOrders) {
					stmt.setString(1, customerOrder.name);
					stmt.setString(2, customerOrder.order.toString());
					stmt.setDouble(3, customerOrder.orderCost);
					stmt.setDouble(4, customerOrder.paymentAmount);
					stmt.setDouble(5, customerOrder.changeGiven);
					stmt.addBatch();
				}
				stmt.executeBatch();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<CustomerOrder> readAll() {
		Format format = new Format();

		try (Connection conn = DataSource.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orderhistory");
			while (rs.next()) {
				CustomerOrder customerOrder = new CustomerOrder();
				customerOrder.name = rs.getString("name");
				
				//NEED TO FIX
				customerOrder.order = format.splitTokens(rs.getString("cust_order"),",");
				
				customerOrder.orderCost = rs.getDouble("ordercost");
				customerOrder.paymentAmount = rs.getDouble("paymentamount");
				customerOrder.changeGiven = rs.getDouble("changegiven");
				this.customerOrders.add(customerOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerOrders;
	}

}
