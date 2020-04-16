package com.github.jeffmagina.cashier;

//import com.github.jeffmagina.order.*;
import com.github.jeffmagina.customarraylist.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Cashier {

    public String name;

    public Cashier(String name){
        this.name = name;
    }

    public ArrayList<String> takeOrder(String order){
            StringTokenizer orderToken = new StringTokenizer(order, " ");
              ArrayList<String> orderArray = new ArrayList<>();
              while(orderToken.hasMoreTokens()){ 
                  orderArray.add(orderToken.nextToken()); 
                }
                return orderArray;
              
    }
    public double calcCost(ArrayList<String> order,CustomArrayList menu){
        double cost = 0.0;
            for(int i = 0; i<order.size(); i++){
                for(int j = 0; j<menu.size(); j++){
                    if(order.get(i).equals(menu.get(j).name)){
                        cost = cost + menu.get(j).cost;
                    }
                } 
            }
            return cost;

    }

    public void deliverOrder(ArrayList<String> custOrder){
        System.out.println("Thank you for selecting Jeff's Restaurant for your restaurant of choice");
        System.out.println("Here is you order: " + custOrder);
    }

    public void explainCost(double orderCost){
        System.out.println("Your order will cost: " + orderCost);
    }

    public void promptPayment(){
    System.out.print("Please give amount that you are going to pay: ");
    }

    public void deliverChange(double customerPayment, double orderCost){
        double change = 0.0;
            change = customerPayment - orderCost;
            System.out.println("Here is your change for your order: " + change);
    }
    public void greeting(){
        System.out.println("Hello valued Customer!\nWelcome to Jeff's Restaurant!");
        System.out.print("Please enter your name for the Togo Order: ");
    }

    public void personalGreeting(String customerName){
        System.out.println("\nHello " + customerName +
        ", Welcome once again to Jeff's Restaurant! \n" +
        "Please take a minute to look over our menu options.\n"); 

    }

    public void options(){
        System.out.println("\nWhen you are ready, just type in \"ready\"\n"
        + "If you would like to see menu again type in \"menu\"\n"
        + "or if you would like to leave the restaurant type in \"exit\"");
    }

    public void isReadyToOrder(String customerName){
        System.out.print("\n" + customerName + " is ready to order.\n"
        + "Please place your order now with spaces in between items like so.\n"
        + "ex.Fries Steak\n\nOrder: ");
    }

    public String confirmOrder(ArrayList<String> custOrder){
        String correct;
        System.out.println("\nYour order is: ");
        for(int i = 0; i <custOrder.size(); i++){
            System.out.println(custOrder.get(i));
        }
        System.out.println("\nIs this correct:? ");

        correct = System.console().readLine().toLowerCase();
        
        return correct;
    }
}