package com.github.jeffmagina.takeout.restaurant.customerticket;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.github.jeffmagina.takeout.restaurant.customer.Customer;
import com.github.jeffmagina.takeout.restaurant.customerticket.order.Order;

public class CustomerTicket {
	public int customerTicketId;
	public Customer customer;
	public ArrayList<Order> order;
	public BigDecimal paymentAmount;
	public BigDecimal orderCost;
	public BigDecimal changeGiven;

	public CustomerTicket() {
		this.customer = new Customer();
		this.order = new ArrayList<Order>();
	}

	public CustomerTicket(Customer customer, ArrayList<Order> order, double paymentAmount, double orderCost, double changeGiven) {			
		this.customer = customer;
		this.order = order;
		this.paymentAmount = BigDecimal.valueOf(paymentAmount).setScale(2);
		this.orderCost = BigDecimal.valueOf(orderCost).setScale(2);
		this.changeGiven = BigDecimal.valueOf(changeGiven).setScale(2);
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
				order.append("/");
			}
		}

		return this.customer.customerId + "," + this.customer.name + "," + order + "," + this.orderCost + ","
				+ this.paymentAmount + "," + this.changeGiven;
	}

}
