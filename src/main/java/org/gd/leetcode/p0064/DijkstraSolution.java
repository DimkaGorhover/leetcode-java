package org.gd.leetcode.p0064;

import java.util.PriorityQueue;

/**
 * @deprecated this solution is toooooooo slow. Use {@link DPSolution} instead
 */
@SuppressWarnings("SpellCheckingInspection")
@Deprecated
class DijkstraSolution implements Solution {

    public int minPathSum(int[][] grid) {

        final int rows, cols;
        if (grid == null || (rows = grid.length) == 0 || (cols = grid[0].length) == 0)
            return 0;

        PriorityQueue<PathPoint> queue = new PriorityQueue<>(rows * cols);
        queue.add(PathPoint.start(grid));
        PathPoint point;
        while ((point = queue.poll()) != null && !Thread.currentThread().isInterrupted()) {
            if (point.isFinish())
                return point.sum();
            point.down().ifPresent(queue::add);
            point.right().ifPresent(queue::add);
        }

        throw new RuntimeException("it will not happen");
    }
}
