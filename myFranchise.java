// Import necessary Java utilities
import java.util.ArrayList;
import java.util.Scanner;

// Main class for managing a franchise menu
public class myFranchise {
    
    // ANSI color codes for console output formatting
    public static final String ANSI_RESET = "\u001B[0m";   
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String SET_BOLD_TEXT = "\033[0;1m";
    
    // Main method for managing franchise operations
    public static void main(String[] args) throws Exception {

        // Declare variables for user inputs and menu operations
        String countryCode;
        String franchiseName;
        int promotionDiscount;
        String promotionMessage = "";
        int hotTemperature;
        int burgerNumber;
        String newTopping;
        
        // Scanner object for user input
        Scanner input = new Scanner(System.in);	
        
        // Print header with bold red text
        System.out.println(SET_BOLD_TEXT + ANSI_RED + "\nProject 2. Burger 211 (Winter 2024)" + ANSI_RESET);		
        boolean isRunning = true;
        while (isRunning) {
            // Prompt user for country code
            System.out.println(ANSI_GREEN +"\nEnter country code (Alpha-2 code): " + ANSI_RED);
            countryCode = input.next();
            
            // Check if user wants to exit
            if (countryCode.equals("0")) {
                isRunning = false;
                System.out.println("Bye!");
                break;
            }
            else {
                input.nextLine(); // Consume newline character
                
                // Prompt user for franchise name
                System.out.println(ANSI_GREEN +"\nEnter your franchise name: " + ANSI_RED);	
                franchiseName = input.nextLine();
                    
                // Create new Menu object for the franchise
                Menu franchise = new Menu(countryCode, franchiseName);			
                
                // Prompt user for promotion details
                System.out.println(ANSI_GREEN +"\nEnter the promotion. If there is no promotion, press enter: " + ANSI_RED);
                promotionMessage = input.nextLine();
                
                // Apply promotion if it exists
                if (!promotionMessage.isEmpty()) {
                    System.out.println(ANSI_GREEN +"\nEnter the promotion discount rate (%) (0 ~ 99): " + ANSI_RED);
                    promotionDiscount = input.nextInt();
                    input.nextLine(); // Consume newline character
                    franchise.applyPromotion((double)promotionDiscount / 100.0, promotionMessage);
                }
                
                // Prompt user for hot weather discount
                System.out.println(ANSI_GREEN +"\nEnter temperature for \"too hot to eat 10% off\" promotion: " + ANSI_RED);
                hotTemperature = input.nextInt();
                input.nextLine(); // Consume newline character
                franchise.applyHotWeatherDiscount(hotTemperature);
                
                // Prompt user to change toppings
                System.out.println(ANSI_GREEN + "\nWhich burger's toppings do you want to change? (Enter burger number, or enter 0 to skip): " + ANSI_RED);
                ArrayList<BurgerInfo> burgers = new ArrayList<>(Menu.getBurgerMap().values());
                for (int i = 0; i < burgers.size(); i++) {
                    BurgerInfo burger = burgers.get(i);
                    System.out.println(burger.getName() + burger.getTopping());
                }
                String burgerNumberInput = input.nextLine().trim();
                if (!burgerNumberInput.equals("0")) {
                    burgerNumber = Integer.parseInt(burgerNumberInput);
                    System.out.println("Enter new toppings for burger " + burgerNumber + ": ");
                    newTopping = input.nextLine().trim();
                    franchise.getNewTopping(burgerNumber, newTopping);
                } else {
                    // Skip changing burger toppings
                    System.out.println("Skipping changing burger toppings.");
                }
                // Print the updated menu
                franchise.printMenu();		     				   
            }
        }
        input.close();
    }   
}
