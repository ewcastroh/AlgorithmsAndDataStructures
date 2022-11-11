package arrays;

/*
 You are given an nxn 2D matrix representing an image.
 Rotate the image by 90 degrees (clockwise).
 YOu have to rotate the image in-place, which means you have to modify
 the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 */

/*
  Concept:
  [1,2,3],
  [4,5,6],
  [7,8,9]
  mirror around secondary diagonal
  [9, 6, 3],
  [8, 5, 2],
  [7, 4, 1]
  mirror horizontally around middle line
  [7, 4, 1],
  [8, 5, 2],
  [9, 6, 3]
  */

/*
[ 5, 1, 9,11],
[ 2, 4, 8,10],
[13, 3, 6, 7],
[15,14,12,16]
mirror around secondary diagonal
[16, 7, 10, 11],
[12, 6,  8,  9],
[14, 3,  4,  1],
[15, 13, 2,  5]
mirror horizontally around middle line
...

*/
public class RotateImage {

    public static void rotate(int[][] matrix) {
        mirrorSecondaryDiagonal(matrix);
        mirrorHorizontally(matrix);
    }

    private static void mirrorSecondaryDiagonal(int[][] matrix) {
        // flip second diagonaly
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                int current = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - j - 1][matrix.length - i - 1];
                matrix[matrix.length - j - 1][matrix.length - i - 1] = current;
            }
        }
    }
    // flip horizontally
    private static void mirrorHorizontally(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++) {
            for(int j = 0; j < matrix.length; j++) {
                int current = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - i - 1][j];
                matrix[matrix.length - i - 1][j] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        /*matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;*/

        /*
                 [1,2,3],
        matrix = [4,5,6],
                 [7,8,9]
        */

        /*************print matrix, before rotation**************/
        System.out.println("Before rotation:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        /*
        Output:
        1,2,3,
        4,5,6,
        7,8,9 */

        rotate(matrix);
        /*
                 [7,4,1],
        matrix = [8,5,2],
                 [9,6,3]
        */
        /*************print matrix, after rotation**************/
        System.out.println("After rotation:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        /* Output:
        7,4,1,
        8,5,2,
        9,6,3 */

    }
}
