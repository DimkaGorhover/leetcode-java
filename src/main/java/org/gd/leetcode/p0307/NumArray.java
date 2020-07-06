package org.gd.leetcode.p0307;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/range-sum-query-mutable/ [linear solution]
 *
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The {@link #update(int, int)} function modifies nums by updating the element at index i to val.
 *
 * Note:
 *
 * The array is only modifiable by the update function. You may assume the number of calls to {@link #update(int, int)}
 * and {@link #sumRange(int, int)} function is distributed evenly.
 *
 * @see org.gd.common.SegmentTree
 * @see org.gd.leetcode.p0303.NumArray
 * @since 2019-09-18
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "range sum query mutable",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.BINARY_INDEXED_TREE,
                LeetCode.Tags.SEGMENT_TREE
        })
class NumArray {

    private final int[] arr;

    public NumArray(int[] nums) {
        this.arr = nums;
    }

    public void update(int i, int val) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }

    public int sumRange(int i, int j) {
        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
