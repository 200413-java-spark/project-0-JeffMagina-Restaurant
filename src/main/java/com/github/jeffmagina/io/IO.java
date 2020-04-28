package com.github.jeffmagina.io;

import java.io.File;
import java.io.IOException;

import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;

public class IO {

	public OrderHistory storeOrder(CustomerTicket filledCustomerTicket, String fileName) {
		SqlOrderRepo orderRepo = new SqlOrderRepo();
		// insert into database
		orderRepo.insert(filledCustomerTicket);
		
		// update order history to match database
		OrderHistory orderHistory = new OrderHistory();
		orderHistory.addCustomerTickets(orderRepo.readAll());
		
		// delete oldhistory.txt file
		File oldhistory = new File(fileName);
		oldhistory.delete();

		// create newhistory.txt file
		File newhistory = new File(fileName);
		try {
			newhistory.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// insert database data into .txt file
		HistoryOutputFileRepo writer = new HistoryOutputFileRepo(newhistory);
		for (int i = 0; i < orderHistory.allCustomerTickets.size(); i++) {
			writer.insert(orderHistory.allCustomerTickets.get(i));
		}
		return orderHistory;
		
	}
}
