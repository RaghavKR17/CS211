public class CP13Burger211Test {
    public static void main(String args[]) {
        CP13Burger211 price = new CP13Burger211(); // Using a single instance
        
        // Testing String price
        price.setPriceString("two dollars");
        System.out.println(price.getPriceString());
        
        // Testing int price
        price.setPriceInt(2);
        System.out.println(price.getPriceInt());
        
        // Testing double price
        price.setPriceDouble(2.5);
        System.out.println(price.getPriceDouble());     
    } 
}