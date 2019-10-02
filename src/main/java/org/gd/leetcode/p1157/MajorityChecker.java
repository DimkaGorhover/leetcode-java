package org.gd.leetcode.p1157;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;

import static org.gd.leetcode.common.LeetCode.Level.HARD;
import static org.gd.leetcode.common.LeetCode.Tags.*;

/**
 * TODO: https://leetcode.com/problems/online-majority-element-in-subarray/
 *
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 * @see org.gd.common.SegmentTree
 * @since 2019-09-23
 */
@LeetCode(difficulty = HARD, tags = {ARRAY, BINARY_SEARCH, SEGMENT_TREE})
class MajorityChecker {

    private final Delegate delegate;

    public MajorityChecker(int[] arr) {
        delegate = new LinearDelegate(arr);
    }

    public int query(int left, int right, int threshold) {
        return delegate.query(left, right, threshold);
    }

    interface Delegate {

        int query(int left, int right, int threshold);
    }

    static class LinearDelegate implements Delegate {

        private final int[] arr;

        LinearDelegate(int[] arr) { this.arr = arr; }

        public int query(int left, int right, int threshold) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = left; i <= right; i++) {
                int number = arr[i];
                int count = map.compute(number, (ignore, c) -> (c == null ? 0 : c) + 1);
                if (count >= threshold)
                    return number;
            }
            return -1;
        }
    }
}
