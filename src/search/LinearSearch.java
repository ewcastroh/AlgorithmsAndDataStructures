package search;

import java.util.logging.Logger;

public class LinearSearch {

    private static final Logger logger = Logger.getLogger("search.LinearSearch");

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 3, 9, 8, 6, 4};
        int target = 4;
        logger.info(() -> "Value found in position: " + linearSearch(array, target));
    }
}
