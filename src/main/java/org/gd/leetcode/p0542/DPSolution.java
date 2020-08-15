package org.gd.leetcode.p0542;

import java.util.Arrays;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class DPSolution implements Solution {

    private static int[][] copy(int[][] matrix) {
        int[][] copy = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < copy.length; i++) {
            int[] line = matrix[i];
            copy[i] = Arrays.copyOf(line, line.length);
        }
        return copy;
    }

    public int[][] updateMatrix(int[][] matrix) {

        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return matrix;

        int[][] dp = copy(matrix);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int value = matrix[row][col];

                if (value == 0)
                    continue;

                int up = row > 0 ? matrix[row - 1][col] : 0;
                int left = col > 0 ? matrix[row][col - 1] : 0;

                dp[row][col] = value + Math.min(up, left);

            }
        }

        final int lastRow = rows - 1;
        final int lastCol = cols - 1;

        for (int row = lastRow; row >= 0; row--) {
            for (int col = lastCol; col >= 0; col--) {

                int value = matrix[row][col];

                if (value == 0)
                    continue;

                int down = row < lastRow ? matrix[row + 1][col] : 0;
                int right = col < lastCol ? matrix[row][col + 1] : 0;

                dp[row][col] = value + Math.min(down, right);

            }
        }

        return dp;
    }
}
