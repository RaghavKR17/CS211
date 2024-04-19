// Class representing information about a burger
public class BurgerInfo {

    private String name;    // Name of the burger
    private double price;   // Price of the burger
    private String topping; // Toppings of the burger

    // Constructor to initialize BurgerInfo object with name, price, and topping
    public BurgerInfo(String name, double price, String topping) {
        this.name = name;
        this.price = price;
        this.topping = topping;
    }

    // Getter method to retrieve the name of the burger
    public String getName() {
        return name;
    }

    // Getter method to retrieve the price of the burger
    public double getPrice() {
        return price;
    }

    // Getter method to retrieve the toppings of the burger
    public String getTopping() {
        return topping;
    }

    // Method to update the toppings of the burger
    public String getNewTopping(String newTopping) {
        return this.topping = newTopping;
    }

    // Method to set the price of the burger
    public void setPrice(double price) {
        this.price = price;
    }
}
