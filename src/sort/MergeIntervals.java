package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
        0   1
    0   [1, 3]
    1   [2, 6]
    2   [8, 10]
    3   [15, 18]
 */

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[0]));
        int[][] result = new int[intervals.length][intervals.length];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[0][i- 1] < intervals[0][i]) {
                result[0][i - 1] = intervals[0][i - 1];
                result[0][i - 1] = intervals[0][i - 1];
            }
        }
        return result;
    }
}
