package org.gd.leetcode.p0056;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/merge-intervals/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0057.Solution
 * @see org.gd.leetcode.p0435.Solution
 * @since 2020-07-06
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Merge Intervals",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.SORT
        })
class Solution {

    private static void sort(int[][] intervals) {
        boolean result = true;
        for (int next = 1, prev = 0; next < intervals.length; next++, prev++) {
            int[] prevInterval = intervals[prev];
            if (prevInterval[0] > intervals[next][0]) {
                intervals[prev] = intervals[next];
                intervals[next] = prevInterval;
                result = false;
                break;
            }
        }

        if (!result)
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    }

    private static int[][] trim(int[][] intervals, int length) {
        if (intervals.length == length)
            return intervals;

        int[][] arr = new int[length][];
        System.arraycopy(intervals, 0, arr, 0, length);
        return arr;
    }

    public int[][] merge(int[][] intervals) {

        if (intervals == null)
            throw new NullPointerException();

        if (intervals.length <= 1)
            return intervals;

        sort(intervals);

        int[][] mergedIntervals = new int[intervals.length][];
        int j = 0;
        mergedIntervals[j] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (mergedIntervals[j][1] >= intervals[i][0]) {
                mergedIntervals[j][1] = Math.max(mergedIntervals[j][1], intervals[i][1]);
            } else {
                mergedIntervals[++j] = intervals[i];
            }
        }

        return trim(mergedIntervals, j + 1);
    }
}
