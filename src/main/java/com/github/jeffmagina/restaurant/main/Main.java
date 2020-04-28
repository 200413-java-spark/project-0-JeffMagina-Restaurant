package com.github.jeffmagina.restaurant.main;

import java.io.File;
import java.util.ArrayList;

import com.github.jeffmagina.io.ParseInputFileRepo;
import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;


public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		OrderHistory orderHistory = new OrderHistory();
		File orderForm = new File("OrderForm.txt");

		// Parse Order from text file and store into an array of CustomerTickets
		ArrayList<CustomerTicket> customerTickets = new ParseInputFileRepo(orderForm).readAll();

		//loops over how many Tickets in orderForm.txt
		for (int i = 0; i < customerTickets.size(); i++) {
			// cashier interactions with customer
			CustomerTicket filledCustomerTicket = cashier.interaction(customerTickets.get(i));
			
			// stores data into database and txt file
			orderHistory = new IO().storeOrder(filledCustomerTicket,"history.txt");	
		}
		
		// display what is in order history, which should match database, and txt file
		orderHistory.displayAllOrders();
		System.out.println("done");
	}
}
