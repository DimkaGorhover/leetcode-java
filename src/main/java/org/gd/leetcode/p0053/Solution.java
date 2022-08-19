package org.gd.leetcode.p0053;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-subarray/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0121.Solution
 * @see org.gd.leetcode.p0152.Solution
 * @see org.gd.leetcode.p1186.Solution
 * @since 2020-06-30
 */
@SuppressWarnings("JavadocReference")
@Repeat("fucking dynamic programming")
@LeetCode(
        name = "Maximum SubArray",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DIVIDE_AND_CONQUER
        })
class Solution {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max0 = nums[0];
        int max1 = nums[0];
        for (int i = 1, n = nums.length; i < n; i++) {
            max1 = Math.max(max1 + nums[i], nums[i]);
            max0 = Math.max(max0, max1);
        }
        return max0;
    }
}
