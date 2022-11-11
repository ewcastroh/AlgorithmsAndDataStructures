package arrays;

import java.util.ArrayList;
import java.util.List;

/*
 Given a mxn matrix, return all elements of the matrix in spiral order.
           [1,2,3],
  matrix = [4,5,6],
           [7,8,9]

  list = [1,2,3,6,9,8,7,4,5]

          [1, 2, 3,  4],
  matrix= [5, 6, 7,  8],
          [9, 10,11,12],
          [13,14,15,16]

  list = [1,2,3,4,8,12,16,15,14,13,9,5,6,7,22,10]
 */
public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int pointerRow1 = 0, pointerRow2 = matrix.length - 1;
        int pointerCol1 = 0, pointerCol2 = matrix[0].length - 1;
        while (pointerRow1 <= pointerRow2 && pointerCol1 <= pointerCol2) {
            for (int c = pointerCol1; c <= pointerCol2; c++) {
                list.add(matrix[pointerRow1][c]);
            }
            for (int r = pointerRow1 +1; r <= pointerRow2; r++) {
                list.add(matrix[r][pointerCol2]);
            }
            if (pointerRow1 < pointerRow2 && pointerCol1 < pointerCol2) {
                for (int c = pointerCol2 - 1; c > pointerCol1; c--) {
                    list.add(matrix[pointerRow2][c]);
                }
                for (int r = pointerRow2; r > pointerRow1; r--) {
                    list.add(matrix[r][pointerCol1]);
                }
            }
            pointerRow1++;
            pointerRow2--;
            pointerCol1++;
            pointerCol2--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        List<Integer> list = spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer + ", ");
        }
    }
}
