package org.gd.leetcode.p0542;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class DPSolution implements Solution {

    public int[][] updateMatrix(int[][] matrix) {

        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return matrix;

        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                dp[row][col] = (Integer.MAX_VALUE - 10_000 - 1);

        final int lastRow = rows - 1, lastCol = cols - 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 0) {
                    dp[row][col] = 0;
                    continue;
                }

                if (row > 0)
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row - 1][col]);

                if (col > 0)
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row][col - 1]);
            }
        }

        for (int row = lastRow; row >= 0; row--) {
            for (int col = lastCol; col >= 0; col--) {

                if (row < lastRow)
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row + 1][col]);

                if (col < lastCol)
                    dp[row][col] = Math.min(dp[row][col], 1 + dp[row][col + 1]);
            }
        }

        return dp;
    }
}
