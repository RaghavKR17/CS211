/*
Raghav Krishna Ranganathan
ID: 203035901
Date: 1/12/24

Program Description:
This program demonstrates error-handling techniques for user input in a menu-driven application.
Users can choose different methods to test the functionality of a NewRandom class, and the program 
includes input validation and error handling for both the menu selection and individual test cases.
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class NewRandomTest {

    public static void main(String[] args) {
        // Instantiate the NewRandom class
        NewRandom newRandom = new NewRandom();

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        int choice = 0;

        // Loop until the user chooses to exit (choice 6)
        while (choice != 6) {
            try {
                // Get user input for testing
                System.out.println("\n\nChoose the method to test:");
                System.out.println("1. nextChar()");
                System.out.println("2. nextInt(int low, int high)");
                System.out.println("3. nextChar(char from, char to)");
                System.out.println("4. nextChar(char from, int i)");
                System.out.println("5. nextSpecialChar");
                System.out.println("6. Exit");
                System.out.print("\nEnter your choice (1-6): ");

                // Check if the input is an integer
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    // Check if the input is within the valid range
                    if (choice >= 1 && choice <= 6) {
                        // Continue with the switch statement based on the valid choice
                        switch (choice) {
                            case 1:
                                // Test the nextChar() method
                                System.out.println("\nTesting nextChar():");
                                for (int i = 0; i < 30; i++) {
                                    System.out.print(newRandom.nextChar() + " ");
                                }
                                System.out.println("");
                                break;

                            case 2:
                                // Test the nextInt() method
                                System.out.println("\nTesting nextInt():");
                                try {
                                    System.out.print("Enter the lower bound: ");
                                    int low = scanner.nextInt();
                                    System.out.print("Enter the upper bound: ");
                                    int high = scanner.nextInt();
                                    for (int i = 0; i < 30; i++) {
                                        System.out.print(newRandom.nextInt(low, high) + " ");
                                    }
                                    System.out.println("");
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter valid integers for lower and upper bounds.");
                                    scanner.nextLine(); // Consume the invalid input
                                    continue; // Repeat the loop
                                }
                                break;

                            case 3:
                                // Test the nextChar(char from, char to) method
                                System.out.println("\nEnter values for testing nextChar(char from, char to):");
                                try {
                                    System.out.print("From character: ");
                                    char from = scanner.next().charAt(0);
                                    System.out.print("To character: ");
                                    char to = scanner.next().charAt(0);
                                    System.out.println("\nTesting nextChar(" + from + ", " + to + "):");
                                    for (int i = 0; i < 30; i++) {
                                        System.out.print(newRandom.nextChar(from, to) + " ");
                                    }
                                    System.out.println("");
                                } catch (StringIndexOutOfBoundsException e) {
                                    System.out.println("Invalid input. Please enter valid characters for 'from' and 'to'.");
                                    scanner.nextLine(); // Consume the invalid input
                                    continue; // Repeat the loop
                                }
                                break;

                            case 4:
                                // Test the nextChar(char from, int i) method
                                System.out.println("\nEnter values for testing nextChar(char from, int i):");
                                try {
                                    System.out.print("From character: ");
                                    char fromChar = scanner.next().charAt(0);
                                    System.out.print("Offset (int i): ");
                                    int offset = scanner.nextInt();
                                    System.out.println("\nTesting nextChar(" + fromChar + ", " + offset + "):");
                                    for (int i = 0; i < 30; i++) {
                                        System.out.print(newRandom.nextChar(fromChar, offset) + " ");
                                    }
                                    System.out.println("");
                                } catch (StringIndexOutOfBoundsException | InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter valid character and integer for 'from' and 'offset'.");
                                    scanner.nextLine(); // Consume the invalid input
                                    continue; // Repeat the loop
                                }
                                break;

                            case 5:
                                // Test the nextSpecialChar() method
                                System.out.println("\n\nTesting nextSpecialChar():");
                                for (int i = 0; i < 30; i++) {
                                    System.out.print(newRandom.nextSpecialChar() + " ");
                                }
                                System.out.println("");
                                break;

                            case 6:
                                System.out.println("Exiting...");
                                break;
                        }
                    } else {
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    }
                } else {
                    // Consume the invalid input to avoid an infinite loop
                    scanner.next();
                    System.out.println("Invalid input. Please enter a valid integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Close the Scanner
        scanner.close();
    }
}