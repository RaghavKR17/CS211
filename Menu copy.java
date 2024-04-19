package burger_assgn;

/* Name: Sumana Yeluripati
 * Student ID: 202895163
 * Project #2
 * Date: 2/9/2024
 * This is the class that extends the subclass Burger211, and uses its abstract class(es) and getter methods.
 * This class uses the concepts of overriding to define variables to be used in MyFranchise class.
 */

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;

public class Menu extends Burger211{
	String country;
	String franchise;
	double discountRate;
	String promotion;
	String currencyCode;
	String currencySymbol;
	int updatedBurgerKey;
	String updatedTopping;
	static final int Temp = 50;
	
	static double exchangeRate;
	static double temperature;
  	  
	  Menu(String country, String franchise){ 
		    
		  Locale locale = new Locale.Builder().setRegion(country).build();
		  
		  currencyCode = Currency.getInstance(locale).getCurrencyCode();
		  currencySymbol = Currency.getInstance(locale).getSymbol();
		  		  	  
		   this.country=country;
		   this.franchise=franchise;
	      
	       try {
	    	   //reads the exchange rate
	    	   exchangeRate = ExchangeRate.getRate(currencyCode);
	       } catch (Exception e) {
	            e.printStackTrace();
	       }	          
	        
	       try {
	    	   //reads the weather
	    	   temperature = Weather211.CityWeather(franchise);
	       } catch (Exception e) {
	           e.printStackTrace();
	       }	
	  }
	  
	 //returns the discounted price if any promotion code is applied
	  public void Promotion(Double discount, String promote){
		  this.discountRate = discount;
		  this.promotion = promote;
		  
	   }
	  
	  //returns weather discount of 10% on all burgers on hot days.
	  public void PromotionTooHot(int highTemp){ 
		    if (temperature >= Temp) {
		        double hotDiscount = 0.1; // 10% discount for hot weather
		        Promotion(hotDiscount, "Too Hot Discount"); // Apply the promotion discount
		        
		        for (int i = 1; i <= getHowManyBurgers(); i++) {
		            double originalPrice = getPrice(i); // Get original price
		            double discountedPrice = originalPrice * (1.0 - hotDiscount); // Apply discount
		        }
		        
		        System.out.println("Promotion applied: Too Hot Discount");
		    } else {
		        System.out.println("Promotion not applied: Condition not met");
		    }
	  }  
	   
	  @Override
	   public void printMenu(){
		  	 		  
		  DecimalFormat df = new DecimalFormat("#,###,###.0");
		  
		  //calculates the price on check after applying discount(s).
		  String[] localPrice = new String[getHowManyBurgers()];
		  for (int i=0; i< getHowManyBurgers(); i++) {
				  localPrice[i]= df.format(getPrice(i+1)*(1.0-discountRate));
				  
				  if (discountRate>0.0) {
					  localPrice[i] +=" (regular:" + df.format(getPrice(i+1))+")";
				  }	 
			 }
			 
	
	     String pro = promotion + " | Extra 10% discount on all burgers every hot weather day!";
	     // call API
	     //System.out.println(getTopping(1) + "debugging");
	     new MenuGUI(franchise,pro,getName(1), currencySymbol+localPrice[0], getTopping(1),getName(2),currencySymbol+localPrice[1], getTopping(2),getName(3),currencySymbol+localPrice[2], getTopping(3), exchangeRate, temperature);
	
	  }
	 
	
	  //calculate the price of burgers using exchange rate to convert to local currency
	  @Override
	  public double getPrice(int key) {
		  double ogPrice = super.getPrice(key);
		  double reg = ogPrice*exchangeRate;
		  //double discountPrice = reg + (1.0 - discountRate/100);
		  return reg;
	  }
	
	//return the original toppings on the menu
	  @Override
		public String getTopping(int key) {		
		  return super.getTopping(key);
		}
	  
	  //return the user inputted/changed toppings
	  public String NewTopping(int key, String topping) {		
			return updatedTopping = topping;
		}
}
