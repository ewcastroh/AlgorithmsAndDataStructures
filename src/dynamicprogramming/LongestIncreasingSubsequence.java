package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLongestIncreasingSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dynamicProgrammingTable = new int[nums.length];
        dynamicProgrammingTable[0] = 1;
        int answer = 1;
        for (int i = 0; i < dynamicProgrammingTable.length - 1; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(answer, dynamicProgrammingTable[j]);
                }
            }
            dynamicProgrammingTable[i] = max + 1;
            answer = Math.max(answer, dynamicProgrammingTable[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Array: ");
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("Longest Increasing Subsequence: " + lengthOfLongestIncreasingSubsequence(nums));
    }
}
