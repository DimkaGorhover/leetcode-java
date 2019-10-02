package org.gd.hackerrank.other;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class DiagonalDifference {

    private DiagonalDifference() { throw new UnsupportedOperationException(); }

    static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i][i] - arr[i][n - i - 1];
        return Math.abs(sum);
    }
}
