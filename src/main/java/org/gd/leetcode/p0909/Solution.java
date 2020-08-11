package org.gd.leetcode.p0909;

import org.gd.leetcode.common.LeetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * TODO: https://leetcode.com/problems/snakes-and-ladders/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
@LeetCode(
        name = "Snakes and Ladders",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
class Solution {

    private int[][] board;
    private int rows, cols, lastNumber;

    void reset(int[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        lastNumber = rows * cols;
    }

    public int snakesAndLadders(int[][] board) {

        if (board == null || board.length == 0 || board[0].length == 0)
            return 0;

        reset(board);

        Queue q = new HeapQueueFactory().create(rows * cols * 6);
        q.add(startPoint());

        Point point;
        while ((point = q.poll()) != null) {

            if (point.isFinish())
                return point.steps();

            int number = point.position();
            for (int i = 1; i <= 6 && number + i <= lastNumber; i++) {
                Point next = point.add(i);
                if (next != null)
                    q.add(next);
            }
        }

        return -1;
    }

    Point startPoint() {
        return new Point(rows - 1, 0, 0);
    }

    interface Queue {

        Point poll();

        void add(Point point);
    }

    class Point implements Comparable<Point> {

        final int row, col, steps;

        Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }

        @Override
        public int compareTo(Point o) {
            int compare = Integer.compare(steps(), o.steps());
            return compare != 0 ? compare : Integer.compare(o.position(), position());
        }

        int position() {
            final int downRow = rows - 1 - this.row;
            if (downRow % 2 == 0) {
                return (downRow * cols) + (col + 1);
            } else {
                return (downRow * cols) + (cols - col);
            }
        }

        boolean isFinish() { return position() >= lastNumber; }

        int redirect() { return isFinish() ? -1 : board[row][col]; }

        int steps() { return steps; }

        Point add(int value) { return next(position() + value); }

        Point next(int position) {

            Set<Integer> visited = new HashSet<>();
            visited.add(this.position());

            while (true) {

                if (position() == position)
                    return null;

                int downRow = ((position - 1) / cols);
                int row = (rows - 1) - ((position - 1) / cols);
                int col = position - (downRow * cols) - 1;
                if (downRow % 2 != 0)
                    col = cols - 1 - col;

                Point point = new Point(row, col, steps + 1);

                if (point.position() == point.redirect() || point.isFinish())
                    return point;

                if (point.redirect() >= 0) {
                    position = point.redirect();
                    if (visited.contains(position))
                        return null;

                    visited.add(position);
                    continue;
                }

                return point;
            }
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    (redirect() >= 0 ? ", redirect=" + redirect() : "") +
                    ", number=" + position() +
                    '}';
        }
    }

    interface QueueFactory {

        Solution.Queue create(int capacity);

    }

    static class HeapQueueFactory implements QueueFactory {

        @Override
        public Solution.Queue create(int capacity) {
            return new QueueImpl(capacity);
        }

        static class QueueImpl implements Solution.Queue {

            private final PriorityQueue<Point> heap;

            QueueImpl(int capacity) {
                heap = new PriorityQueue<>(capacity);
            }

            @Override
            public Point poll() { return heap.poll(); }

            @Override
            public void add(Point point) { heap.add(point); }

            @Override
            public String toString() { return heap.toString(); }
        }
    }

    static class TreeSetQueueFactory implements QueueFactory {

        @Override
        public Solution.Queue create(int capacity) {
            return new QueueImpl();
        }

        static class QueueImpl implements Solution.Queue {

            private final TreeSet<Point> set = new TreeSet<>();

            @Override
            public Point poll() { return set.pollFirst(); }

            @Override
            public void add(Point point) { set.add(point); }

            @Override
            public String toString() { return set.toString(); }
        }
    }
}
