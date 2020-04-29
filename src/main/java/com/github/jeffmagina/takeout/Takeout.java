package com.github.jeffmagina.takeout;

import java.io.File;
import java.util.ArrayList;

import com.github.jeffmagina.takeout.format.Format;
import com.github.jeffmagina.takeout.io.IO;
import com.github.jeffmagina.takeout.io.ParseInputFileRepo;
import com.github.jeffmagina.takeout.restaurant.cashier.Cashier;
import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.takeout.restaurant.orderhistory.OrderHistory;

public class Takeout {
	public static void main(String[] args) {
		if (args.length != 0) {
			Cashier cashier = new Cashier();
			OrderHistory orderHistory = new OrderHistory();
			
			if (args[0].equals("parse")) {
				File inputFile = new File(args[1]);
				
				// Parse Order from text file and store into an array of CustomerTickets
				ArrayList<CustomerTicket> customerTickets = new ParseInputFileRepo(inputFile).readAll();

				// loops over how many Tickets in orderForm.txt
				for (int i = 0; i < customerTickets.size(); i++) {
					// cashier interactions with customer
					CustomerTicket filledCustomerTicket = cashier.interaction(customerTickets.get(i));

					// stores data into database and txt file
					orderHistory = new IO().storeOrder(filledCustomerTicket);
				}
			} else {
				Format format = new Format();
				// take in command line args and prep for parsing
				String rawOrderForm = new String();
				for (int i = 0; i < args.length; i++) {
					if (i == args.length - 1) {
						rawOrderForm = rawOrderForm.concat(args[i]);
					} else {
						rawOrderForm = rawOrderForm.concat(args[i]) + ",";
					}
				}

				CustomerTicket filledCustomerTicket = format.parseOrderForm(rawOrderForm);

				// cashier interactions with customer
				cashier.interaction(filledCustomerTicket);

				// stores data into database and txt file
				orderHistory = new IO().storeOrder(filledCustomerTicket);
			}

			// display what is in order history, which should match database, and txt file
			orderHistory.displayAllOrders();
			System.out.println("done");
		} else {
			// Usage help
			System.out.println("Usage: ");
			System.out.println("      takeout parse");
			System.out.println("      takeout [CustomerName] [Order] [PaymentAmount]");
		}
	}
}
