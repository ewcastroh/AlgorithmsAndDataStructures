package dynamicprogramming;

import java.util.Arrays;

/*
    Longest Common Subsequence
    Given two strings text1 and text1, return the length of their longest common subsequence.

    A subsequence of a string is a new string generated from the original string with some characters(can be none)
    deleted without changing the relative order of the remaining characters.

    A common subsequence of two strings is a subsequence that is common to both strings.

    The input strings consist of lower English characters only.

    *** If there is no common subsequence, return 0.

    Example:
    text1 = "abcde"
    text2 = "abc"
    Output: 3

    text1 = "acdghf"
    text2 = "aedfh"
    Output: 3

    text1 = "abcdef"
    text2 = "acbefd"
    Output: 4

 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
        char[] string1 = text1.toCharArray();
        char[] string2 = text2.toCharArray();
        int[][] dynamicTable = new int[string1.length + 1][string2.length + 1];
        int answer = 0;

        for (int i = 1; i < dynamicTable.length - 1; i++) {
            for (int j = 1; j < dynamicTable[0].length - 1; j++) {
                if (string1[i - 1] == string2[j - 1]) {
                    dynamicTable[i][j] = dynamicTable[i - 1][j - 1] + 1;
                } else {
                    dynamicTable[i][j] = Math.max(dynamicTable[i - 1][j], dynamicTable[i][j - 1]);
                }
                if (dynamicTable[i][j] > answer) {
                    answer = dynamicTable[i][j];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String text1 = "abcdef";
        String text2 = "acbefd";
        System.out.println("Text1: " + text1);
        System.out.println("Text2: " + text2);
        System.out.println("Longest Common Subsequence: " + longestCommonSubsequence(text1, text2));
    }
}
