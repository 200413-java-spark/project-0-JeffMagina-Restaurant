package com.github.jeffmagina.takeout;

import com.github.jeffmagina.customarraylist.*;
import com.github.jeffmagina.cashier.*;

import java.util.ArrayList;
//import java.text.NumberFormat;

//Create classes or function for all the random print statements

class Takeout{
    public static void main(String[] args)
    {
        //Menu Size
        int menuSize = 5;

        //Example menu
        CustomArrayList menu = new CustomArrayList(menuSize);
        menu.addMenuItem("Chicken", 9.50);
        menu.addMenuItem("Steak", 10.50);
        menu.addMenuItem("Fish", 8.50);
        menu.addMenuItem("Vegetarian", 6.00);
        menu.addMenuItem("Fries", 3.00);

        //Global variable initializations
        String readyStatus, order, custResponse;
        readyStatus = order = custResponse = "";
        ArrayList<String> custOrder = new ArrayList<>();
        double orderCost , customerPayment = 0;
        Cashier cashier = new Cashier("Jim");

        //Greet Customer and ask for name
        cashier.greeting();

        //Store Customer name
        String customerName = System.console().readLine();

        //Print Greeting for Customer
        cashier.personalGreeting(customerName);

        //Print out Menu
        menu.printMenu(menu);
        
        //Prompt customer with options

        cashier.options();

        //Check user entry if valid option
        while(!readyStatus.equals("exit")){
            System.out.print("\nYourEntry: ");
            readyStatus = System.console().readLine().toLowerCase();

            if(readyStatus.equals("ready")){
                System.out.println("you are here");

                //Prompt user to place order
                cashier.isReadyToOrder(customerName);

                //Customer inputs order
                order = System.console().readLine();
//****************************CHECK TO MAKE SURE ORDER IS VALID */
                // Store Customer Order
                custOrder = cashier.takeOrder(order);

                //Confirm order

                custResponse = cashier.confirmOrder(custOrder);

                //LOOP TO CHECK IF IT IS CORRECT

                if (custResponse.equals("yes")){
                
                    // Calculate Cost of Customer Order
                    orderCost = cashier.calcCost(custOrder,menu);

                    // Tell the Customer the cost of the order
                    cashier.explainCost(orderCost); 

                    //************* */ Prompt Customer for amount of payment, and check to make sure it is sufficient funds
                    cashier.promptPayment();
                
                    customerPayment = Double.parseDouble(System.console().readLine());
                    System.out.println(customerPayment);

                    // Give thank customer, give Customer order
                    cashier.deliverOrder(custOrder);

                    //create change and give change

                    cashier.deliverChange(customerPayment,orderCost);

                    //******************Ask customer if they would like to place another order or exit, revert to prompt before
                    
                } else if (custResponse.equals("no")){
                    //*****************Send back to confirm order?
                } else {
                    System.out.println("Invalid Response");
                    //*************** Ask to input response again
                }


                //System.exit(1);

            } else if (readyStatus.equals("menu")) {
                // Reprint Menu
                System.out.println(menu + "\n");
            } else if (readyStatus.equals("exit")) {
                System.exit(1);
            } else {
                // Show user error message and bring them back to options
                System.out.println("Invalid Entry!\n Please type in \"ready\", \"menu\", or \"exit\"");
            }
            cashier.options();
        }
    }
//Function to store order into an ArrayList

//Function to calculate cost of Food Order
}