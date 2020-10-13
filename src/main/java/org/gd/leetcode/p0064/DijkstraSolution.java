package org.gd.leetcode.p0064;

import java.util.Optional;
import java.util.PriorityQueue;

import static java.util.Objects.requireNonNull;

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

    interface PathPoint extends Comparable<PathPoint> {

        static PathPoint start(int[][] grid) {
            requireNonNull(grid, "\"grid\" cannot be null");
            return PathPointRecord.start(grid);
        }

        int sum();

        boolean isFinish();

        Optional<PathPoint> down();

        Optional<PathPoint> right();

        @Override
        default int compareTo(PathPoint o) {
            return Integer.compare(sum(), o.sum());
        }
    }

    record Grid(int[][] grid, int rows, int cols) {

        static Grid of(int[][] grid) {

            if (grid == null)
                throw new NullPointerException("grid");

            return new Grid(grid, grid.length, grid[0].length);
        }
    }

    record Coordinates(int row, int col) {

        static final Coordinates ZERO = new Coordinates(0, 0);

        Coordinates right() {
            return new Coordinates(row, col + 1);
        }

        Coordinates down() {
            return new Coordinates(row + 1, col);
        }
    }

    record PathPointRecord(Grid grid, Coordinates coordinates, int sum) implements PathPoint {

        private static PathPointRecord create(Grid grid, PathPoint prev, Coordinates coordinates) {

            if (grid == null)
                throw new NullPointerException("grid");

            return new PathPointRecord(
                    grid,
                    coordinates,
                    (prev == null ? 0 : prev.sum()) + grid.grid[coordinates.row][coordinates.col]);
        }

        static PathPointRecord start(int[][] grid) {
            return create(Grid.of(grid), null, Coordinates.ZERO);
        }

        @Override
        public int sum() { return sum; }

        @Override
        public boolean isFinish() {
            return coordinates.row == (grid.rows - 1) && coordinates.col == (grid.cols - 1);
        }

        @Override
        public Optional<PathPoint> down() {
            if (coordinates.row == grid.rows - 1)
                return Optional.empty();

            return Optional.of(create(grid, this, coordinates.down()));
        }

        @Override
        public Optional<PathPoint> right() {
            if (coordinates.col == grid.cols - 1)
                return Optional.empty();

            return Optional.of(create(grid, this, coordinates.right()));
        }
    }
}
