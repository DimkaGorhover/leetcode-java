package org.gd.leetcode.p0304;

/**
 * @author Horkhover D.
 * @since 2020-07-14.07.2020
 */
class EachRowSumSolution implements Solution {

    private final int[][] matrix;
    private final int[][] sums;

    EachRowSumSolution(int[][] matrix) {

        this.matrix = matrix;

        sums = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, sum = 0; j < matrix[i].length; j++) {
                sums[i][j] = sum += matrix[i][j];
            }
        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            int s1 = sums[i][col2];
            int s2 = col1 > 0 ? sums[i][col1 - 1] : 0;
            sum += s1 - s2;
        }
        return sum;
    }

    @Override
    public String toString() {
        return Utils.toString(matrix, sums);
    }
}
