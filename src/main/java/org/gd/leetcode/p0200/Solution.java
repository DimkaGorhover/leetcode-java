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

    char[][] grid;
    int rows;
    int cols;

    private void clear(int row, int col) {
        if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        clear(row, col + 1);
        clear(row, col - 1);
        clear(row + 1, col);
        clear(row - 1, col);

        clear(row + 1, col + 1);
        clear(row - 1, col + 1);
        clear(row + 1, col - 1);
        clear(row - 1, col - 1);
    }

    public int numIslands(char[][] grid) {

        if ((this.grid = grid) == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0)
            return 0;

        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == '1') {

                    clear(row, col);

                    count++;
                }

            }
        }

        return count;
    }

    @Override
    public String toString() {
        return "";
    }
}
