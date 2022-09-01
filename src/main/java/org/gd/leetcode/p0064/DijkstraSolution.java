package org.gd.leetcode.p0064;

import java.util.Objects;
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

    static final class Grid {
        private final int[][] grid;
        private final int rows;
        private final int cols;

        Grid(int[][] grid, int rows, int cols) {
            this.grid = grid;
            this.rows = rows;
            this.cols = cols;
        }

        static Grid of(int[][] grid) {

            if (grid == null)
                throw new NullPointerException("grid");

            return new Grid(grid, grid.length, grid[0].length);
        }

        public int[][] grid() {return grid;}

        public int rows() {return rows;}

        public int cols() {return cols;}

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            Grid that = (Grid) obj;
            return Objects.equals(this.grid, that.grid) &&
                    this.rows == that.rows &&
                    this.cols == that.cols;
        }

        @Override
        public int hashCode() {
            return Objects.hash(grid, rows, cols);
        }

        @Override
        public String toString() {
            return "Grid[" +
                    "grid=" + grid + ", " +
                    "rows=" + rows + ", " +
                    "cols=" + cols + ']';
        }

    }

    static final class Coordinates {

        static final Coordinates ZERO = new Coordinates(0, 0);
        private final int row;
        private final int col;

        Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Coordinates right() {
            return new Coordinates(row, col + 1);
        }

        Coordinates down() {
            return new Coordinates(row + 1, col);
        }

        public int row() {return row;}

        public int col() {return col;}

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            Coordinates that = (Coordinates) obj;
            return this.row == that.row &&
                    this.col == that.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "Coordinates[" +
                    "row=" + row + ", " +
                    "col=" + col + ']';
        }

    }

    static class PathPointRecord implements PathPoint {
        private final Grid grid;
        private final Coordinates coordinates;
        private final int sum;

        PathPointRecord(Grid grid, Coordinates coordinates, int sum) {
            this.grid = grid;
            this.coordinates = coordinates;
            this.sum = sum;
        }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PathPointRecord)) return false;
            PathPointRecord that = (PathPointRecord) o;
            return sum == that.sum && Objects.equals(grid, that.grid) && Objects.equals(
                    coordinates,
                    that.coordinates);
        }

        @Override
        public int hashCode() {
            return Objects.hash(grid, coordinates, sum);
        }
    }
}
