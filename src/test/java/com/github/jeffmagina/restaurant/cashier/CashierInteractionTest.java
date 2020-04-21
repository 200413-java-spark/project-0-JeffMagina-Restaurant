package com.github.jeffmagina.restaurant.cashier;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class CashierInteractionTest {
	Cashier testCashier = new Cashier();
	CustomerOrder testCustomerOrder;
	ArrayList<String> testOrder = new ArrayList<String>();

	
	@Before
	public void setup() {
		testOrder.add("Steak");
		testOrder.add("Fries");
		this.testCustomerOrder = new CustomerOrder("Jim",testOrder,0,100.00,0);
	}
	
	@Test
	public void cashierInteractionTest() {
		
		//Experiment
		CustomerOrder expected = new CustomerOrder("Jim",testOrder,13.50,100.00,86.50);
		CustomerOrder actual = testCashier.interaction(testCustomerOrder);
		
		//Assert
		assertEquals(expected.name, actual.name);
		assertEquals(expected.order, actual.order);
		assertEquals(expected.paymentAmount, actual.paymentAmount,0.00);
		assertEquals(expected.orderCost, actual.orderCost,0.00);
		assertEquals(expected.changeGiven, actual.changeGiven,0.00);
	}
	

}