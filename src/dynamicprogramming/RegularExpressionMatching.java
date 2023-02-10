package dynamicprogramming;

import java.util.Arrays;

/*
 Given an input string(s) and a pattern(p). Implement regular expression matching with support "." and "*".
 "." matches any single character
 "*" matches zero or more of the preceding character

 | Pattern  |           String              |
 | 'a'      | 'a'                           |
 | 'a.b'    | 'acb', 'abb', 'axb'           |
 | 'a*b'    | 'b', 'ab', 'aab', 'aaaab'     |
 | '.*'     | 'ab', 'ba', 'bbddcc'          |
 | 'c*a*b'  | 'cb', 'b', 'cab', 'ccaab'     |
 | 'a*b.*y' | 'by', 'aby', 'aaby'           |
 */
public class RegularExpressionMatching {

    public static boolean isMatch(String string, String pattern) {
        boolean[][] dynamicTable = new boolean[string.length() + 1][pattern.length() + 1];
        dynamicTable[0][0] = true;
        for (int i = 0; i < dynamicTable.length - 1; i++) {
            if (pattern.indexOf(i-1) == '*') {
                dynamicTable[0][i] = dynamicTable[0][i - 2];
            }
        }
        for (int i = 1; i < dynamicTable.length - 1; i++) {
            for (int j = 1; j < dynamicTable.length - 1; j++) {
                if (pattern.indexOf(j - 1) == '.' || pattern.indexOf(j - 1) == string.indexOf(i - 1)) {
                    dynamicTable[i][j] = dynamicTable[i - 1][j - 1];
                } else if (pattern.indexOf(j - 1) == '*') {
                    dynamicTable[i][j] = dynamicTable[i][j - 2];
                    if (pattern.indexOf(j - 2) == '.' || pattern.indexOf(j - 2) == string.indexOf(i - 1)) {
                        dynamicTable[i][j] = dynamicTable[i][j] || dynamicTable[i - 1][j];
                    }
                } else {
                    dynamicTable[i][j] = false;
                }
            }
        }
        return dynamicTable[string.length()][pattern.length()];
    }

    public static void main(String[] args) {
        String s = "axyb";
        String pattern = "a.*b";
        System.out.println("String: " + s);
        System.out.println("Pattern: " + pattern);
        System.out.println("Regular Expression Matching: " + isMatch(s, pattern));

    }
}
