import java.util.ArrayList;

class Takeout{
    public static void main(String[] args)
    {
        //Print out Menu
        System.out.println("Menu Items:");
        //Add menu items Posibly move out of main
        CustomArrayList menu = new CustomArrayList();
        menu.addMenuItem("chicken", 9.50);
        menu.addMenuItem("steak", 10.50);
        menu.addMenuItem("fish", 8.50);
        menu.addMenuItem("vegetarian", 6.00);
        menu.addMenuItem("fries", 3.00);

        
        

        //Place order, delimit order with commas?
        System.out.println("Please place your order");
        String order = System.console().readLine();
        System.out.println("you ordered" + order);

        //enter total amount to pay 
        //maybe tell customer cost before asking
        System.out.println("Please enter amount of payment");
        String amount = System.console().readLine();
        System.out.println(amount);     

        System.out.println("you have" + amount);
        System.out.println("your change is" + amount);
        //order.close();
        //amount.close();
    }
}