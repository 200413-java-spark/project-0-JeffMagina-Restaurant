package com.github.jeffmagina.takeout.format;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.takeout.restaurant.customerticket.order.Order;

public class Format {
	public String firstLettertoUpperCase(String stringbuffer) {
		StringBuilder sb = new StringBuilder();
		sb.append(Character.toUpperCase(stringbuffer.charAt(0)));
		sb.append(stringbuffer.substring(1).toLowerCase());
		return sb.toString();
	}
	
	public CustomerTicket parseOrderForm(String rawOrderForm) {
		CustomerTicket customerTicket = new CustomerTicket();
		
		// take raw string data parse and format
		String[] buffer = rawOrderForm.split(",");

		// add customer name to customer order from file - formatted
		customerTicket.customer.name = firstLettertoUpperCase(buffer[0]);

		// take customer order parse, format, and add to customer order
		customerTicket.order = new Order().parseOrder(buffer[1]);

		// add customer payment amount to customer order from file
		try {
		customerTicket.paymentAmount = BigDecimal.valueOf(Double.parseDouble(buffer[2])).setScale(2);
		} catch (NumberFormatException ex) {
			System.err.println("Unable to parse Payment Amount: " + buffer[2]);
		}	
		return customerTicket;
	}
	
	public ArrayList<CustomerTicket> ParseCustOrderForms(ArrayList<String> messages) {
		ArrayList<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

		for (int i = 0; i < messages.size(); i++) {
			customerTickets.add(parseOrderForm(messages.get(i)));
		}
		
		return customerTickets;
	}

}
