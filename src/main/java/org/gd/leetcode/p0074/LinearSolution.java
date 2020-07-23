package org.gd.leetcode.p0074;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
class LinearSolution implements Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;

        for (int[] row : matrix)
            for (int cell : row)
                if (cell == target)
                    return true;

        return false;
    }
}
