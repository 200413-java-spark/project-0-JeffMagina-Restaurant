package com.github.jeffmagina.restaurant.menu;

import com.github.jeffmagina.restaurant.food.Food;
import java.util.ArrayList;

public class Menu {
    
    //Create menu storage
    ArrayList<Food> menu = new ArrayList<Food>();
    
    public Menu(){};

    public void addMenuItem(String name, double cost){
        Food menuItem = new Food(name,cost);
        menu.add(menuItem);
    }

    public void displayMenu(){
        for(int i = 0; i < menu.size(); i++){
            System.out.println(menu.get(i).name + ", " + menu.get(i).cost);  
        }
    }

    public int size(){
        return this.menu.size();
    }

    public Food getItem(int i){
        if (i >= menu.size() || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        } return menu.get(i);
    }

}