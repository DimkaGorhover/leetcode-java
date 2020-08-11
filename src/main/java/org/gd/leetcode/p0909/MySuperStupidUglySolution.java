package org.gd.leetcode.p0909;

import java.util.*;

class MySuperStupidUglySolution implements Solution {

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

        Queue q = new LinkedListQueueFactory().create(rows * cols * 6);
        q.add(startPoint());

        Point point;
        while ((point = q.poll()) != null) {

            if (point.isFinish())
                return point.steps;

            for (int i = 1; i <= 6 && point.position + i <= lastNumber; i++) {
                Point next = point.add(i);
                if (next != null) {

                    if (next.isFinish())
                        return next.steps;

                    q.add(next);
                }
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

        final int row, col, steps, position, redirect;

        Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;

            final int downRow = rows - 1 - this.row;
            if (downRow % 2 == 0) {
                position = (downRow * cols) + (col + 1);
            } else {
                position = (downRow * cols) + (cols - col);
            }
            redirect = (row >= 0 && row < rows && col >= 0 && col < cols) ? board[row][col] : -1;
        }

        @Override
        public int compareTo(Point o) {
            int compare = Integer.compare(steps(), o.steps());
            return compare != 0 ? compare : Integer.compare(o.position, position);
        }

        boolean isFinish() { return position >= lastNumber; }

        int steps() { return steps; }

        Point add(int value) { return next(position + value); }

        Point next(int position) {
            boolean redirect = false;
            while (true) {

                if (this.position == position)
                    return null;

                int downRow = ((position - 1) / cols);
                int row = (rows - 1) - ((position - 1) / cols);
                int col = position - (downRow * cols) - 1;
                if (downRow % 2 != 0)
                    col = cols - 1 - col;

                Point point = new Point(row, col, steps + 1);

                if (point.position == point.redirect || point.isFinish())
                    return point;

                if (!redirect && point.redirect >= 0) {
                    position = point.redirect;
                    redirect = true;
                    continue;
                }

                return point;
            }
        }

        @Override
        public String toString() {
            return "Point{" +
                    "" + String.format("%2d = (%d:%d)", position, row, col) +
                    ", steps=" + steps +
                    (redirect >= 0 ? ", redirect=" + redirect : "") +
                    '}';
        }
    }

    interface QueueFactory {

        Queue create(int capacity);

    }

    @Deprecated
    static class HeapQueueFactory implements QueueFactory {

        @Override
        public Queue create(int capacity) {
            return new QueueImpl(capacity);
        }

        static class QueueImpl implements Queue {

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

    static class LinkedListQueueFactory implements QueueFactory {

        @Override
        public Queue create(int capacity) {
            return new QueueImpl();
        }

        static class QueueImpl implements Queue {

            private final LinkedList<Point> q = new LinkedList<>();
            private final Set<Integer> set = new HashSet<>();

            @Override
            public Point poll() { return q.poll(); }

            @Override
            public void add(Point point) {
                if (set.contains(point.position))
                    return;
                q.add(point);
                set.add(point.position);
            }

            @Override
            public String toString() { return q.toString(); }
        }
    }

    @Deprecated
    static class TreeSetQueueFactory implements QueueFactory {

        @Override
        public Queue create(int capacity) {
            return new QueueImpl();
        }

        static class QueueImpl implements Queue {

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
