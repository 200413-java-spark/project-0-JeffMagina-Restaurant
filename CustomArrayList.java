import java.util.ArrayList;
import java.text.NumberFormat;

public class CustomArrayList {
    public class Food{
        String name;
        double cost;
    
        Food(String name, double cost){
            this.name = name;
            this.cost = cost;
        }  
    }
    public void addMenuItem(String name, double cost){
        
        ArrayList<Food> menu = new ArrayList<>();

            menu.add(new Food(name,cost));

       printMenuItems(menu);
    }

    public void printMenuItems(ArrayList<Food> menu){
        NumberFormat format = NumberFormat.getCurrencyInstance();
        for (int i = 0; i < menu.size(); i++){
            Food food = menu.get(i);

            System.out.println(food.name + " " + format.format(food.cost));
        }
    }
}