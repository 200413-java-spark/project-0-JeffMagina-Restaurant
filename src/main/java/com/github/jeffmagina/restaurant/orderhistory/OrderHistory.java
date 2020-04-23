package com.github.jeffmagina.restaurant.orderhistory;

import com.github.jeffmagina.io.OrderRepo;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import java.util.ArrayList;
//import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class OrderHistory extends CustomerOrder {

	static ArrayList<CustomerOrder> allOrders = new ArrayList<CustomerOrder>();
	OrderRepo orderRepo = new OrderRepo();

	public OrderHistory() {
	}

	public void storeOrder(CustomerOrder custOrder) {
		
		allOrders.add(custOrder);
		// store in database
		orderRepo.insertAll(allOrders);
		
	}

	public void displayAllOrders() {
		allOrders = orderRepo.readAll();
    	for(int i = 0; i < allOrders.size(); i++) {
    	System.out.println(allOrders.get(i));
    	}
    }
}