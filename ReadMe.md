# Restaurant Takeout
A console app to place takeout orders

## Build
### Java
>mvn clean compile 

## Usage
### For txt file batch operations
>mvn exec:java -Dexec.args="parse OrderForm.txt"

### For single operations
>mvn exec:java -Dexec.args="Jim '2 Fries' 120"

## Design
### Architecture
- Takeout is a command line application
- The restaurant package defines a Customer class, a Menu Class filled with Food type Variables(name and cost), a Cashier class that interacts with the Customer, a Customer Ticket class which holds takeout information and an OrderHistory class which contains multiple CustomerTickets
- io.ParseInputFileRepo reads in a txt file with multiple takeout orders and places them into a List of CustomerTickets
- The io.SqlDataSource creates Connection objects for SqlOrderRepository
- The io.SqlOrderRepos inserts and selects data from a sql database on an AWS server
- The io.HistoryOutFileRepo writes database information into a txt file

### Main algorithm
- The main class parses args, and if they exist
    - If the first argument is "parse"
        - It opens the following argument as a file
        - ParseInputFileRepo loads the file and the readAll method of that class will take the file contents and place them into a List of Customer Tickets
        - Each CustomerTicket is handled via a transaction with the Cashier class
        - The List is passed to an Order repository to insert all orders to a sql database
        - OrderRepository queries the database for all orders
        - The returned List of Orders is placed into an order history class which holds a list of Customer Tickets
        - The List of Customer Tickets in the order history class is written to a history text file and is also printed to the console
    - Else it parses the args as a single Order
        - The Order will be placed into a Customer Ticket
        - Each CustomerTicket is handled via a transaction with the Cashier class
        - The CustomerTicket is passed to an Order repository to insert to a sql database
        - OrderRepository queries the database for all orders
        - The returned List of Orders is placed into an order history class which holds a list of Customer Tickets
        - The List of Customer Tickets in the order history class is written to a history text file and is also printed to the console
- Else a usage guide is printed to the console