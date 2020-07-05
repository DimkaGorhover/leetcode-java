package org.gd.leetcode.p0063;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 */
@LeetCode(
        name = "Unique Paths II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int uniquePathsWithObstacles(int[][] grid) {

        if (grid == null)
            throw new NullPointerException("grid");

        final int rows = grid.length;
        if (rows == 0)
            throw new IllegalArgumentException("rows");

        final int cols = grid[0].length;
        if (cols == 0)
            throw new IllegalArgumentException("cols");

        if (grid[0][0] == 1 || grid[rows - 1][cols - 1] == 1)
            return 0;

        for (int row = 0; row < rows && grid[row][0] == 0; row++)
            grid[row][0] = -1;

        for (int col = 1; col < cols && grid[0][col] == 0; col++)
            grid[0][col] = -1;

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {

                if (grid[row][col] > 0) continue;

                grid[row][col] += Math.min(grid[row - 1][col], 0);
                grid[row][col] += Math.min(grid[row][col - 1], 0);
            }
        }

        return -(grid[rows - 1][cols - 1]);
    }
}
