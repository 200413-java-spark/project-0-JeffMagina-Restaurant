package com.github.jeffmagina.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;

public class OrderRepo {

	public OrderRepo() {
	}

	public CustomerTicket insert(CustomerTicket customerTicket) {

		try (Connection conn = DataSource.getConnection();) {

			PreparedStatement CustomerStmt = conn.prepareStatement("insert into customer(name) values (?)");
			CustomerStmt.setString(1, customerTicket.customer.name);
			CustomerStmt.addBatch();
			CustomerStmt.executeBatch();

			// GET CUSTOMER ID FOR ORDER STATEMENT
			Statement CustomerIDSelectStmt = conn.createStatement();
			ResultSet CustomerIDrs = CustomerIDSelectStmt.executeQuery("select customerID from customer Where name = '" + customerTicket.customer.name +"'");
			while (CustomerIDrs.next()) {
				customerTicket.customer.customerId = CustomerIDrs.getInt("customerID");
			}
			
			PreparedStatement orderStmt = conn.prepareStatement("insert into customerTicket(customerID,orderCost,paymentAmount,changeGiven) values (?, ?, ?, ?)");
			orderStmt.setInt(1, customerTicket.customer.customerId);
			orderStmt.setDouble(2, customerTicket.orderCost);
			orderStmt.setDouble(3, customerTicket.paymentAmount);
			orderStmt.setDouble(4, customerTicket.changeGiven);
			orderStmt.addBatch();
			orderStmt.executeBatch();

			// GET CustomerTicketID
			Statement orderIDSelectStmt = conn.createStatement();
			ResultSet orderIDrs = orderIDSelectStmt.executeQuery("select customerTicketID from customerTicket Where customerId = "+ customerTicket.customer.customerId);
			while (orderIDrs.next()) {
				customerTicket.customerTicketId = orderIDrs.getInt("customerTicketID");
			}
			
			for (int i = 0; i < customerTicket.order.size(); i++) {
				PreparedStatement orderItemStmt = conn.prepareStatement("insert into orderItem(customerTicketID,quantity,name) values (?, ? ,?)");
				orderItemStmt.setInt(1, customerTicket.customerTicketId);
				orderItemStmt.setInt(2, customerTicket.order.get(i).quantity);
				orderItemStmt.setString(3, customerTicket.order.get(i).name);
				orderItemStmt.addBatch();
				orderItemStmt.executeBatch();
				
				// GET OrderItemID
				Statement orderTicketIDSelectStmt = conn.createStatement();
				ResultSet orderTicketIDrs = orderTicketIDSelectStmt.executeQuery("select orderItemID from orderitem Where customerTicketID = " + customerTicket.customerTicketId);
				while (orderIDrs.next()) {
					customerTicket.order.get(i).orderItemId = orderTicketIDrs.getInt("orderItemID");
				}
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerTicket;
	}
/*
	public ArrayList<CustomerOrder> readAll() {
		Format format = new Format();

		try (Connection conn = DataSource.getConnection();) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from orderhistory");
			while (rs.next()) {
				CustomerOrder customerOrder = new CustomerOrder();
				customerOrder.name = rs.getString("name");

				// NEED TO FIX
				customerOrder.order = format.splitTokens(rs.getString("cust_order"), ",");

				customerOrder.orderCost = rs.getDouble("ordercost");
				customerOrder.paymentAmount = rs.getDouble("paymentamount");
				customerOrder.changeGiven = rs.getDouble("changegiven");
				this.customerOrders.add(customerOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerOrders;
	}*/

}
