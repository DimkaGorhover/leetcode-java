package org.gd.leetcode.p0994;

import org.gd.leetcode.common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

/**
 * https://leetcode.com/problems/rotting-oranges/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-09
 */
@SuppressWarnings("ConstantConditions")
@LeetCode(
        name = "Rotting Oranges",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    public int orangesRotting(int[][] grid) {

        final int rows, cols;
        if (grid == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0)
            return -1;

        int freshOranges = 0;
        Queue<GridPoint> points = new LinkedList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    points.add(new GridPoint(grid, rows, cols, row, col));
                } else if (grid[row][col] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0)
            return 0;

        if (points.isEmpty())
            return -1;

        int minutes = 0;
        while (!points.isEmpty()) {
            int size = points.size();
            for (int ignored = 0; ignored < size; ignored++) {

                freshOranges -= points.poll().rotting(points::add);

                if (freshOranges == 0)
                    return minutes + 1;

            }
            minutes++;
        }


        return freshOranges == 0 ? minutes : -1;
    }

    static class GridPoint {

        final int[][] grid;
        final int rows, cols, row, col;

        GridPoint(final int[][] grid,
                  final int rows,
                  final int cols,
                  final int row,
                  final int col) {
            this.grid = grid;
            this.rows = rows;
            this.cols = cols;
            this.row = row;
            this.col = col;
        }

        int rotting(Consumer<GridPoint> consumer) {
            int result = 0;

            // left
            if (col > 0 && grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                consumer.accept(new GridPoint(grid, rows, cols, row, col - 1));
                result++;
            }

            // right
            if (col < cols - 1 && grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                consumer.accept(new GridPoint(grid, rows, cols, row, col + 1));
                result++;
            }

            // up
            if (row > 0 && grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                consumer.accept(new GridPoint(grid, rows, cols, row - 1, col));
                result++;
            }

            // down
            if (row < rows - 1 && grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                consumer.accept(new GridPoint(grid, rows, cols, row + 1, col));
                result++;
            }

            return result;
        }
    }
}
