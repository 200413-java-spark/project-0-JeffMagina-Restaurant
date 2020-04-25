package com.github.jeffmagina.restaurant.customerticket.order;

public class Order {

	public int orderItemId;
	public int quantity;
	public String name;
	
	@Override
	public String toString() {
		return this.quantity + " " + this.name;
	}

}
