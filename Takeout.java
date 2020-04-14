import java.util.StringTokenizer;
import java.util.ArrayList;

//Create classes or function for all the random print statements

class Takeout{
    public static void main(String[] args)
    {
        //Example menu
        String menu = "Chicken, 9.50\n" + "Steak, 10.50\n" + "Fish, 8.50\n" + "Vegetarian, 6.00\n" + "Fries, 3.00\n";

        //Global variable initializations
        String readyStatus, order;
        readyStatus = order = "";
        ArrayList<String> fullOrder = new ArrayList<>();
        double orderCost , customerPayment, change = 0;

        //Greet Customer and ask for name
        System.out.println("Hello valued Customer!\nWelcome to Jeff's Restaurant!");
        System.out.print("Please enter your name for the Togo Order: ");

        //Store Customer name
        String customerName = System.console().readLine();

        //Print Greeting for Customer
        System.out.println("\nHello, " + customerName +
        ", Welcome once again to Jeff's Restaurant! \n" +
        "Please take a minute to look over our menu options.\n\n" + 

        //Print out Menu
        menu +

        //Prompt user to select if they are ready
        "\nWhen you are ready, just type in \"ready\"\n" + 
        "If you would like to see menu again type in \"menu\"\n" + 
        "or if you would like to leave the restaurant type in \"exit\"");

        //Check user entry if valid option
        while(!readyStatus.equals("exit")){
            System.out.print("\nYourEntry: ");
            readyStatus = System.console().readLine().toLowerCase();

            if(readyStatus.equals("ready")){
                System.out.print("\n\n" + customerName + " is ready to order.\nPlease place your order now with spaces in between items like so.\nex. Fries Steak\n\nOrder: ");
                
                //Prompt Customer to input order
                order = System.console().readLine();
//****************************CHECK TO MAKE SURE ORDER IS VALID */
                // Store Customer Order
                fullOrder = storeOrder(order);

                //Confirm order
                System.out.println("Your order is: ");
                for(int i = 0; i <fullOrder.size(); i++){
                    System.out.println(fullOrder.get(i));
                }
                System.out.println("Is this correct:? ");
                //******************************************ADD A LOOP TO CHECK IF IT IS CORRECT */

                // Calculate Cost of Customer Order
                orderCost = calcCost(fullOrder);

                // Tell the Customer the cost of the order
                System.out.println("Your order will cost: " + orderCost);

                // Prompt Customer for amount of payment, and check to make sure it is sufficient funds
                System.out.print("Please give amount that you are going to pay: ");
                customerPayment = Double.parseDouble(System.console().readLine());
                System.out.println(customerPayment);

                // Give thank customer, give Customer order
                System.out.println("Thank you for selecting Jeff's Restaurant for your restaurant of choice");
                System.out.println("Here is you order: " + fullOrder);

                //create change and give change
                change = customerPayment - orderCost;
                System.out.println("Here is your change for your order: " + change);

                //Ask customer if they would like to place another order or exit, revert to prompt before

                System.exit(1);


            } else if (readyStatus.equals("menu")) {
                // Reprint Menu
                System.out.println(menu + "\n");
            } else if (readyStatus.equals("exit")) {
                System.exit(1);
            } else {
                // Show user error message and bring them back to options
                System.out.println("Invalid Entry!\n Please type in \"ready\", \"menu\", or \"exit\"");
            }
            System.out.println("\nWhen you are ready, just type in \"ready\"\n"
                    + "If you would like to see menu again type in \"menu\"\n"
                    + "or if you would like to leave the restaurant type in \"exit\"");
        }
    }

//Function to store order into an ArrayList
    static ArrayList<String> storeOrder(String order) {
        StringTokenizer orderToken = new StringTokenizer(order, " ");
          ArrayList<String> orderArray = new ArrayList<>();
          while(orderToken.hasMoreTokens()){ 
              orderArray.add(orderToken.nextToken()); 
            }
            return orderArray;
          
    }

//Function to calculate cost of Food Order
    static double calcCost(ArrayList<String> order){
        double cost = 0;
        
        //Find a way to calculate cost of order
        return cost;

    }
}