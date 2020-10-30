package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.HackerRank;

/**
 * https://www.hackerrank.com/challenges/2d-array/
 *
 * @author Horkhover Dmytro
 * @since 2020-09-27
 */
@HackerRank(difficulty = HackerRank.Level.EASY)
class Array2DDS {

    private static int sum(int[][] arr, int row, int col) {
        int a1 = arr[row][col] + arr[row][col + 1] + arr[row][col + 2];
        int a2 = arr[row + 1][col + 1];
        int a3 = arr[row + 2][col] + arr[row + 2][col + 1] + arr[row + 2][col + 2];
        return a1 + a2 + a3;
    }

    static int hourglassSum(int[][] arr) {
        final int rows = arr.length;
        final int cols = arr[0].length;

        int max = Integer.MIN_VALUE;
        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {
                max = Math.max(max, sum(arr, row, col));
            }
        }
        return max;
    }
}
