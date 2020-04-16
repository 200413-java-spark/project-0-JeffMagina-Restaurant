package com.github.jeffmagina.restaurant.customer;

import com.github.jeffmagina.restaurant.order.Order;

public class Customer {
    public String name;
    public Order order;

    public Customer(String name, Order order){
        this.name = name;
        this.order = order;
    }

    public Customer(){}

}