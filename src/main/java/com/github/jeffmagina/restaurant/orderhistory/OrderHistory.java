package com.github.jeffmagina.restaurant.orderhistory;

import java.util.ArrayList;

import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;

public class OrderHistory extends CustomerTicket {

	public ArrayList<CustomerTicket> allCustomerTickets = new ArrayList<CustomerTicket>();

	public void addCustomerTickets (ArrayList<CustomerTicket> customerTickets) {
		for(int i = 0; i < customerTickets.size(); i++) {
			allCustomerTickets.add(customerTickets.get(i));
		}
	}

	public void displayAllOrders() {
		for (int i = 0; i < allCustomerTickets.size(); i++) {
			System.out.println(allCustomerTickets.get(i));
		}
	}
	
	public CustomerTicket get(int i) {
	if (i >= allCustomerTickets.size() || i < 0) {
		throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
	}
	return allCustomerTickets.get(i);
	}
}