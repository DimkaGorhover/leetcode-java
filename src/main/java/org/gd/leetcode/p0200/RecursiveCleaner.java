package org.gd.leetcode.p0200;

/**
 * @author Horkhover Dmytro
 * @see Solution
 * @see QueueCleaner
 * @since 2020-07-31
 */
class RecursiveCleaner implements Cleaner {

    private final char[][] grid;
    private final int rows, cols;

    RecursiveCleaner(char[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
    }

    @Override
    public int clean(int row, int col) {
        if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
            return 0;

        grid[row][col] = '0';

        int count = 1;

        count += clean(row + 1, col);
        count += clean(row - 1, col);

        count += clean(row, col + 1);
        count += clean(row, col - 1);

        return count;
    }
}
