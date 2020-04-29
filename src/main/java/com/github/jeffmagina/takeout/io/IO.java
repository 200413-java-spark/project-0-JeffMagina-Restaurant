package com.github.jeffmagina.takeout.io;

import java.io.File;
import java.io.IOException;

import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.takeout.restaurant.orderhistory.OrderHistory;

public class IO {

	public OrderHistory storeOrder(CustomerTicket filledCustomerTicket) {
		SqlOrderRepo orderRepo = new SqlOrderRepo();
		// insert into database
		orderRepo.insert(filledCustomerTicket);
		
		// update order history to match database
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.addCustomerTickets(orderRepo.readAll());
		
		// delete oldhistory.txt file
		File oldHistory = new File("history.txt");
		oldHistory.delete();

		// create newhistory.txt file
		File newHistory = new File("history.txt");
		try {
			newHistory.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// insert database data into .txt file
		HistoryOutputFileRepo writer = new HistoryOutputFileRepo(newHistory);
		for (int i = 0; i < orderHistory.allCustomerTickets.size(); i++) {
			writer.insert(orderHistory.allCustomerTickets.get(i));
		}
		return orderHistory;
		
	}
}
