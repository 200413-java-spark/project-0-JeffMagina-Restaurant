package com.github.jeffmagina.takeout.restaurant.customer;

public class Customer {
	
	public int customerId;
	public String name;
	
	public Customer(int customerID, String name) {
		this.customerId = customerID;
		this.name= name;
	}
	public Customer() {}
}
