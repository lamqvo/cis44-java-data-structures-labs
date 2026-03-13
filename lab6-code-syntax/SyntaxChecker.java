// You will need a functioning Stack implementation (like ArrayStack) for this to work.
// interface Stack { ... }
// class ArrayStack implements Stack { ... }

import java.util.Arrays;
import java.util.EmptyStackException;

public class SyntaxChecker {

    /**
     * Uses a stack to check if a line of code has balanced symbols.
     * @param line The string of code to check.
     * @return true if symbols are balanced, false otherwise.
     */
    public static boolean isBalanced(String line) {
        // Create a LinkedStack buffer
        Stack<Character> buffer = new LinkedStack<>(line.length());
        // loop through the line to find symbols
        for (int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            // if char matches the symbols: '(' or '{' or '[' then push to stack
            if (c == '(' || c == '{' || c == '['){
                try {
                    buffer.push(c);
//                    System.out.println("--> pushed: " + buffer.top() + "\n");
                } catch (IllegalArgumentException e){
                    System.err.println("CAUGHT ERROR: " + e.getMessage());
                }
            }
            // if char matches the symbols: ')' or '}' or '}' then check if it is matching the top of the stack, then pop
            else if (c == ')' || c == '}' || c == ']'){
                if (buffer.isEmpty()) {
//                    System.out.println("Need to pop opening of: " +c + " but buffer is empty");
                    return false;
                } else {
                    try {
                        char top = buffer.pop();
//                        System.out.println("-->char = " + c);
                        if ((top == '(' && c != ')') ||  (top == '{' && c != '}') || (top == '[' && c != ']')) {
                            return false;
                        }
//                        System.out.println("Popped: " + top + "\n");
                    } catch (EmptyStackException e){
                        System.err.println("CAUGHT ERROR: Cannot pop from an empty stack");
                    }
                }
            }
        }
        return buffer.isEmpty();
    }

    public static void main(String[] args) {
        String line1 = "public static void main(String[] args) { ... }"; // Should be true
        String line2 = "int x = (5 + [a * 2]);"; // Should be true
        String line3 = "System.out.println('Hello');)"; // Should be false (extra closing parenthesis)
        String line4 = "List list = new ArrayList<{String>();"; // Should be false (mismatched)
        String line5 = "if (x > 0) {"; // Should be false (unmatched opening brace)

        System.out.println("Line 1 is balanced: " + isBalanced(line1));
        System.out.println("Line 2 is balanced: " + isBalanced(line2));
        System.out.println("Line 3 is balanced: " + isBalanced(line3));
        System.out.println("Line 4 is balanced: " + isBalanced(line4));
        System.out.println("Line 5 is balanced: " + isBalanced(line5));
    }
}
