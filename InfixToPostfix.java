import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String infix) {
        HashMap<Character, Integer> precedence = loadPrecedence();
        Stack<Character> stack = new Stack<>(); //Initialize a new stack in order to store the characters
        String post = "";
    
        for (int j = 0; j < infix.length(); j++) {
            char c = infix.charAt(j);
            if (Character.isDigit(c)) {
                while (j < infix.length() && Character.isDigit(infix.charAt(j))) {
                    post+= infix.charAt(j);
                    j++;
                }
                j--; // Move back one position since the loop will increment j again
                post+= " "; // Add a space to separate numbers
            } else if (c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == '}') {
                while (!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '{') {
                    post+= stack.pop() + " ";
                }
                stack.pop(); // Remove the opening parenthesis
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && precedence.getOrDefault(stack.peek(), 0) >= precedence.get(c)) {
                    post+= stack.pop() + " ";
                }
                stack.push(c);
            }
        }
    
        while (!stack.isEmpty()) {
            post+= stack.pop() + " ";
        }
    
        return post;
    }    

    private static HashMap<Character, Integer> loadPrecedence() {
        HashMap<Character, Integer> precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('(', 0);
        precedence.put('{', 0);
        return precedence;
    }
}
