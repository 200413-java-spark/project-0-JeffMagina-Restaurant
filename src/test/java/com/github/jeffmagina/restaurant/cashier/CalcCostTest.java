package com.github.jeffmagina.restaurant.cashier;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;

public class CalcCostTest {
	
	Cashier testCashier = new Cashier();
	CustomerOrder testCustomerOrder;
	
	
	@Before
	public void setup() {
		ArrayList<String> testOrder = new ArrayList<String>();
		testOrder.add("steak");
		testOrder.add("fries");
		
		this.testCustomerOrder = new CustomerOrder("Jim",testOrder,0,100.00,0);
	}
	
	@Test
	public void calcCostSteakAndFries() {
		
		//Experiment
		double expected = 13.50;
		double actual = testCashier.calcCost(testCustomerOrder);
		
		//Assert
		assertEquals(expected, actual, 0.0);
	}
	

}
