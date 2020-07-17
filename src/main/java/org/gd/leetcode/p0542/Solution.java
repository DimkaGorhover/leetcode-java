package org.gd.leetcode.p0542;

import org.gd.leetcode.common.LeetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/01-matrix/
 */
@LeetCode(
        name = "01 Matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    private int[][] matrix;
    private int rows;
    private int cols;
    private Set<Point> visited = new HashSet<>();
    private Deque<Point> q;

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;

        this.matrix = matrix;
        rows = matrix.length;
        cols = matrix[0].length;
        visited = new HashSet<>();
        q = new LinkedList<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                Point point = new Point(row, col);
                if (matrix[row][col] == 0) {
                    visited.add(point);
                } else {
                    q.add(point);
                }
            }
        }



        while (!q.isEmpty()) {

            Point point = q.poll();
            if (visited.contains(point))
                continue;

            int min = Integer.MAX_VALUE;

            ArrayList<Point> next = new ArrayList<>(4);

            if (min > 0 && point.hasUp()) {
                Point prev = point.up();
                if (!visited.contains(prev)) {
                    next.add(prev);
                } else {
                    min = Math.min(min, prev.value());
                }
            }

            if (min > 0 && point.hasDown()) {
                Point prev = point.down();
                if (!visited.contains(prev)) {
                    next.add(prev);
                } else {
                    min = Math.min(min, prev.value());
                }
            }

            if (min > 0 && point.hasLeft()) {
                Point prev = point.left();
                if (!visited.contains(prev)) {
                    next.add(prev);
                } else {
                    min = Math.min(min, prev.value());
                }
            }

            if (min > 0 && point.hasRight()) {
                Point prev = point.right();
                if (!visited.contains(prev)) {
                    next.add(prev);
                } else {
                    min = Math.min(min, prev.value());
                }
            }

            if (min == Integer.MIN_VALUE) {

                q.addFirst(point);
                q.addFirst(next.get(0));

            } else {
                point.set(min + point.value());
                visited.add(point);
            }
        }


        return matrix;
    }

    class Point {

        final int row, col, hash;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
            this.hash = row * 31 + col;
        }

        int value() { return matrix[row][col]; }

        void set(int value) {
            matrix[row][col] = value;
        }

        List<Point> neighbours() {
            ArrayList<Point> points = new ArrayList<>(4);
            if (row > 0)
                points.add(new Point(row - 1, col));

            return points;
        }

        boolean hasUp() { return row > 0; }

        Point up() { return new Point(row - 1, col); }

        boolean hasLeft() { return col > 0; }

        Point left() { return new Point(row, col - 1); }

        boolean hasDown() { return row < rows - 1; }

        Point down() { return new Point(row + 1, col); }

        boolean hasRight() { return col < cols - 1; }

        Point right() { return new Point(row, col + 1); }

        @Override
        public int hashCode() { return hash; }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null) return false;
            if (!(obj instanceof Point)) return false;
            Point point = (Point) obj;
            return row == point.row && col == point.col;
        }

        @Override
        public String toString() {
            return String.format("[%d;%d => %d]", row, col, matrix[row][col]);
        }
    }
}
