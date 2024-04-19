/*
Raghav Krishna Ranganathan
ID#: 203035901
02/20/2024

The program accepts mathematical expressions from users, processes them to evaluate the result, and provides feedback on the validity of the input.
It supports basic arithmetic operations like addition, subtraction, multiplication, and division. 
If the expression is invalid, the program alerts the user and indicates the error location.

*/
import java.util.Scanner;

public class MyExpressionTest { 
    // ANSI escape codes for color formatting
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter a math expression: " + ANSI_GREEN);
            String expression = scanner.nextLine();

            if (expression.isEmpty()) {
                System.out.println("Bye!");
                break;
            }
            
            int validationResult = ExpressionEvaluation.expressionEvaluation(expression);
            if (validationResult == -1) {
                InfixToPostfix conversion = new InfixToPostfix();
                String postfix = conversion.infixToPostfix(expression);
                System.out.println(ANSI_RESET + "infix: " + expression);
                System.out.println("postfix: " + postfix);
                
                // Evaluate the postfix expression
                try {
                    int result = (int) (PostfixEvaluation.evaluatePostfix(postfix));
                    System.out.println("result: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println(ANSI_RESET + expression);
                System.out.println(" ".repeat(validationResult) + "^" + "Incomplete Expression");
            }
        }

        scanner.close();
    }
}