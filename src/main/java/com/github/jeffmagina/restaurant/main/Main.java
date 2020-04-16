package com.github.jeffmagina.restaurant.main;

import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.menu.Menu;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args){
        Cashier cashier = new Cashier("Jim");
        Menu jeffsMenu = new Menu();

        //Most will go into text file
        String custName = "Gary";
        double custPayment = 40.00;
        double custOrderCost = 0.0;
        double custChange = 0.0;
        ArrayList<String> custOrder = new ArrayList<>(); 
        custOrder.add("Fries");
        custOrder.add("Steak");

        jeffsMenu = cashier.populateMenu();
        cashier.greeting(custName,jeffsMenu);
        cashier.displayCustOrder(custOrder);
        custOrderCost = cashier.displayCustOrderCost(custOrder, jeffsMenu);
        custChange = cashier.payment(custPayment);
        cashier.displayChange();
        cashier.storeOrder(custName,custOrder,custOrderCost, custPayment,custChange);
        cashier.displayOrderHistory(); //databasestuff
    }
}