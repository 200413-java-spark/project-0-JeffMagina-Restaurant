package com.github.jeffmagina.restaurant.main;

import com.github.jeffmagina.restaurant.cashier.Cashier;

public class Main {
	public static void main(String[] args) {
		Cashier cashier = new Cashier();

		// Cashier interactions with customer
		cashier.interaction();
	}
}
