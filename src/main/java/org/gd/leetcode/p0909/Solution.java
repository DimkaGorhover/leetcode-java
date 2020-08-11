package org.gd.leetcode.p0909;

import org.gd.leetcode.common.LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

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

    int[][] board;
    int rows, cols, lastNumber;

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

        Queue<IPoint> q = new PriorityQueue<>(rows * cols * 6);
        q.add(startPoint());

        while (!q.isEmpty()) {

            IPoint point = q.poll();
            if (point.isFinish())
                return point.steps();

            int number = point.number();
            for (int i = 1; i <= 6 && number + i <= lastNumber; i++)
                q.add(point.add(i));
        }

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    Point startPoint() {
        return new Point(rows - 1, 0, 0);
    }

    interface IPoint extends Comparable<IPoint> {

        boolean isFinish();

        int steps();

        int number();

        IPoint add(int value);

        @Override
        default int compareTo(IPoint o) {
            int compare = Integer.compare(steps(), o.steps());
            return compare != 0 ? compare : Integer.compare(o.number(), number());
        }
    }

    class Point implements IPoint {

        final int row, col, steps;

        Point(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }

        @Override
        public int number() {
            final int downRow = rows - 1 - this.row;
            if (downRow % 2 == 0) {
                return (downRow * cols) + (col + 1);
            } else {
                return (downRow * cols) + (cols - col);
            }
        }

        @Override
        public IPoint add(int value) { return next(number() + value); }

        @Override
        public boolean isFinish() { return number() >= lastNumber; }

        @Override
        public int steps() { return steps; }

        private int value() { return isFinish() ? -1 : board[row][col]; }

        Point next(int value) {
            while (true) {
                final int row = (rows - 1) - ((value - 1) / cols);
                final int col;
                if (row % 2 == 0) {
                    col = cols - ((value - 1) % cols) - 1;
                } else {
                    col = (value - 1) % cols;
                }

                Point point = new Point(row, col, steps + 1);
                if (point.isFinish())
                    return point;

                if (point.value() >= 0) {
                    value = point.value();
                    continue;
                }

                return point;
            }
        }
    }
}
