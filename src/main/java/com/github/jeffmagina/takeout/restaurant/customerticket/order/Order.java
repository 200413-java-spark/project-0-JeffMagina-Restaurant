package com.github.jeffmagina.takeout.restaurant.customerticket.order;

import java.util.ArrayList;

import com.github.jeffmagina.takeout.format.Format;
import com.github.jeffmagina.takeout.restaurant.menu.Menu;

public class Order {

	public int orderItemId;
	public int quantity;
	public String name;

	public Order(int orderItemId, int quantity, String name) {
		this.orderItemId = orderItemId;
		this.quantity = quantity;
		this.name = name;
	}

	public Order(int quantity, String name) {
		this.quantity = quantity;
		this.name = name;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return this.quantity + " " + this.name;
	}

	public ArrayList<Order> parseOrder(String rawOrder) {
		Format format = new Format();
		ArrayList<Order> order = new ArrayList<Order>();

		String[] custOrder = rawOrder.split("/");
		for (int j = 0; j < custOrder.length; j++) {
			String[] splitCustOrder = custOrder[j].split(" ");
			// check if quantity is in fact a number
			try {
				this.quantity = Integer.parseInt(splitCustOrder[0]);
			} catch (NumberFormatException ex) {
				System.err.println("Unable to parse quantity " + splitCustOrder[0]);
			}
			this.name = format.firstLettertoUpperCase(splitCustOrder[1]);

			// Check if menu item exists
			if (new Menu().contains(name)) {
				order.add(new Order(quantity, name));
			} else {
				System.err.println("Invalid Menu item: " + this.name + "\nFood choice does not exist");
			}
		}
		return order;
	}
}
