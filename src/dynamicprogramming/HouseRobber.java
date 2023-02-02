package dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {

    public static int houseRobber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dynamicTable = new int[nums.length];
        dynamicTable[0] = nums[0];
        dynamicTable[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dynamicTable[i] = Math.max(nums[i] + dynamicTable[i - 2], dynamicTable[i - 1]);
        }
        return dynamicTable[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Array: ");
        Arrays.stream(nums).forEach(System.out::println);
        System.out.println("Maximum integer with house robber: " + houseRobber(nums));
    }
}
