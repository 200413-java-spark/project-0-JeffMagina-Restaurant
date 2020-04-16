package com.github.jeffmagina.restaurant.cashier;

import com.github.jeffmagina.restaurant.menu.Menu;

import java.util.ArrayList;

public class Cashier {

    public String name;
    private double orderCost;
    private double change;

    public Cashier(String name){
        this.name = name;
    }

    public Menu populateMenu(){
        Menu jeffsMenu = new Menu();

        //changed to text file eventually

        jeffsMenu.addMenuItem("Chicken", 9.50);
        jeffsMenu.addMenuItem("Steak", 10.50);
        jeffsMenu.addMenuItem("Fish", 8.50);
        jeffsMenu.addMenuItem("Vegetarian", 6.00);
        jeffsMenu.addMenuItem("Fries", 3.00); 

        return jeffsMenu;
    }

    public void greeting(String customerName, Menu menu){
        System.out.println("\nHello " + customerName 
        + ", Welcome to Jeff's Restaurant! \n" 
        + "Our menu options are: \n"); 
        menu.displayMenu();
        System.out.println("\nThe order you have placed is: ");
    }

    public void displayCustOrder(ArrayList<String> custOrder){
        for(int i = 0; i < custOrder.size(); i++){
            System.out.println(custOrder.get(i));  
        }

    }

    public double displayCustOrderCost(ArrayList<String> custOrder, Menu menu){      
        this.orderCost = calcCost(custOrder, menu);
        System.out.println("\nThe cost of your order is: " + orderCost);
        return orderCost;
    }

    public double payment(double custPayment){
            change = custPayment - orderCost;
            System.out.println("\nYour payment amount was: " + custPayment);
            return change;
    }

     public void displayChange(){
         System.out.print("\nYour change is: ");
         System.out.println(change + "\n");
     }

    private double calcCost(ArrayList<String> order,Menu menu){
        double cost = 0.0;
            for(int i = 0; i<order.size(); i++){
                for(int j = 0; j<menu.size(); j++){
                    if(order.get(i).equals(menu.getItem(j).name)){                   
                        cost = cost + menu.getItem(j).cost;
                    }
                } 
            }
            return cost;
    }

    public void storeOrder(String custName,ArrayList<String> custOrder, double custOrderCost, double custPayment, double changeGiven){

        //Maybe make an order class with this info
        System.out.println("Order Stored: " );
        System.out.print("Customer Name: ");
        System.out.println(custName);
        System.out.print("Customer Order: ");
        System.out.println(custOrder);
        System.out.print("Order Cost: ");
        System.out.println(custOrderCost);
        System.out.print("Customer Payment: ");
        System.out.println(custPayment);
        System.out.print("Customer Change: ");
        System.out.println(changeGiven);
    }

    public void displayOrderHistory(){}

}