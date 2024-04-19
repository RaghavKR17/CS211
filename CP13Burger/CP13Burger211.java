public class CP13Burger211 {

    private String burgerPriceString;
    private int burgerPriceInt;
    private double burgerPriceDouble;  

    // Setter method for String price
    public void setPriceString(String price){
        this.burgerPriceString = price; // Using "this"
    } 
    
    // Setter method for int price
    public void setPriceInt(int price){
        this.burgerPriceInt = price; // Using "this"
    } 

    // Setter method for double price
    public void setPriceDouble(double price){
        this.burgerPriceDouble = price; // Using "this"
    }
    
    // Getter method for String price
    public String getPriceString(){
        return this.burgerPriceString; // Using "this"
    } 

    // Getter method for int price
    public int getPriceInt(){
        return this.burgerPriceInt; // Using "this"
    } 
    
    // Getter method for double price
    public double getPriceDouble(){
        return this.burgerPriceDouble; // Using "this"
    }   
}