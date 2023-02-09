package dynamicprogramming;

import java.util.Arrays;

/*
 * Given weights and values of n items, put these items in a knapsack of capacity w(weight) to get the maximum total
 * value in the knapsack.
 * 0/1 means either you pick the item or tou don't pick the item.
 *
 * Weight (kg)  |   1   |   3   |   4   |   5   |
 * Value ($)    |   1   |   4   |   5   |   7   |
 * Total Weight: 7
 */
public class ZeroOneKnapsackProblem {

    public static int knapsack(int[] values, int[] weights, int totalWeight) {
        int[][] dynamicTable = new int[values.length + 1][totalWeight + 1];
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < weights.length - 1; j++) {
                if (i == 0 || j == 0) {
                    dynamicTable[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    dynamicTable[i][j] = Math.max(values[i - 1] + dynamicTable[i - 1][j - weights[i - 1]], dynamicTable[i - 1][j]);
                } else {
                    dynamicTable[i][j] = dynamicTable[i - 1][j];
                }
            }
        }
        return dynamicTable[values.length][totalWeight];
    }

    public static void main(String[] args) {
        int[] values = {1, 4, 5, 7};
        int[] weights = {1, 3, 4, 5};
        int totalWeight = 7;
        System.out.println("Values: ");
        System.out.println(Arrays.toString(values));
        System.out.println("Weights: ");
        System.out.println(Arrays.toString(weights));
        System.out.println("knapsack: " + knapsack(values, weights, totalWeight));

    }
}
