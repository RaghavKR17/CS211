import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FastFoodMembershipApp {

    static HashMap<String, CustomerInfo> customerList = new HashMap<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        select();
    }

    public static void select() {

        System.out.println("Fast Food Membership System");

        while (true) {

            try {

                System.out.println("\nChoose one: 1) Register  2) Remove Membership  3) Search  4) Display All Members  5) Quit");

                int number = input.nextInt();

                if (number == 1) {
                    register();

                } else if (number == 2) {
                    removeMembership();

                } else if (number == 3) {
                    search();

                } else if (number == 4) {
                    displayAllMembers();

                } else if (number == 5) {
                    System.out.println("Goodbye!");
                    break;
                }

                if (number <= 0 || number > 5) {
                    System.out.println("Please choose between 1 - 5");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a digit.");
                input.nextLine();
            }
        }

    }

    public static void register() {

        while (true) {

            try {

                System.out.println("\nEnter customer ID:");

                String customerID = input.next();

                // Check if the ID is already in use
                if (customerList.containsKey(customerID)) {
                    System.out.println("Customer ID is already in use");
                    continue;
                }

                // Input customer data (e.g., name, age, favorite item, etc.)
                System.out.println("Enter customer name:");
                String name = input.next();

                System.out.println("Enter customer age:");
                int age = input.nextInt();

                System.out.println("Enter customer's favorite food:");
                String favoriteFood = input.next();

                System.out.println("Enter customer's favorite drink:");
                String favoriteDrink = input.next();

                // Add data to the HashMap using constructor
                customerList.put(customerID, new CustomerInfo(customerID, name, age, favoriteFood, favoriteDrink));

                displayAllMembers();
                break;

            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter the correct data type.");
                input.nextLine();
            }
        }

    }

    public static void removeMembership() {

        while (true) {
            displayAllMembers();

            // Check if the HashMap is empty
            if (customerList.isEmpty()) {
                System.out.println("\nNo members in the list.");
                break;
            }

            // Ask for a customer ID to be removed
            System.out.println("\nEnter the customer ID to remove:");
            String customerIDToRemove = input.next();

            // Check if the customer ID is in the list and remove if any
            if (customerList.containsKey(customerIDToRemove)) {
                customerList.remove(customerIDToRemove);
                System.out.println("Membership for customer ID " + customerIDToRemove + " successfully removed.");
                break;
            } else {
                System.out.println("Can't find customer ID " + customerIDToRemove + "\n");
            }

        }
        displayAllMembers();
    }

    public static void search() {

        while (true) {

            // Check if the size of the HashMap is not empty
            if (customerList.isEmpty()) {
                System.out.println("\nNo members in the list.");
                break;
            }

            // Ask for a customer ID to search
            System.out.println("\nEnter the customer ID to search:");
            String customerIDToSearch = input.next();

            if (customerList.containsKey(customerIDToSearch)) {
                System.out.println("\nWhat do you want to know for customer ID " + customerIDToSearch + "?\n1) Name  2) Age  3) Favorite Food 4) Favorite Drink 5) All");
                int option = input.nextInt();

                CustomerInfo customer = customerList.get(customerIDToSearch);

                switch (option) {
                    case 1:
                        System.out.println("Name: " + customer.getName());
                        break;
                    case 2:
                        System.out.println("Age: " + customer.getAge());
                        break;
                    case 3:
                        System.out.println("Favorite Food: " + customer.getFavoriteFood());
                        break;
                    case 4:
                        System.out.println("Favorite Drink: " + customer.getFavoriteDrink());
                        break;
                    case 5:
                        System.out.println(customer);
                        break;
                    default:
                        System.out.println("Invalid option");
                }

            } else {
                System.out.println("\nCan't find customer ID " + customerIDToSearch);
            }

            break;
        }

    }

    public static void displayAllMembers() {
        System.out.println("\nCurrent Members (" + customerList.size() + ")");
        for (CustomerInfo customer : customerList.values()) {
            System.out.println(customer);
        }
    }

}
