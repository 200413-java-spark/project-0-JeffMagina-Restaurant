package com.github.jeffmagina.restaurant.customerticket.order;

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

}
