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
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH,
                LeetCode.Tags.UNION_FIND
        }
)
class Solution {

    private final CleanerFactory cleanerFactory;

    Solution() {
        this(QueueCleaner::new);
    }

    Solution(CleanerFactory cleanerFactory) {
        this.cleanerFactory = cleanerFactory;
    }

    public int numIslands(char[][] grid) {

        final int rows;
        final int cols;

        if (grid == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0)
            return 0;

        final Cleaner cleaner = cleanerFactory.create(grid);

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
