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

    private SimplePoint[][] grid;
    private int rows, cols;

    private void reset(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        this.grid = new SimplePoint[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.grid[row][col] = new SimplePoint(grid[row][col]);
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

                final SimplePoint up = grid[row - 1][col];
                final SimplePoint left = grid[row][col - 1];

                if (up.isBlock()) {
                    if (!left.isBlock())
                        grid[row][col].addPrev(left);
                } else if (left.isBlock()) {
                    grid[row][col].addPrev(up);
                } else if (up.value() > left.value()) {
                    grid[row][col].addPrev(up);
                } else {
                    grid[row][col].addPrev(left);
                }
            }
        }

        SimplePoint point = grid[rows - 1][cols - 1];
        int value = point.pathSum();
        point.resetAll();
        return value;
    }

    private int backward() {

        for (int row = rows - 2; row >= 0 && !grid[row][0].isBlock(); row--)
            grid[row][0].addPrev(grid[row + 1][0]);

        for (int col = cols - 2; col >= 0 && !grid[0][col].isBlock(); col--)
            grid[0][col].addPrev(grid[0][col + 1]);

        for (int row = rows - 2; row >= 0; row--) {
            for (int col = cols - 2; col >= 0; col--) {
                if (grid[row][col].isBlock())
                    continue;

                SimplePoint right = grid[row][col + 1];
                SimplePoint down = grid[row + 1][col];
                if (right.isBlock()) {
                    if (!down.isBlock())
                        grid[row][col].addPrev(down);
                } else if (down.isBlock()) {
                    grid[row][col].addPrev(right);
                } else if (right.value() > down.value()) {
                    grid[row][col].addPrev(right);
                } else {
                    grid[row][col].addPrev(down);
                }
            }
        }

        SimplePoint point = grid[0][0];
        int value = point.pathSum();
        point.resetAll();
        return value;
    }

    public int cherryPickup(int[][] intsGrid) {
        reset(intsGrid);

        int forward = forward();
        int backward = backward();

        return forward + backward;
    }

}
