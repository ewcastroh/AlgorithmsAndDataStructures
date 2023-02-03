package dynamicprogramming;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinPathSum {

    public static int minPathSum(int[][] matrix) {
        int height = matrix.length;
        int weight = matrix[0].length;
        int [][] dynamicMatrix = new int[height][weight];
        dynamicMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < height; i++) {  // First Column
            dynamicMatrix[i][0] = dynamicMatrix[i - 1][0] + matrix[i][0];
        }
        for (int j = 1; j < weight; j++) {  // First Row
            dynamicMatrix[0][j] = dynamicMatrix[0][j - 1] + matrix[0][j];
        }
        for (int i = 1; i < height; i++) {
            for (int j = 1; j < weight; j++) {
                dynamicMatrix[i][j] = matrix[i][j] + Math.min(dynamicMatrix[i - 1][j], dynamicMatrix[i][j - 1]);
            }
        }
        return dynamicMatrix[height - 1][weight - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 5, 1},
                {3, 2, 4, 5},
                {1, 2, 3, 1},
                {4, 3, 5, 2}
        };
        System.out.println("Matrix: ");
        Stream.of(nums)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("Min Path Sum: " + minPathSum(nums));
    }
}
