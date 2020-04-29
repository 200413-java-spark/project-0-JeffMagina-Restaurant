package com.github.jeffmagina.takeout.restaurant.cashier;

import java.math.BigDecimal;

import com.github.jeffmagina.takeout.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.takeout.restaurant.menu.Menu;

public class Cashier {

	final public String name = "Jeff";

	public Menu menu = new Menu();
	private CustomerTicket customerTicket = new CustomerTicket();

	public Cashier() {
	}

	public CustomerTicket interaction(CustomerTicket customerTicket) {
		this.customerTicket = customerTicket;

		greeting();
		takeOrder();
		transaction();

		return this.customerTicket;
	}

	private void greeting() {
		System.out.println("\nHello " + this.customerTicket.customer.name + "! My name is " + this.name + "!"
				+ "\nWelcome to Jeff's Restaurant! \n" + "Our menu options are: \n");
		this.menu.displayMenu();

	}

	private void takeOrder() {
		System.out.println("\nThe order you have placed is: ");
		this.customerTicket.displayCustomerTicket();
	}

	private void transaction() {
		this.customerTicket.orderCost = calcCost(this.customerTicket);
		System.out.println("\nThe cost of your order is: $" + this.customerTicket.orderCost);
		System.out.println("\nYour payment amount was: $" + this.customerTicket.paymentAmount);

		this.customerTicket.changeGiven = this.customerTicket.paymentAmount.subtract(this.customerTicket.orderCost);

		if (this.customerTicket.changeGiven.doubleValue() >= 0) {
			System.out.println("\nYour change is: $" + this.customerTicket.changeGiven);
		} else {
			System.out.println("\nInsufficient funds! Come back sufficient funds!\n");
			System.exit(0);
		}
	}

	private BigDecimal calcCost(CustomerTicket customerTicket) {
		double cost = 0.0;
		for (int i = 0; i < customerTicket.order.size(); i++) {
			for (int j = 0; j < this.menu.size(); j++) {
				if (customerTicket.order.get(i).name.toLowerCase().equals(this.menu.getItem(j).name.toLowerCase())) {
					cost = cost + (this.menu.getItem(j).cost * customerTicket.order.get(i).quantity);
				}
			}
		}
		
		return BigDecimal.valueOf(cost).setScale(2);
	}
}