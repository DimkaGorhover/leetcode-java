package org.gd.leetcode.p0435;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/non-overlapping-intervals/
 *
 * @see org.gd.leetcode.p0056.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Non-overlapping Intervals",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.GREEDY
        }
)
class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));

        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
