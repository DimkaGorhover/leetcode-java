package org.gd.leetcode.p0200;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-31
 */
class RecursiveCleaner implements Cleaner {

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

        grid[row][col] = '0';

        clean(row + 1, col);
        clean(row - 1, col);

        clean(row, col + 1);
        clean(row, col - 1);
    }
}
