package org.gd.leetcode.p0064;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @see org.gd.leetcode.p0062.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Minimum Path Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution implements ISolution {

    public int minPathSum(int[][] grid) {

        if (grid == null)
            throw new NullPointerException();

        final int rows = grid.length;
        if (rows == 0)
            return 0;

        final int cols = grid[0].length;
        if (cols == 0)
            return 0;

        for (int i = 1; i < rows; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < cols; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
