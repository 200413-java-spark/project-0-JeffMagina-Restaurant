# Version 1.0.5
## Added
* storeorder() and displayAllOrders in orderhistory.java
* added two test cases for Format.java:
**SplitTokensTest
**FirstLetterToUpperCaseTest
*Added a script to connect to aws server

## Changed
* Format.java to have a firstLettertoUppercase method and a wholeArrayListFirstLetterToUpperCase rather than having them both in one
* changed IO.jvaa to reflect above change


# Version 1.0.4
## Added
* implemented a format class to format strings from file
* added a store order for future storage to a database

## Changed
* reformatted j unit test
* took file parsing of orderForm out of cashier class

# Version 1.0.3
## Added
* add dependency in pom.xml for Junit 
* Test case for CalcCost()

## Changed
* changed variable names in CustomerOrder.java in constructor to make more sense
* changed cashier Constructor from asking for a name to a default constructor and gave the Cashier a permanent name;
* changed main cashier constructor to reflect change above

# Version 1.0.2
## Changed
* Update IO.java to handle exceptions
* Updated Menu.java to create menu in the constructor
* Cleaned up Main.java to be a bootstrap or start up for project
* Made an interaction method for Cashier that calls:
** greeting()
** takeOrder()
** transaction()
** storeOrder()
* Moved OrderForm.txt out of Resources folder and into main folder for ease of use

# Version 1.0.1
## Added
* history.txt file for history of orders

# Changed
* pom.xml to have Intellisense scheme
* CustomerOrder.java to have a Overrided toString method
* Read ResourceFile changed to IO.java and added ability to read and write to history.txt
* Updated .gitignore
* Main.java now writes to a history.txt
* Update ReadMe.md

# Deleted
* Customer.java not needed at the moment

# Version 1.0.0
## Added
* Added resource folder to maven project that holds read in file
* Added read from file functionality
* Add all files into a restaurant directory
* Main.java file
* CustomerOrder.java
* parsefile function added in main class to parse file that is read in into useable arguments
* OrderHistory (Empty)

## Changed
* Modify all class to be more object oriented
* clean takeout.java move to main.java and make main simpler
* Order.java changed to customer order and populated with 5 variables
* consolidated methods in cashier class
* Updated .gitignore

## Removed
* takeout.java
* CustomArrayList

# Version 0.1.4
## Added
* In Cashier.java
    - deliverOrder()
    - explainCost()
    - promptPayment()
    - giveChange -> deliverChange()
    - options()
    - isReadyToOrder(String)
    - confirmOrder(ArrayList)


# Version 0.1.3
## Added
* Maven Project
* pom.xml
* Order.java (blank for now)
* Cashier.java

## Changed
* all files to be placed into package
* all files to be organized better via src/main/java file directory framework
    * Following methods moved from main to Cashier methods
        - takeOrder()
        - calcCost()
        - giveChange()
        - greeting()
        - personalGreeting()      
* changed food variables to public -> will eventually changed to private with a get function

# Version 0.1.2
## Added
* Food.java
* Create Storage Function to parse user input
* Create Cost of order Function

## Changed

* Store Menu from Restaurant in a Custom Array List
* Polish CustomArrayList class to have the following:
    * addMenuItem(name,cost)
    * get(index i)
    * size()
    * printMenu()

# Version 0.1.1
## Added
* Rollback Takeout.java via new branch to a more simplistic form to break project into pieces
* Changelog.md
* build.sh
* .gitignore

# Version 0.0.2
## Added
* Added to Readme.md
* Takeout.java main file
* CustomArrayList Class Created to store Menu

# Version 0.0.1
## Added
* Readme.md

