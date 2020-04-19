package com.github.jeffmagina.restaurant.menu;

import com.github.jeffmagina.restaurant.food.Food;
import java.util.ArrayList;

public class Menu {
    
    //Create menu storage
    private ArrayList<Food> menu = new ArrayList<Food>();
    
    //*********************Make menu maybe map so i can count how many steaks for example and display that */
    
    public Menu(){
    	populateMenu();
    }
    
    public void populateMenu(){
        addMenuItem("chicken", 9.50);
        addMenuItem("steak", 10.50);
        addMenuItem("fish", 8.50);
        addMenuItem("vegetarian", 6.00);
        addMenuItem("fries", 3.00); 
    }

    public void addMenuItem(String name, double cost){
        Food menuItem = new Food(name,cost);
         this.menu.add(menuItem);
    }

    public void displayMenu(){
        for(int i = 0; i < this.menu.size(); i++){
            System.out.println(this.menu.get(i).name + ", " + this.menu.get(i).cost);  
        }
    }

    public int size(){
        return this.menu.size();
    }

    public Food getItem(int i){
        if (i >= this.menu.size() || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        } return this.menu.get(i);
    }

}