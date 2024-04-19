import java.util.Stack;

public class ExpressionEvaluation {
    public static int expressionEvaluation(String statement) {
        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < statement.length(); j++) {
            char c = statement.charAt(j);

            if ((c == '{') || (c == '(')) {
                stack.push(c);
            }

            if (c == ')' || c == '}') {
                if (!stack.isEmpty()) {
                    char poppedChar = stack.pop();
                    if ((c == ')' && poppedChar != '(') || (c == '}' && poppedChar != '{')) {
                        return j; // Return the position of the mismatched parenthesis
                    }
                } else {
                    return j; // Return the position of the unmatched closing parenthesis
                }
            }
        }

        if (!stack.isEmpty()) {
            return statement.length(); // Return the length of the statement for unmatched opening parenthesis
        }

        return -1; // Return -1 if the expression is valid
    }
}