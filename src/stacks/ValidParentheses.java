package stacks;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 Given a string containing a just the characters '(', ')', '{', '}', '[', ']'.
 Determine if the input string is valid.
 An input string is valid if:
 - Open brackets must be closed by the same type of brackets.
 - Open brackets must be closed in the correct order.

 Example:
 Input: "()"
 Output: true

 Input: (){}[]
 Output: true

 Input: ([)]
 Output: false
 */
public class ValidParentheses {

    public static final String OPEN_CURVED_BRACKETS = "(";
    public static final String CLOSE_CURVED_BRACKETS = ")";
    public static final String OPEN_SQUARE_BRACKETS = "[";
    public static final String CLOSE_SQUARE_BRACKETS = "]";
    public static final String OPEN_CURLY_BRACKETS = "{";
    public static final String CLOSE_CURLY_BRACKETS = "}";

    public static final Map<String, String> parenthesesMapping = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry(OPEN_CURVED_BRACKETS, CLOSE_CURVED_BRACKETS),
            new AbstractMap.SimpleImmutableEntry(OPEN_SQUARE_BRACKETS, CLOSE_SQUARE_BRACKETS),
            new AbstractMap.SimpleImmutableEntry(OPEN_CURLY_BRACKETS, CLOSE_CURLY_BRACKETS)
    );

    /*public static boolean isBalancedParentheses(String input) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length() - 1; i++) {
            if (parenthesesMapping.containsKey(input.charAt(i))) {
                String pop = stack.pop();
                if (pop != parenthesesMapping.get(input.charAt(i))) {
                    return false;
                }
            } else {
                stack.push(String.valueOf(input.charAt(i)));
            }
        }
        return stack.isEmpty();
    }*/
    public static boolean isBalancedParentheses(String input) {
        Stack<String> stack = new Stack<>();
        if (input.isEmpty()) {
            return false;
        }
        if (input.length() % 2 != 0) {
            return false;
        }
        stack.push(String.valueOf(input.charAt(0)));
        for (int i = 1; i <= input.length() - 1; i++) {
            if (String.valueOf(input.charAt(i)).equals(CLOSE_CURVED_BRACKETS)) {
                if (stack.peek().equals(OPEN_CURVED_BRACKETS)) {
                    stack.pop();
                    continue;
                } else {
                    stack.push(String.valueOf(input.charAt(i)));
                }
            }
            if (String.valueOf(input.charAt(i)).equals(CLOSE_SQUARE_BRACKETS)) {
                if (stack.peek().equals(OPEN_SQUARE_BRACKETS)) {
                    stack.pop();
                    continue;
                } else {
                    stack.push(String.valueOf(input.charAt(i)));
                }
            }
            if (String.valueOf(input.charAt(i)).equals(CLOSE_CURLY_BRACKETS)) {
                if (stack.peek().equals(OPEN_CURLY_BRACKETS)) {
                    stack.pop();
                    continue;
                } else {
                    stack.push(String.valueOf(input.charAt(i)));
                }
            }
            stack.push(String.valueOf(input.charAt(i)));
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        List<String> testStrings = Arrays.asList("()", "()[]{}", "[()]{}", "[({})]{}", "()[}]", "{()[}]");
        for (String input : testStrings) {
            System.out.println("String: " + input);
            System.out.println("Is balanced parentheses?: " + isBalancedParentheses(input));
        }
    }
}
