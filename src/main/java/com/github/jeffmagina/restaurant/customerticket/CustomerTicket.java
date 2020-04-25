package com.github.jeffmagina.restaurant.customerticket;

import java.util.ArrayList;

import com.github.jeffmagina.restaurant.customer.Customer;
import com.github.jeffmagina.restaurant.customerticket.order.Order;

public class CustomerTicket {
	public int customerTicketId;
	public Customer customer;
	public ArrayList<Order> order;
	public double paymentAmount;
	public double orderCost;
	public double changeGiven;

	public CustomerTicket() {
	}

	public CustomerTicket(Customer customer, ArrayList<Order> order, double paymentAmount,
			double orderCost, double changeGiven) {
		this.customer = new Customer();
		this.order = new ArrayList<Order>();
		this.paymentAmount = paymentAmount;
		this.orderCost = orderCost;
		this.changeGiven = changeGiven;
	}

	public void displayCustomerTicket() {
		for (int i = 0; i < order.size(); i++) {
			System.out.println(order.get(i).toString());
		}
	}

	public int size() {
		return this.order.size();
	}

	@Override
	public String toString() {
		StringBuilder order = new StringBuilder();
		for (int i = 0; i < this.order.size(); i++) {
			order.append(this.order.get(i).quantity);
			order.append(" ");
			order.append(this.order.get(i).name);
			if (i < this.order.size() - 1) {
				order.append("&");
			}
		}

		return this.customer.customerId + "," + this.customer.name + "," + order + "," + this.orderCost + ","
				+ this.paymentAmount + "," + this.changeGiven;
	}

}
