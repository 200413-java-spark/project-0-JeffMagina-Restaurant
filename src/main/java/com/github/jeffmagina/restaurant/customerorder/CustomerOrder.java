package com.github.jeffmagina.restaurant.customerorder;

import java.util.ArrayList;

public class CustomerOrder {
    public String name;
    public ArrayList<String> order;
    public double orderCost;
    public double paymentAmount;
    public double changeGiven;

    public CustomerOrder(String name, ArrayList<String> order, double payment, double paymentAmount, double changeGiven){
        this.name = name;
        this.order = order;
        this.paymentAmount = payment;
        this.paymentAmount = paymentAmount;
        this.changeGiven = changeGiven;
    }

    public CustomerOrder(){}

    public void displayCustOrder(){
        for(int i = 0; i < order.size(); i++){
            System.out.println(order.get(i));  
        }
    }

    public int size(){
        return this.order.size();
    }

    public String getItem(int i){
        if (i >= order.size() || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        } return order.get(i);
    }

}