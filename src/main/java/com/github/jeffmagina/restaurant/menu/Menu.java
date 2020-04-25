package com.github.jeffmagina.restaurant.menu;

import java.util.ArrayList;

import com.github.jeffmagina.restaurant.menu.food.Food;

public class Menu {

	// Create menu storage
	private ArrayList<Food> menu = new ArrayList<Food>();

	public Menu() {
		populateMenu();
	}

	public void populateMenu() {
		addMenuItem("Chicken", 9.50);
		addMenuItem("Steak", 10.50);
		addMenuItem("Fish", 8.50);
		addMenuItem("Vegetarian", 6.00);
		addMenuItem("Fries", 3.00);
	}

	public void addMenuItem(String name, double cost) {
		Food menuItem = new Food(name, cost);
		this.menu.add(menuItem);
	}

	public void displayMenu() {
		for (int i = 0; i < this.menu.size(); i++) {
			System.out.println(this.menu.get(i).name + ", " + this.menu.get(i).cost);
		}
	}

	public int size() {
		return this.menu.size();
	}

	public Food getItem(int i) {
		if (i >= this.menu.size() || i < 0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
		}
		return this.menu.get(i);
	}

}