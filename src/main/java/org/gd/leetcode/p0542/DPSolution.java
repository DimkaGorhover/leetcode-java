package org.gd.leetcode.p0542;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
class DPSolution implements Solution {

    private static final int MAX_VALUE = Integer.MAX_VALUE - 10_001;

    public int[][] updateMatrix(int[][] matrix) {

        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return matrix;

        final int lastRow = rows - 1;
        final int lastCol = cols - 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int value = matrix[row][col];
                if (value == 0)
                    continue;

                int up = 1 + (row > 0 ? matrix[row - 1][col] : 0);
                int left = 1 + (col > 0 ? matrix[row][col - 1] : 0);

                matrix[row][col] = Math.min(up, left);

            }
        }

        for (int row = lastRow; row >= 0; row--) {
            for (int col = lastCol; col >= 0; col--) {

                if (row == 0 && col == 0)
                    continue;

                if (row == lastRow && col == lastCol)
                    continue;

                int value = matrix[row][col];

                if (value == 0)
                    continue;

                int down = 1 + (row < lastRow ? matrix[row + 1][col] : 0);
                int right = 1 + (col < lastCol ? matrix[row][col + 1] : 0);

                matrix[row][col] = Math.min(down, right);

            }
        }

        return matrix;
    }
}
