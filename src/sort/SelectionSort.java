package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SelectionSort {

    public static int[] selectionSortAsc(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static int[] selectionSortDes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int maxIndex = i;
            for (int j = i; j < length; j++) {
                if (nums[j] > nums[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
        }
        return nums;
    }

    public static void main(String args[]) {
        int[] nums = {2, 1, 8, 3, 5, 9};

        selectionSortAsc(nums);
        System.out.println("Selection sort Asc.");
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);

        selectionSortDes(nums);
        System.out.println("Selection sort Des.");
        String sortedArrayDes = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayDes);
    }
}
