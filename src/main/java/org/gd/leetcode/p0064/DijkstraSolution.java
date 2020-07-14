package org.gd.leetcode.p0064;

import java.util.PriorityQueue;

class DijkstraSolution implements ISolution {

    public int minPathSum(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        PriorityQueue<PathPoint> queue = new PriorityQueue<>();
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
