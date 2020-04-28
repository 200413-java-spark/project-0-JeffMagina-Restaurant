package com.github.jeffmagina.io;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.customerticket.order.Order;

public class SqlOrderRepo implements Dao<CustomerTicket> {

	public SqlOrderRepo() {
	}

	@Override
	public void insert(CustomerTicket customerTicket) {

		try (Connection conn = SqlDataSource.getConnection();) {

			// insert into customer table , customer id auto generated
			PreparedStatement CustomerStmt = conn.prepareStatement("insert into customer(name) values (?)");
			CustomerStmt.setString(1, customerTicket.customer.name);
			CustomerStmt.addBatch();
			CustomerStmt.executeBatch();

			// GET CUSTOMER ID FOR ORDER STATEMENT
			Statement CustomerIDSelectStmt = conn.createStatement();
			ResultSet CustomerIDrs = CustomerIDSelectStmt.executeQuery(
					"select customerID from customer Where name = '" + customerTicket.customer.name + "'");
			while (CustomerIDrs.next()) {
				customerTicket.customer.customerId = CustomerIDrs.getInt("customerID");
			}

			// insert into customerTicket table, orderticketid auto generated
			PreparedStatement orderStmt = conn.prepareStatement(
					"insert into customerTicket(customerID,orderCost,paymentAmount,changeGiven) values (?, ?, ?, ?)");
			orderStmt.setInt(1, customerTicket.customer.customerId);
			orderStmt.setDouble(2, customerTicket.orderCost);
			orderStmt.setDouble(3, customerTicket.paymentAmount);
			orderStmt.setDouble(4, customerTicket.changeGiven);
			orderStmt.addBatch();
			orderStmt.executeBatch();

			// GET CustomerTicketID
			Statement orderIDSelectStmt = conn.createStatement();
			ResultSet orderIDrs = orderIDSelectStmt
					.executeQuery("select customerTicketID from customerTicket Where customerId = "
							+ customerTicket.customer.customerId);
			while (orderIDrs.next()) {
				customerTicket.customerTicketId = orderIDrs.getInt("customerTicketID");
			}

			// insert into orderitem table, orderitemid auto generated
			for (int i = 0; i < customerTicket.order.size(); i++) {
				PreparedStatement orderItemStmt = conn
						.prepareStatement("insert into orderItem(customerTicketID,quantity,name) values (?, ? ,?)");
				orderItemStmt.setInt(1, customerTicket.customerTicketId);
				orderItemStmt.setInt(2, customerTicket.order.get(i).quantity);
				orderItemStmt.setString(3, customerTicket.order.get(i).name);
				orderItemStmt.addBatch();
				orderItemStmt.executeBatch();

				// GET OrderItemID
				Statement orderTicketIDSelectStmt = conn.createStatement();
				ResultSet orderTicketIDrs = orderTicketIDSelectStmt
						.executeQuery("select orderItemID from orderitem Where customerTicketID = "
								+ customerTicket.customerTicketId);
				while (orderIDrs.next()) {
					customerTicket.order.get(i).orderItemId = orderTicketIDrs.getInt("orderItemID");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<CustomerTicket> readAll() {
		ArrayList<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

		try (Connection conn = SqlDataSource.getConnection();) {

			// add customer ticket from database into customerTickets
			Statement customerTicketStmt = conn.createStatement();
			ResultSet customerTicketrs = customerTicketStmt.executeQuery("Select * from CustomerTicket");
			while (customerTicketrs.next()) {
				CustomerTicket customerTicket = new CustomerTicket();
				customerTicket.customerTicketId = customerTicketrs.getInt("customerTicketID");
				customerTicket.customer.customerId = customerTicketrs.getInt("customerID");
				customerTicket.orderCost = customerTicketrs.getDouble("orderCost");
				customerTicket.paymentAmount = customerTicketrs.getDouble("paymentAmount");
				customerTicket.changeGiven = customerTicketrs.getDouble("changeGiven");
				customerTickets.add(customerTicket);
			}

			// add customer to customer tickets using customer id from database
			for (int i = 0; i < customerTickets.size(); i++) {
				Statement CustomerStmt = conn.createStatement();
				ResultSet CustomerRs = CustomerStmt.executeQuery(
						"Select name from Customer where customerID = " + customerTickets.get(i).customer.customerId);
				while (CustomerRs.next()) {
					customerTickets.get(i).customer.name = CustomerRs.getString("name");
				}
			}

			// add customer order to customer tickets using customer ticket id
			for (int i = 0; i < customerTickets.size(); i++) {
				Statement OrderStmt = conn.createStatement();
				ResultSet OrderRs = OrderStmt.executeQuery(
						"Select * from orderItem where customerTicketID = " + customerTickets.get(i).customerTicketId);
				while (OrderRs.next()) {
					customerTickets.get(i).order.add(new Order(OrderRs.getInt("orderItemID"),OrderRs.getInt("quantity"),OrderRs.getString("name")));
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerTickets;

	}

}
