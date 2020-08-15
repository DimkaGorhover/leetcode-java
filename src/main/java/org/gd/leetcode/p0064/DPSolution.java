package org.gd.leetcode.p0064;

class DPSolution implements Solution {

    public int minPathSum(int[][] grid) {

        if (grid == null)
            throw new NullPointerException();

        final int rows = grid.length;
        if (rows == 0)
            return 0;

        final int cols = grid[0].length;
        if (cols == 0)
            return 0;

        for (int row = 1; row < rows; row++) {
            grid[row][0] += grid[row - 1][0];
        }

        for (int col = 1; col < cols; col++) {
            grid[0][col] += grid[0][col - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                grid[i][j] = Math.min(grid[i][j] + grid[i - 1][j], grid[i][j] + grid[i][j - 1]);
            }
        }

        return grid[rows - 1][cols - 1];
    }
}
