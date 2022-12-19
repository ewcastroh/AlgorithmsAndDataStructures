package search;

import java.util.logging.Logger;

public class BinarySearch {

    private static final Logger LOGGER = Logger.getLogger("search.BinarySearch");

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        LOGGER.info(() -> "Element found in position: " + binarySearch(arr, target));
    }

}
