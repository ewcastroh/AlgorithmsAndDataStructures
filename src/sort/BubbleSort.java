package sort;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class BubbleSort {

    private static final Logger LOGGER = Logger.getLogger("sort.BubbleSort");

    public static int[] bubbleSortAsc(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j <= length - 2 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] bubbleSortDes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i <= length - 2; i++) {
            for (int j = 0; j <= length - 2 - i; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String args[]) {
        int[] nums = {2, 1, 8, 3, 5, 9};
        bubbleSortAsc(nums);
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);

        bubbleSortDes(nums);
        System.out.println("Bubble sort Des.");
        String sortedArrayDes = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayDes);
    }
}
