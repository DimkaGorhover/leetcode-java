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

        for (int row = 1; row < rows; row++)
            grid[row][0] += grid[row - 1][0];

        for (int col = 1; col < cols; col++)
            grid[0][col] += grid[0][col - 1];

        for (int row = 1; row < rows; row++)
            for (int col = 1; col < cols; col++)
                grid[row][col] += Math.min(grid[row - 1][col], grid[row][col - 1]);

        return grid[rows - 1][cols - 1];
    }
}
