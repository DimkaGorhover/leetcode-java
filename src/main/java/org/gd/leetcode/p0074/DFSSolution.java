package org.gd.leetcode.p0074;

/**
 * @see BinarySearchSolution
 */
class DFSSolution implements Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < cols) {

            int num = matrix[row][col];
            if (num == target)
                return true;

            if (num > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
