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

