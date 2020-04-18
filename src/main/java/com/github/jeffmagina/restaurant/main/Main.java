package com.github.jeffmagina.restaurant.main;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import com.github.jeffmagina.restaurant.menu.Menu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Create Objects needed
		Cashier cashier = new Cashier("Jeff");
		Menu jeffsMenu = new Menu();
		CustomerOrder customerOrder = new CustomerOrder();
		ArrayList<CustomerOrder> custOrders = new ArrayList<>();
		
		File history = new File("history.txt");
		File orderForm = new File("C:\\Users\\Jeff\\Revature\\project-0\\src\\main\\resources\\OrderForm.txt");

		// Read File and Create Customer Order
		IO readOrderForm = new IO();
		try {
			customerOrder = readOrderForm.ParseCustOrderForm(orderForm);
		} catch (IOException e) {
			System.out.println("Error has occured reading file");
		}

		// Populate Menu
		jeffsMenu.populateMenu();

		// Cashier interactions with customer
		cashier.greeting(customerOrder, jeffsMenu);
		cashier.takeOrder(customerOrder);
		cashier.transaction(customerOrder, jeffsMenu);
		cashier.storeOrder(customerOrder);
		// cashier.displayOrderHistory(); // database stuff

		IO write = new IO();
		write.write(history, customerOrder);
		write.read(history, customerOrder, custOrders);
	}
}
