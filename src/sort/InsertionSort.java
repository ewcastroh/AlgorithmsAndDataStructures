package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {

    public static int[] insertionSortAsc(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static int[] insertionSortDes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] < temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 2, 1, 8, 1, 9};
        insertionSortAsc(nums);
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);

        insertionSortDes(nums);
        String sortedArrayDes = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayDes);
    }
}
