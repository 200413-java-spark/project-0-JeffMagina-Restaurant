package com.github.jeffmagina.restaurant.cashier;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.jeffmagina.restaurant.customer.Customer;
import com.github.jeffmagina.restaurant.customerticket.CustomerTicket;
import com.github.jeffmagina.restaurant.customerticket.order.Order;

public class CashierInteractionTest {
	Cashier testCashier = new Cashier();
	Customer testCustomer = new Customer(1,"Jim");
	CustomerTicket testCustomerTicket = new CustomerTicket();
	Order testOrder = new Order();
	ArrayList<Order> testOrderArray = new ArrayList<Order>();

	
	@Before
	public void setup() {
		testCustomerTicket.customer = testCustomer;
		
		
		testOrder.orderItemId = 1;
		testOrder.quantity = 1;
		testOrder.name = "Fries";
		
		testOrderArray.add(testOrder);
		
		testCustomerTicket.order = testOrderArray;
		testCustomerTicket.paymentAmount = 100.00;
		
		System.out.print("");
	}
	
	@Test
	public void cashierInteractionTest() {
		
		//Experiment
		CustomerTicket expected = new CustomerTicket(testCustomer,testOrderArray,100.00,3.00,97.00);
		CustomerTicket actual = testCashier.interaction(testCustomerTicket);
		
		//Assert
		assertEquals(expected.orderCost, actual.orderCost,0.00);
		assertEquals(expected.changeGiven, actual.changeGiven,0.00);
	}
	

}