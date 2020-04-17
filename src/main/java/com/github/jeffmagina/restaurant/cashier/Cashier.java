package com.github.jeffmagina.restaurant.cashier;

import com.github.jeffmagina.restaurant.customerorder.CustomerOrder;
import com.github.jeffmagina.restaurant.menu.Menu;
//import com.github.jeffmagina.restaurant.orderhistory.OrderHistory;

public class Cashier {

    private String name;

    public Cashier(String name){
        this.name = name;
    }

    public void greeting(CustomerOrder custOrder, Menu menu){
        System.out.println("\nHello " + custOrder.name 
        + "! My name is " + this.name + "!"
        + "\nWelcome to Jeff's Restaurant! \n" 
        + "Our menu options are: \n"); 
        menu.displayMenu();
        
    }

    public void takeOrder(CustomerOrder custOrder){
        System.out.println("\nThe order you have placed is: ");
        custOrder.displayCustOrder();
    }

    public void transaction(CustomerOrder custOrder, Menu menu){
        custOrder.orderCost = calcCost(custOrder, menu);
        System.out.println("\nThe cost of your order is: " + custOrder.orderCost);
        System.out.println("\nYour payment amount was: " + custOrder.paymentAmount);

        custOrder.changeGiven = custOrder.paymentAmount - custOrder.orderCost;

        if(custOrder.changeGiven >= 0){
            System.out.println("\nYour change is: " + custOrder.changeGiven);
        } else{
            System.out.println("\nInsufficient funds! Come back sufficient funds!\n");
            System.exit(0);
        }

    }

    private double calcCost(CustomerOrder order,Menu menu){
        double cost = 0.0;
            for(int i = 0; i<order.size(); i++){
                for(int j = 0; j<menu.size(); j++){
                    if(order.getItem(i).equals(menu.getItem(j).name)){                   
                        cost = cost + menu.getItem(j).cost;
                    }
                } 
            }
            return cost;
    }

    public void storeOrder(CustomerOrder customerOrder){

        //Maybe make an order class with this info
        System.out.println("\nOrder Stored: " );
        System.out.print("Customer Name: ");
        System.out.println(customerOrder.name);
        System.out.print("Customer Order: ");
        System.out.println(customerOrder.order);
        System.out.print("Order Cost: ");
        System.out.println(customerOrder.orderCost);
        System.out.print("Customer Payment: ");
        System.out.println(customerOrder.paymentAmount);
        System.out.print("Customer Change: ");
        System.out.println(customerOrder.changeGiven);
    }

    public void displayOrderHistory(){
       // OrderHistory orderHistory = new OrderHistory();
        
        //store in database
    }

}