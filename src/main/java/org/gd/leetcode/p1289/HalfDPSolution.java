package org.gd.leetcode.p1289;

/**
 * @author Horkhover Dmytro
 * @see FullDPSolution
 * @since 2020-08-07
 */
class HalfDPSolution implements Solution {

    private static int findMin(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int findMin(int[] arr, int except) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i != except && arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public int minFallingPathSum(int[][] matrix) {

        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return 0;

        if (rows == 1) {
            return findMin(matrix[0]);
        }

        int minInLine = Integer.MAX_VALUE;
        for (int row = 1; row < rows; row++) {

            minInLine = Integer.MAX_VALUE;

            for (int col = 0; col < cols; col++) {

                minInLine = Math.min(minInLine, matrix[row][col] += findMin(matrix[row - 1], col));
            }
        }

        return minInLine;
    }
}
