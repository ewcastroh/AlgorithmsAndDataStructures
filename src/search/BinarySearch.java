package search;

import java.util.logging.Logger;

/* Search for a value in an m x n matrix.
This matrix has the following properties: Integers in each row are sorted from left to right.
Integers in each column are sorted from top to bottom.

    Eg:     10 20 30 40
            15 25 35 45
            27 29 37 48
            32 33 39 50

Search for : 29
Output : [2,1] */

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

    public static String lookForIndex(int[][] matrix, int numberx){
        String result = "[-1, -1]";
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int left = 0;
            int right = matrix[0].length - 1;
            int verticalMiddle = top + (bottom - top) / 2;
            int horizontalMiddle = left + (right - left) / 2;
            while (left <= right) {
                horizontalMiddle = left + (right - left) / 2;
                if (matrix[verticalMiddle][horizontalMiddle] == numberx) {
                    result = "[" + verticalMiddle + ", " + horizontalMiddle + "]";
                } else if (matrix[verticalMiddle][horizontalMiddle] < numberx) {
                    left = horizontalMiddle + 1;
                } else {
                    right = horizontalMiddle - 1;
                }
            }
            if (matrix[verticalMiddle][horizontalMiddle] < numberx) {
                top = verticalMiddle + 1;
            } else {
                bottom = verticalMiddle - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        int numberx = 29;

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        LOGGER.info(() -> "Element from Array found in position: " + binarySearch(arr, target));

        LOGGER.info(() -> "Element from Matrix found in position: " + lookForIndex(matrix, numberx));
    }

}
