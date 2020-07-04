package org.gd.leetcode.p0064;

import java.util.PriorityQueue;

class DijkstraSolution implements ISolution {

    private int[][] grid;
    private int rows, cols;

    private void setGrid(int[][] grid) {
        this.grid = grid;
        rows = grid.length;
        cols = rows > 0 ? grid[0].length : 0;
    }

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        setGrid(grid);

        PriorityQueue<PathPoint> queue = new PriorityQueue<>(PathPoint::compareTo);
        queue.add(new PathPoint(null, 0, 0, 0));
        PathPoint point;

        while ((point = queue.poll()) != null) {

            if (point.isFinish())
                return point.sum();

            PathPoint down = point.down();
            if (down != null)
                queue.add(down);

            PathPoint right = point.right();
            if (right != null)
                queue.add(right);
        }

        throw new UnsupportedOperationException("not supported yet");
    }

    class PathPoint implements Comparable<PathPoint> {

        private final PathPoint prev;
        private final int row, col, sum;

        PathPoint(PathPoint prev, int row, int col, int sum) {

            this.prev = prev;

            this.row = row;
            this.col = col;

            this.sum = sum + grid[row][col];
        }

        @Override
        public int compareTo(PathPoint o) {
            return Integer.compare(sum, o.sum);
        }

        int sum() { return sum; }

        boolean isFinish() {
            return row == (rows - 1) && col == (cols - 1);
        }

        PathPoint down() {
            if (row == rows - 1)
                return null;

            return new PathPoint(this, row + 1, col, sum);
        }

        PathPoint right() {
            if (col == cols - 1)
                return null;

            return new PathPoint(this, row, col + 1, sum);
        }

        private String path() {
            String path = coordinates();
            if (prev != null)
                path = prev.path() + "->" + path;
            return path;
        }

        private String coordinates() {
            return String.format("(%d;%d)", row, col);
        }

        @Override
        public String toString() {
            return path() + "=>" + sum;
        }
    }
}
