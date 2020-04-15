

public class CustomArrayList {

    //size of list
    private int CustomArrayListSize = 0;
    
    //storage for all elements in collection
    private Food storage[];

    //Constructor for CustomArrayList
    public CustomArrayList(int menuSize) {
        storage = new Food[menuSize];
    }

    //Add method
    public void addMenuItem(String name, double cost){
        Food menuItem = new Food(name,cost);
        storage[CustomArrayListSize] = menuItem;
        CustomArrayListSize++;
    }
    
    //Get method
    public Food get(int i){
        if (i >= CustomArrayListSize || i < 0){
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        } return storage[i];
    }

    //Return length
    public int size(){
        return CustomArrayListSize;
    }

    //Print out CustomArrayList
    public void printMenu(CustomArrayList menu){
        for(int i = 0; i< menu.size(); i++){
            System.out.println(menu.get(i).name + " " + menu.get(i).cost);
        } 
    }
}