package org.gd.leetcode.p1289;

import org.gd.common.Repeat;

/**
 * @author Horkhover Dmytro
 * @see HalfDPSolution
 * @since 2020-08-07
 */
@Repeat("this is not my solution :( ")
class FullDPSolution implements Solution {

    private static int[] minArray(int[] arr) {
        int[] minArray = new int[arr.length];
        minArray[0] = Integer.MAX_VALUE;
        int min = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            minArray[i] = min;
            min = Math.min(min, arr[i]);
        }
        min = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minArray[i] = Math.min(minArray[i], min);
            min = Math.min(arr[i], min);
        }
        return minArray;
    }

    public int minFallingPathSum(int[][] matrix) {

        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return 0;

        int[][] dp = new int[rows][cols];
        System.arraycopy(matrix[0], 0, dp[0], 0, cols);

        int min = 0;
        for (int i = 1; i < rows; i++) {

            dp[i - 1] = minArray(dp[i - 1]);
            min = Integer.MAX_VALUE;

            for (int j = 0; j < cols; j++) {

                min = Math.min(min, dp[i][j] = dp[i - 1][j] + matrix[i][j]);
            }
        }
        return min;
    }
}
