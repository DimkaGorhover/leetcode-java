package org.gd.leetcode.p0189;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/rotate-array/
 */
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public void rotate(int[] nums, int k) {
        if (nums.length <= 0 || k == 0 || nums.length == k)
            return;
        k %= nums.length;
        final int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, tmp.length);
        for (int i = k - 1, j = 1; i >= 0; i--, j++)
            nums[i] = tmp[nums.length - j];
        if (nums.length - k > 0)
            System.arraycopy(tmp, 0, nums, k, nums.length - k);
    }
}
