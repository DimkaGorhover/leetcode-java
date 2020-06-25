package org.gd.leetcode.p0189;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/rotate-array/
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * 
 * Follow up:
 * 1. Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 2. Could you do it in-place with O(1) extra space?
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
