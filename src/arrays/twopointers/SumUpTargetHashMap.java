package arrays.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumUpTargetHashMap {

    public static int[] sumUp(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        int[] result = sumUp(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
