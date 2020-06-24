package org.gd.hackerrank.other;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
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
