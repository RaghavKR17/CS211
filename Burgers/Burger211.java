import java.util.HashMap;

// Abstract class representing a collection of burgers
public abstract class Burger211 {
    
    // HashMap to store burger information with burger number as key
    static HashMap<Integer, BurgerInfo> burger = new HashMap<>();

    // Constructor to initialize Burger211 object and populate the burger HashMap
    Burger211() {   
        burger.put(1, new BurgerInfo("1. Inheritance Burger: ", 4.5, "beef patty, tomato, onion, black olive, ranch sauce")); 
        burger.put(2, new BurgerInfo("2. @Override Burger: ", 5.5, "beef patty, lime, onion, lettuce, tomato sauce"));
        burger.put(3, new BurgerInfo("3. Polymorphism Burger: ", 6.5, "chicken breast, gallo, onion, ranch sauce"));	 		 
    }	  
        
    // Abstract method to print the menu
    abstract void printMenu();    

    // Getter method to retrieve the number of burgers
    public int getHowManyBurgers() {
        return burger.size();
    }

    // Getter method to retrieve the name of a burger by key
    public String getName(int key) {
        return burger.get(key).getName();
    }

    // Getter method to retrieve the price of a burger by key
    public double getPrice(int key) {
        return burger.get(key).getPrice();
    }

    // Getter method to retrieve the toppings of a burger by key
    public String getTopping(int key) {
        return burger.get(key).getTopping();
    }

    // Method to update the toppings of a burger by key
    public void getNewTopping(int key, String newTopping) {
        if (burger.containsKey(key)) {
            BurgerInfo toppings = burger.get(key);
            toppings.getNewTopping(newTopping);
        }
    }

    // Method to retrieve the burger HashMap
    public static HashMap<Integer, BurgerInfo> getBurgerMap() {
        return burger;
    }
}
