/*
Raghav Krishna Ranganathan
Student ID: 203035901
02/09/2024
This program is designed to create a graphical representation of a menu for a franchise.
It allows employees to manage the menu from the terminal, enabling them to edit promotions, discounts,
toppings, and more for a set of three burgers. The program utilizes APIs to retrieve weather/temperature
data from an inputted city/country and exchange rates for converting currency based on the country.
 */
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

// Class representing the menu of my franchise
public class Menu extends Burger211 {
    private String country;
    private String franchise;
    private double discountRate;
    private String promotion;
    private String currencyCode;
    private String currencySymbol;
    private static double exchangeRate;
    private static double temperature;
    static final int HOT_TEMPERATURE = 50;

    // Constructor to initialize Menu object with country and franchise
    Menu(String country, String franchise) {
        // Set currency code and symbol based on the country
        Locale locale = new Locale.Builder().setRegion(country).build();
        currencyCode = Currency.getInstance(locale).getCurrencyCode();
        currencySymbol = Currency.getInstance(locale).getSymbol();
        this.country = country;
        this.franchise = franchise;

        // Initialize exchange rate and temperature
        try {
            exchangeRate = ExchangeRate.getRate(currencyCode);
            temperature = ProjectWeather211.CityWeather(franchise, country);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to apply promotion discount
    public void applyPromotion(Double discount, String promotionMessage) {
        // Combine promotion discounts if already applied
        if (this.discountRate == 0) {
            this.discountRate = discount;
        } else {
            this.discountRate = (1 - (1 - this.discountRate) * (1 - discount));
        }
        
        // Combine promotion messages
        if (this.promotion == null || this.promotion.isEmpty()) {
            this.promotion = promotionMessage;
        } else {
            this.promotion += " | " + promotionMessage;
        }
    }

    // Method to apply hot weather discount
    public void applyHotWeatherDiscount(int highTemp) {
        // Apply discount if temperature is high enough
        if (temperature >= HOT_TEMPERATURE) {
            double hotDiscount = 0.1; // 10% discount for hot weather
            applyPromotion(hotDiscount, "Hot Weather Discount: 10% off!");

            // Apply the promotion discount to all burgers
            for (int i = 1; i <= getHowManyBurgers(); i++) {
                double originalPrice = getPrice(i);
                double discountedPrice = originalPrice * (1.0 - hotDiscount);
            }

            System.out.println("Promotion applied: Hot Weather Discount - 10% off!");
        } else {
            System.out.println("Promotion not applied: Temperature is comfortable");
        }
    }

    // Method to print the menu
    @Override
    public void printMenu() {
        DecimalFormat df = new DecimalFormat("#,###,###.0");

        // Calculate the price of each burger after applying discounts
        String[] localPrice = new String[getHowManyBurgers()];
        for (int i = 0; i < getHowManyBurgers(); i++) {
            localPrice[i] = df.format(getPrice(i + 1) * (1.0 - discountRate));
            if (discountRate > 0.0) {
                localPrice[i] += " (Regular:" + df.format(getPrice(i + 1)) + ")";
            }
        }

        // Display promotion message and prices with currency symbol
        String promoMessage = promotion + " | Extra 10% discount on all burgers every hot weather day!";
        new MenuGUI(franchise, promoMessage, getName(1), currencySymbol + localPrice[0], getTopping(1), getName(2),
                currencySymbol + localPrice[1], getTopping(2), getName(3), currencySymbol + localPrice[2],
                getTopping(3), exchangeRate, temperature);
    }

    // Method to get the price of a burger
    @Override
    public double getPrice(int key) {
        double originalPrice = super.getPrice(key);
        double convertedPrice = originalPrice * exchangeRate;
        return convertedPrice;
    }

    // Method to get the topping of a burger
    @Override
    public String getTopping(int key) {
        return super.getTopping(key);
    }

    // Method to change the topping of a burger
    public String changeTopping(int key, String newTopping) {
        return newTopping; // Return the updated topping
    }
}
