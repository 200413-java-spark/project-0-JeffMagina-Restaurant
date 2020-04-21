package com.github.jeffmagina.restaurant.cashier;

import java.io.File;
import java.util.ArrayList;

import com.github.jeffmagina.io.IO;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import com.github.jeffmagina.restaurant.menu.Menu;
import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;
//import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;

public class Cashier {

	final public String name = "Jeff";
	
	private ArrayList<CustomerOrder> custOrders = new ArrayList<>();
	public Menu menu = new Menu();
	private CustomerOrder custOrder = new CustomerOrder();

	public Cashier() {
	}
	
	public CustomerOrder interaction(CustomerOrder custOrder) {	
		this.custOrder = custOrder;
		
		greeting();
		takeOrder();
		transaction();
		storeOrder();
		
		return custOrder;
	}

	private void greeting() {	
		System.out.println("\nHello " + custOrder.name + "! My name is " + this.name + "!"
				+ "\nWelcome to Jeff's Restaurant! \n" + "Our menu options are: \n");
		this.menu.displayMenu();

	}

	private void takeOrder() {	
		System.out.println("\nThe order you have placed is: ");
		custOrder.displayCustOrder();
	}

	private void transaction() {
		custOrder.orderCost = calcCost(custOrder);
		System.out.println("\nThe cost of your order is: " + custOrder.orderCost);
		System.out.println("\nYour payment amount was: " + custOrder.paymentAmount);

		custOrder.changeGiven = custOrder.paymentAmount - custOrder.orderCost;

		if (custOrder.changeGiven >= 0) {
			System.out.println("\nYour change is: " + custOrder.changeGiven);
		} else {
			System.out.println("\nInsufficient funds! Come back sufficient funds!\n");
			System.exit(0);
		}

	}

	private void storeOrder(){
        System.out.println("\nOrder Stored: " );
        System.out.print("Customer Name: ");
        System.out.println(custOrder.name);
        System.out.print("Customer Order: ");
        System.out.println(custOrder.order);
        System.out.print("Order Cost: ");
        System.out.println(custOrder.orderCost);
        System.out.print("Customer Payment: ");
        System.out.println(custOrder.paymentAmount);
        System.out.print("Customer Change: ");
        System.out.println(custOrder.changeGiven);
        
		File history = new File("history.txt");
    	IO writer= new IO();
    	OrderHistory orderhistory = new OrderHistory();
    	
    	orderhistory.storeOrder(custOrder);
    	orderhistory.displayAllOrders();
    	
        writer.write(history, custOrder);
        writer.read(history, custOrder, this.custOrders);
        
    }
	
	private double calcCost(CustomerOrder order) {
		double cost = 0.0;
		for (int i = 0; i < order.size(); i++) {
			for (int j = 0; j < this.menu.size(); j++) {
				if (order.getItem(i).toLowerCase().equals(this.menu.getItem(j).name.toLowerCase())) {
					cost = cost + this.menu.getItem(j).cost;
				}
			}
		}
		return cost;
	}
}