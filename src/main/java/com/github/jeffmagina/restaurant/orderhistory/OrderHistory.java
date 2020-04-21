package com.github.jeffmagina.restaurant.orderhistory;

import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import java.util.ArrayList;
//import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class OrderHistory extends CustomerOrder {

	static ArrayList<CustomerOrder> allOrders = new ArrayList<CustomerOrder>();

	public OrderHistory() {
	}

	public void storeOrder(CustomerOrder custOrder) {
		this.allOrders.add(custOrder);
		// store in database
	}

	public void displayAllOrders() {
    	for(int i = 0; i < allOrders.size(); i++) {
    	System.out.println(this.allOrders.get(i));
    	}
    }
}