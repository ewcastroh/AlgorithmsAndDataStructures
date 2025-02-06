package arrays.twopointers;

/*
    Find First Palindromic String In Array
    Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
    A string is palindromic if it reads the same forward and backward.

    Example 1:
    Input: words = ["abc","car","ada","racecar","cool"]
    Output: "ada"
    Explanation: The first string that is palindromic is "ada".
    Note that "racecar" is also palindromic, but it is not the first.

    Example 2:
    Input: words = ["notapalindrome","racecar"]
    Output: "racecar"
    Explanation: The first and only string that is palindromic is "racecar".

    Example 3:
    Input: words = ["def","ghi"]
    Output: ""
    Explanation: There are no palindromic strings, so the empty string is returned.

    Constraints:
    1 <= words.length <= 100
    1 <= words[i].length <= 100
    words[i] consists only of lowercase English letters.
 */
public class FindFirstPalindromicStringInArray {

    public static String firstPalindrome(String[] words) {
        for (String word: words) {
            if (isPalindromic(word)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isPalindromic(String word) {
        int start = 0;
        int end = word.length() - 1;
        while (start <= end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        // 5 test cases for firstPalindrome method
        String[] case1 = new String[]{"abc","car","ada","racecar","cool"};
        System.out.println("First palindrome for case 1 is: " + firstPalindrome(case1));

        String[] case2 = new String[]{"notapalindrome","racecar"};
        System.out.println("First palindrome for case 2 is: " + firstPalindrome(case2));

        String[] case3 = new String[]{"def","ghi"};
        System.out.println("First palindrome for case 3 is: " + firstPalindrome(case3));
    }
}
