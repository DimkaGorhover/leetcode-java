package org.gd.leetcode.p0200;

import org.gd.leetcode.common.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

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

    interface Cleaner {

        void clean(int row, int col);
    }

    static class RecursiveCleaner implements Cleaner {

        private final char[][] grid;
        private final int rows;
        private final int cols;

        RecursiveCleaner(char[][] grid) {
            this.grid = grid;
            rows = grid.length;
            cols = grid[0].length;
        }

        @Override
        public void clean(int row, int col) {
            if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
                return;

            clean(row + 1, col);
            clean(row - 1, col);

            clean(row, col + 1);
            clean(row, col - 1);
        }
    }

    static class QueueCleaner implements Cleaner {

        private final char[][] grid;
        private final int rows;
        private final int cols;

        QueueCleaner(char[][] grid) {
            this.grid = grid;
            rows = grid.length;
            cols = grid[0].length;
        }

        @Override
        public void clean(int row, int col) {
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{row, col});
            while (!q.isEmpty()) {

                int[] pair = q.poll();

                row = pair[0];
                col = pair[1];

                if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
                    continue;

                grid[row][col] = '0';

                if (col < cols - 1) q.add(new int[]{row, col + 1});
                if (col > 0) q.add(new int[]{row, col - 1});

                if (row < rows - 1) q.add(new int[]{row + 1, col});
                if (row > 0) q.add(new int[]{row - 1, col});
            }
        }
    }
}
