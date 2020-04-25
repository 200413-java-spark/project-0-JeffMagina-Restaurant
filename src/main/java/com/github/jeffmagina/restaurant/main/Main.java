package com.github.jeffmagina.restaurant.main;

import java.io.File;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;

public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		File orderForm = new File("OrderForm.txt");
		IO parser = new IO();

		// Parse order
		String rawCustomerTicket = parser.readFile(orderForm);

		CustomerTicket customerTicket= new CustomerTicket();
		customerTicket = parser.ParseCustOrderForm(rawCustomerTicket);
		
		//Cashier interactions with customer
		cashier.interaction(customerTicket);
		
		//store into file and database
		cashier.storeOrder();
		
		//displays all orders in OrderHistory
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.displayAllOrders();
		
		System.out.println("done");
		

	}
}
