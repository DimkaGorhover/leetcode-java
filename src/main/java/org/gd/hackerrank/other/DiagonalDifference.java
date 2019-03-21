package org.gd.hackerrank.other;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class DiagonalDifference {

    static int diagonalDifference(int[][] arr) {
        int n = arr.length, sum1 = 0, sum2 = 0;
        for (int i=0; i<n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        return Math.abs(sum1 - sum2);
    }
}
