package org.gd.leetcode.p0741;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/cherry-pickup/
 *
 * @author Horkhover D.
 * @since 2020-07-16
 */
@LeetCode(
        name = "Cherry Pickup",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.DYNAMIC_PROGRAMMING
)
class Solution {

    private Point[][] grid;
    private int rows, cols;

    private void reset(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = new Point[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.grid[row][col] = Point.of(row, col, grid[row][col]);
            }
        }
    }

    private int forward() {

        for (int row = 1; row < rows && !grid[row][0].isBlock(); row++)
            grid[row][0].addPrev(grid[row - 1][0]);

        for (int col = 1; col < cols && !grid[0][col].isBlock(); col++)
            grid[0][col].addPrev(grid[0][col - 1]);

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {

                if (grid[row][col].isBlock())
                    continue;

                final Point up = grid[row - 1][col];
                final Point left = grid[row][col - 1];

                if (up.isBlock()) {
                    if (!left.isBlock()) {
                        grid[row][col].addPrev(left);
                    }
                } else if (left.isBlock()) {
                    grid[row][col].addPrev(up);
                } else if (up.value() > left.value()) {
                    grid[row][col].addPrev(up);
                } else {
                    grid[row][col].addPrev(left);
                }
            }
        }

        Point point = grid[rows - 1][cols - 1];
        if (point.isValid()) {
            int value = point.pathSum();
            point.erase();
            return value;
        }

        return -1;
    }

    private int backward() {

        for (int row = rows - 2; row >= 0 && !grid[row][cols - 1].isBlock(); row--)
            grid[row][cols - 1].addPrev(grid[row + 1][cols - 1]);

        for (int col = cols - 2; col >= 0 && !grid[rows - 1][col].isBlock(); col--)
            grid[rows - 1][col].addPrev(grid[rows - 1][col + 1]);

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                Point current = grid[row][col];
                current.reset();
                if (current.isBlock())
                    continue;

                Point right = grid[row][col + 1];
                Point down = grid[row + 1][col];
                if (right.isBlock()) {
                    if (!down.isBlock())
                        current.addPrev(down);
                } else if (down.isBlock()) {
                    current.addPrev(right);
                } else if (right.value() > down.value()) {
                    current.addPrev(right);
                } else {
                    current.addPrev(down);
                }
            }
        }

        return grid[0][0].pathSum();
    }

    public int cherryPickup(int[][] intsGrid) {
        reset(intsGrid);

        final int forward = forward();
        if (forward == -1)
            return 0;

        return forward + backward();
    }

}
