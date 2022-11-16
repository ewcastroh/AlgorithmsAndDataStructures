package stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 Given an encoded string, return its decoded string.
 The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 Note that k is guaranteed to be a positive integer.
 You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

 Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/
public class DecodeString {

    public static String decodeString(String input) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                int number = ch - '0';
                while (i < number + i && Character.isDigit(input.charAt(i + 1))) {
                    number = number * 10 + input.charAt(i + 1) - '0';
                    i++;
                }
                numberStack.push(number);
            } else if (ch == '[') {
                stringStack.push(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            } else if (ch == ']') {
                int repeat = numberStack.pop();
                StringBuilder tempStringBuilder = new StringBuilder(stringStack.pop());
                for (int j = 0; j < repeat; j++) {
                    tempStringBuilder.append(stringBuilder);
                }
                stringBuilder = tempStringBuilder;
            }
            else {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        List<String> testStrings = Arrays.asList( "100[leetcode]", "3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef");
        for (String input : testStrings) {
            System.out.println("String: " + input);
            System.out.println("Decoded string: " + decodeString(input));
        }
    }
}
