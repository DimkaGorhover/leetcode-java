package org.gd.leetcode.p0200;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
@LeetCode(
        name = "Number of Islands",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.UNION_FIND
        }
)
class Solution {

    public int numIslands(char[][] grid) {

        final int rows;
        final int cols;

        if (grid == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0)
            return 0;

        final Cleaner cleaner = (rows * cols > (1 << 5)) ? new QueueCleaner(grid) : new RecursiveCleaner(grid);

        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    cleaner.clean(row, col);
                    count++;
                }
            }
        }
        return count;
    }
}
