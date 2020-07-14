package org.gd.leetcode.p0304;

/**
 * @author Horkhover D.
 * @since 2020-07-14
 */
class DynamicProgrammingSolution implements Solution {

    private final int[][] matrix;
    private final int[][] sums;

    DynamicProgrammingSolution(int[][] matrix) {

        this.matrix = matrix;

        int rows = matrix.length;
        int cols = matrix[0].length;

        sums = new int[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++)
                sums[i][j] += matrix[i][j] + (j > 0 ? sums[i][j - 1] : 0);

            for (int j = 0; i > 0 && j < cols; j++)
                sums[i][j] += sums[i - 1][j];

        }
    }

    @Override
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1--;
        col1--;
        return sums[row2][col2]
                - (row1 >= 0 ? sums[row1][col2] : 0)
                - (col1 >= 0 ? sums[row2][col1] : 0)
                + (row1 >= 0 && col1 >= 0 ? sums[row1][col1] : 0);
    }

    @Override
    public String toString() {
        return Utils.toString(matrix, sums);
    }
}
