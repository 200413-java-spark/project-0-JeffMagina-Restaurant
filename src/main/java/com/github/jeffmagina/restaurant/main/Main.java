package com.github.jeffmagina.restaurant.main;

import com.github.jeffmagina.restaurant.cashier.Cashier;
import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import com.github.jeffmagina.restaurant.menu.Menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.github.jeffmagina.restaurant.readresourcefile.*;


public class Main {    
    public static void main(String [] args) throws IOException{
            //Create Objects needed
            Cashier cashier = new Cashier("Jeff");
            Menu jeffsMenu = new Menu();
            ReadResourceFile readFile = new ReadResourceFile();
            CustomerOrder customerOrder = new CustomerOrder();

            //Read File
            readFile.readFile("OrderForm.txt");

            //Create Customer Order
            customerOrder = ParseFile2(readFile.message);
            
            //Populate Menu
            jeffsMenu.populateMenu();

            //Cashier interactations with customer
            cashier.greeting(customerOrder,jeffsMenu);
            cashier.takeOrder(customerOrder);
            cashier.transaction(customerOrder,jeffsMenu);
            cashier.storeOrder(customerOrder);
            cashier.displayOrderHistory(); //databasestuff       
    }

    public static CustomerOrder ParseFile2(ArrayList<String> file){
        CustomerOrder customerOrder = new CustomerOrder();

        // add customer name to customer order from file
        customerOrder.name = file.get(0);

        // add customer order to customer order from file
        String order = file.get(1);
        StringTokenizer orderToken = new StringTokenizer(order, " ");
            ArrayList<String> custOrder = new ArrayList<>(); 
            while(orderToken.hasMoreTokens()){
                custOrder.add(orderToken.nextToken().toLowerCase());
            }
        customerOrder.order = custOrder;

        // add customer payment amount to customer order from file
        customerOrder.paymentAmount = Double.parseDouble(file.get(2));
        return customerOrder;

    }
}

