package arrays.twopointers;

import java.util.Arrays;

/*
    Two Sum II - Input Array Is SortedGiven a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice.
    Your solution must use only constant extra space.

    Example 1:
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

    Example 2:
    Input: numbers = [2,3,4], target = 6
    Output: [1,3]
    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

    Example 3:
    Input: numbers = [-1,0], target = -1
    Output: [1,2]
    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

    Constraints:
    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
 */
public class SumUpTarget {

    public static int[] sumUp(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{++left, ++right};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // sumUp example
        int[] input = {2, 3, 5, 6};
        int target = 3;
        int[] output = sumUp(input, target);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println();

        input = new int[]{2, 7, 11, 15};
        target = 8;
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Target: " + target);
        output = sumUp(input, target);
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println();

        target = 9;
        output = sumUp(input, target);
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println();

        target = 10;
        output = sumUp(input, target);
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));

        target = 11;
        output = sumUp(input, target);
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println();

        target = 12;
        output = sumUp(input, target);
        System.out.println("Target: " + target);
        System.out.println("Output: " + Arrays.toString(output));
        System.out.println();
    }
}
