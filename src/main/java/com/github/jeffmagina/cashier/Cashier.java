package com.github.jeffmagina.cashier;

import com.github.jeffmagina.order.*;

public class Cashier {

    public String name;

    public Cashier(String name){
        this.name = name;
    }

    public Order takeOrder(){
        Order customerOrder = null;
        //take order
        return customerOrder;

    }
    public double calcCost(){
        double cost = 0.0;
        //give change code
        return cost;

    }
    public double giveChange(){
        double change = 0.0;
        //give change code
        return change;
    }
    public void greeting(){
        System.out.println("Hello valued Customer!\nWelcome to Jeff's Restaurant!");
        System.out.print("Please enter your name for the Togo Order: ");
    }

    public void personalGreeting(String customerName){
        System.out.println("\nHello, " + customerName +
        ", Welcome once again to Jeff's Restaurant! \n" +
        "Please take a minute to look over our menu options.\n"); 

    }
}