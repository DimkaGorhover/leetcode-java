package org.gd.leetcode.p0307;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/range-sum-query-mutable/ [linear solution]
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
 * @see org.gd.leetcode.p0303.NumArray
 * @since 2019-09-18
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.MEDIUM, tags = {LeetCode.Tags.BINARY_INDEXED_TREE, LeetCode.Tags.SEGMENT_TREE})
class NumArray {

    private final int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while (i <= j)
            sum += nums[i++];
        return sum;
    }
}
