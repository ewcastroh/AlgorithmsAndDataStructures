package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void mergeSortAsc(int[] nums, int left, int rigth) {
        if (rigth > left) {
            int middle = (left + rigth) / 2;
            mergeSortAsc(nums, left, middle);
            mergeSortAsc(nums, middle + 1, rigth);
            merge(nums, left, middle, rigth);
        }
    }

    public static void merge(int[] A, int left, int middle, int right) {
        int[] leftTmpArray = new int[middle - left + 2];
        int[] rightTmpArray = new int[right - middle + 1];

        for (int i = 0; i <= middle - left; i++)
            leftTmpArray[i] = A[left + i];
        for (int i = 0; i < right - middle; i++)
            rightTmpArray[i] = A[middle + 1 + i];

        leftTmpArray[middle - left + 1] = Integer.MAX_VALUE;
        rightTmpArray[right - middle] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};

        System.out.println("Before sorting:");
        String unSortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(unSortedArrayAsc);

        System.out.println("After sorting Asc:");
        mergeSortAsc(nums, 0, nums.length - 1);
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);
    }

}
