package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }
    }

    private static int partition(int[] nums, int star, int end) {
        int pivot = end;
        int i = star - 1;
        for (int j = star; j <= end; j++) {
            if (nums[j] <= nums[pivot]) {
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};
        System.out.println("Before sorting:");
        String unSortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(unSortedArrayAsc);

        System.out.println("After sorting Asc:");
        quickSort(nums, 0, nums.length-1);
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);
    }
}
