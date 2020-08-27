package org.gd.leetcode.p0436;

import org.gd.leetcode.common.LeetCode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-right-interval/
 *
 * <p>Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is
 * bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.</p>
 *
 * <p>For any interval i, you need to store the minimum interval j's index, which means that the interval j has the
 * minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for
 * the interval i. Finally, you need output the stored value of each interval as an array.</p>
 *
 * Note:
 * <ul>
 * <li>You may assume the interval's end point is always bigger than its start point.</li>
 * <li>You may assume none of these intervals have the same start point.</li>
 * </ul>
 *
 * @author Horkhover Dmytro
 * @since 2020-08-27
 */
@LeetCode(
        name = "Find Right Interval",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.BINARY_SEARCH
)
class Solution {

    private static int binarySearch0(Interval[] a, int from, int to, int key) {

        if (from == a.length)
            return -1;

        int low = from, high = to - 1, mid;
        while (low <= high) {
            Interval midVal = a[mid = (low + high) >>> 1];
            if (midVal.left < key)
                low = mid + 1;
            else if (midVal.left > key)
                high = mid - 1;
            else
                return midVal.pos;
        }

        return low < a.length ? a[low].pos : -1;
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return new int[0];
        if (intervals.length == 1)
            return new int[]{-1};

        Interval[] arr = new Interval[intervals.length];
        for (int i = 0; i < intervals.length; i++)
            arr[i] = new Interval(i, intervals[i]);

        Arrays.sort(arr);

        int[] result = new int[intervals.length];
        for (int i = 0; i < arr.length; i++) {
            Interval interval = arr[i];
            result[interval.pos] = binarySearch0(arr, i + 1, arr.length, interval.right);
        }

        return result;
    }

    static class Interval implements Comparable<Interval> {

        final int pos, left, right;

        public Interval(int pos, int[] interval) {
            this.pos = pos;
            this.left = interval[0];
            this.right = interval[1];
        }

        @Override
        public int compareTo(Interval o) {
            return Integer.compare(left, o.left);
        }

        @Override
        public String toString() {
            return String.format("%d [%d,%d]", pos, left, right);
        }
    }
}
