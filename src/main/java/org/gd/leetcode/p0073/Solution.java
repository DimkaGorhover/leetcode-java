package org.gd.leetcode.p0073;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@LeetCode(
        name = "Set Matrix Zeroes",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return;

        final int rows = matrix.length;
        final int cols = matrix[0].length;

        final boolean[] rowsMark = new boolean[rows];
        final boolean[] colsMark = new boolean[cols];

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (matrix[row][col] == 0)
                    rowsMark[row] = colsMark[col] = true;

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (rowsMark[row] || colsMark[col])
                    matrix[row][col] = 0;
    }
}
