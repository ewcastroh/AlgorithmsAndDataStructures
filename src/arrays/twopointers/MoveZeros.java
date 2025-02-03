package arrays.twopointers;

import java.util.Arrays;

/*
 * Given an array nums, writea function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements. In place.
 * Input
 * [0, 1, 0, 3, 12]
 *
 * Output
 * [1, 3, 12, 0, 0]
 */
public class MoveZeros {

    public static void moveZeros(int[] nums) {
        int currentIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[currentIndex++] = nums[i];
            }
        }
        while (currentIndex < nums.length) {
            nums[currentIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Before moving: " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println("After moving: " + Arrays.toString(nums));
    }
}
