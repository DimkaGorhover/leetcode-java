package org.gd.leetcode.p0057;

import org.gd.leetcode.common.LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/insert-interval/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0056.Solution
 * @since 2020-07-07
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Insert Interval",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        })
class Solution {

    private final SolutionProvider solution = SolutionProvider.simple();

    public int[][] insert(int[][] intervals, int[] newInterval) {
        return solution.insert(intervals, newInterval);
    }

    interface SolutionProvider {

        static SolutionProvider simple() {
            return ValidationSolutionProviderWrapper.of(new SimpleSolutionProvider());
        }

        static SolutionProvider heap() {
            return ValidationSolutionProviderWrapper.of(new HeapSolutionProvider());
        }

        int[][] insert(int[][] intervals, int[] newInterval);
    }

    static final class Utils {

        private Utils() { throw new UnsupportedOperationException(); }

        static int[][] trim(int[][] intervals, int length) {
            if (intervals.length == length)
                return intervals;

            int[][] arr = new int[length][];
            System.arraycopy(intervals, 0, arr, 0, length);
            return arr;
        }

        static int merge(int[][] intervals, int index, int[] interval) {
            if (intervals[index][1] >= interval[0]) {
                intervals[index][0] = Math.min(intervals[index][0], interval[0]);
                intervals[index][1] = Math.max(intervals[index][1], interval[1]);
            } else {
                intervals[++index] = interval;
            }
            return index;
        }
    }

    static class ValidationSolutionProviderWrapper implements SolutionProvider {

        private final SolutionProvider solutionProvider;

        private ValidationSolutionProviderWrapper(SolutionProvider solutionProvider) {
            this.solutionProvider = solutionProvider;
        }

        static ValidationSolutionProviderWrapper of(SolutionProvider solutionProvider) {
            if (solutionProvider instanceof ValidationSolutionProviderWrapper)
                return ((ValidationSolutionProviderWrapper) solutionProvider);
            return new ValidationSolutionProviderWrapper(solutionProvider);
        }

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (intervals == null) throw new NullPointerException("intervals");
            if (newInterval == null) throw new NullPointerException("newInterval");
            if (newInterval.length != 2) throw new IllegalArgumentException("newInterval");
            if (intervals.length == 0) return new int[][]{newInterval};

            return solutionProvider.insert(intervals, newInterval);
        }
    }

    static class HeapSolutionProvider implements SolutionProvider, Comparator<int[]> {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            Queue<int[]> q = new PriorityQueue<>(3, this);
            q.add(newInterval);
            int i = 0;
            if (i < intervals.length) q.add(intervals[i++]);
            if (i < intervals.length) q.add(intervals[i++]);

            int[][] newIntervals = new int[intervals.length + 1][];
            newIntervals[0] = q.poll();

            int[] interval;
            int j = 0;
            while ((interval = q.poll()) != null) {
                j = Utils.merge(newIntervals, j, interval);
                if (i < intervals.length) 
                    q.add(intervals[i++]);
            }

            return Utils.trim(newIntervals, j + 1);
        }

        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0], o2[0]);
        }
    }

    static class SimpleSolutionProvider implements SolutionProvider {

        @Override
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int i = 0, j = 0;
            int[][] newIntervals = new int[intervals.length + 1][];

            int[] interval = intervals[0];
            if (interval[0] < newInterval[0]) {
                newIntervals[0] = interval;
                i++;
            } else {
                newIntervals[0] = newInterval;
                newInterval = null;
            }

            while (i < intervals.length) {
                interval = intervals[i];
                if (newInterval != null && newInterval[0] <= interval[0]) {
                    interval = newInterval;
                    newInterval = null;
                } else {
                    i++;
                }
                j = Utils.merge(newIntervals, j, interval);
            }

            if (newInterval != null)
                j = Utils.merge(newIntervals, j, newInterval);

            return Utils.trim(newIntervals, j + 1);
        }
    }
}
