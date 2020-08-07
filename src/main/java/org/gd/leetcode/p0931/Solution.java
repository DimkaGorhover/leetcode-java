package org.gd.leetcode.p0931;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@LeetCode(
        name = "Minimum Falling Path Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int minFallingPathSum(int[][] A) {
        final int rows;
        final int cols;
        if (A == null || (rows = A.length) == 0 || (cols = A[0].length) == 0)
            return 0;

        if (rows == 1) {
            int min = A[0][0];
            for (int col = 1; col < cols; col++) {
                min = Math.min(min, A[0][col]);
            }
            return min;
        }

        int minInLine = Integer.MAX_VALUE;
        for (int row = 1; row < rows; row++) {

            minInLine = Integer.MAX_VALUE;

            for (int col = 0; col < cols; col++) {

                int min = A[row - 1][col];

                int prev;
                if (col > 0 && min > (prev = A[row - 1][col - 1]))
                    min = prev;

                if (col < cols - 1 && min > (prev = A[row - 1][col + 1]))
                    min = prev;

                minInLine = Math.min(minInLine, A[row][col] += min);
            }
        }


        return minInLine;
    }
}
