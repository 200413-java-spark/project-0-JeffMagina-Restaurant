package com.github.jeffmagina.restaurant.cashier;

import java.io.File;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.io.OrderRepo;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.menu.Menu;

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
		
		return customerTicket;
	}

	private void greeting() {	
		System.out.println("\nHello " + customerTicket.customer.name + "! My name is " + this.name + "!"
				+ "\nWelcome to Jeff's Restaurant! \n" + "Our menu options are: \n");
		this.menu.displayMenu();

	}

	private void takeOrder() {	
		System.out.println("\nThe order you have placed is: ");
		customerTicket.displayCustomerTicket();
	}

	private void transaction() {
		customerTicket.orderCost = calcCost(customerTicket);
		System.out.println("\nThe cost of your order is: " + customerTicket.orderCost);
		System.out.println("\nYour payment amount was: " + customerTicket.paymentAmount);

		customerTicket.changeGiven = customerTicket.paymentAmount - customerTicket.orderCost;

		if (customerTicket.changeGiven >= 0) {
			System.out.println("\nYour change is: " + customerTicket.changeGiven);
		} else {
			System.out.println("\nInsufficient funds! Come back sufficient funds!\n");
			System.exit(0);
		}

	}

	public void storeOrder(){
        System.out.println("\nOrder Stored: " );
        System.out.print("Customer Name: ");
        System.out.println(customerTicket.customer.name);
        System.out.print("Customer Order: ");
        System.out.println(customerTicket.order.toString());
        System.out.print("Order Cost: ");
        System.out.println(customerTicket.orderCost);
        System.out.print("Customer Payment: ");
        System.out.println(customerTicket.paymentAmount);
        System.out.print("Customer Change: ");
        System.out.println(customerTicket.changeGiven);
        
        //insert into database
        OrderRepo orderRepo = new OrderRepo();
        orderRepo.insert(customerTicket);
        
    	//store into text file
		File history = new File("history.txt");
    	IO writer= new IO();
        writer.write(history, customerTicket);
        writer.read(history, customerTicket);

        
    }
	
	private double calcCost(CustomerTicket customerTicket) {
		double cost = 0.0;
		for (int i = 0; i < customerTicket.order.size(); i++) {
			for (int j = 0; j < this.menu.size(); j++) {
				if (customerTicket.order.get(i).name.toLowerCase().equals(this.menu.getItem(j).name.toLowerCase())) {
					cost = cost + (this.menu.getItem(j).cost * customerTicket.order.get(i).quantity);
				}
			}
		}
		return cost;
	}
}