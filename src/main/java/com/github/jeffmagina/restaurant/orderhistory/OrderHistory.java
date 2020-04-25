package com.github.jeffmagina.restaurant.orderhistory;

import java.util.ArrayList;

import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;

public class OrderHistory extends CustomerTicket {

	public static ArrayList<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

	public OrderHistory() {
	}

	public void storeOrder(CustomerTicket customerTicket) {

		customerTickets.add(customerTicket);
		// store in database
		// orderRepo.insertAll(allOrders);
	}

	public void displayAllOrders() {
		for (int i = 0; i < customerTickets.size(); i++) {
			System.out.println(customerTickets.get(i));
		}
	}

}