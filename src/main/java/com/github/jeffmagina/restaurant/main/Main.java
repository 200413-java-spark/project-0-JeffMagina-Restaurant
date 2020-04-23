package com.github.jeffmagina.restaurant.main;

import java.io.File;
import java.util.ArrayList;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.io.OrderRepo;
import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();
		File orderForm = new File("OrderForm.txt");
		IO parser = new IO();

		// Parse order
		CustomerOrder custOrder = new CustomerOrder();
		custOrder = parser.ParseCustOrderForm(orderForm);

		//Cashier interactions with customer
		cashier.interaction(custOrder);
		
		//store into file and database
		cashier.storeOrder();
		
		ArrayList<CustomerOrder> custOrders = new ArrayList<CustomerOrder>();
		custOrders.add(custOrder);
		
		
		

		
		System.out.println("done");
		

	}
}
