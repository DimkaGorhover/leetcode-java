package org.gd.leetcode.p0303;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 *
 * @see org.gd.leetcode.p0304.NumMatrix
 * @since 2019-09-13
 */
@SuppressWarnings("JavadocReference")
@LeetCode(difficulty = LeetCode.Level.EASY, tags = {LeetCode.Tags.DYNAMIC_PROGRAMMING})
class NumArray {

    private final int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        for (int i = 0, sum = 0; i < nums.length; i++)
            sums[i] = (sum += nums[i]);
    }

    public int sumRange(int i, int j) { return sums[j] - (i == 0 ? 0 : sums[i - 1]); }
}
