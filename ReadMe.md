# Restaurant Takeout orders

## Input:
* A plain text file in the following form:  
Name  
Order  
Payment  

## Expected Output
* Console expected to output a greeting, take an order, do a transaction with the order, store the order
* Write to a history.txt which holds a history of all orders

### Console Expected Output
Hello (display customer name) ! My name is Jeff!  
Welcome to Jeff's Restaurant!  
Our menu options are:  

(display menu options)  

The order you have placed is:   

(display customer order)  

The cost of your order is: (order cost)  

Your payment amount was: (customer payment)  

Your change is: (Change Given)  

Order Stored:  
(Order that is stored in form:)  
    Customer Name: (Customer Name)  
    Customer Order: (Customer Order)  
    Order Cost: (Customer Order Cost)  
    Customer Payment: (Customer Payment)  
    Customer Change: (Customer Change Given)  

### history.txt Expected Output
(Customer Name) (Customer Order) (Customer Order Cost) (Customer Payment) (Customer Change Given)

## Example Input and Output
### Example Input
Gary  
Steak Steak Steak Steak  
150.00  

### Console Expected Output
Hello Gary! My name is Jeff!  
Welcome to Jeff's Restaurant!  
Our menu options are:  

chicken, 9.5  
steak, 10.5  
fish, 8.5  
vegetarian, 6.0  
fries, 3.0  

The order you have placed is:  
steak  
steak  
steak  
steak  

The cost of your order is: 42.0  

Your payment amount was: 150.0  

Your change is: 108.0  

Order Stored:  
Customer Name: Gary  
Customer Order: [steak, steak, steak, steak]  
Order Cost: 42.0  
Customer Payment: 150.0  
Customer Change: 108.0  

### history.txt Expected Output
Gary [steak, steak, steak, steak] 42.0 150.0 108.0