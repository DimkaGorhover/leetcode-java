package org.gd.leetcode.p0152;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/maximum-product-subarray/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0053.Solution
 * @since 2020-06-30
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    @SuppressWarnings("DuplicatedCode")
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int max0 = nums[0];
        int max1 = nums[0];
        int sign = nums[0] > 0 ? 1 : -1;
        int maxAbs = Math.abs(nums[0]);

        for (int i = 1, n = nums.length; i < n; i++) {

            int num = nums[i];

            if (num < 0)
                sign = -sign;
            maxAbs = Math.max(Math.abs(maxAbs * num), Math.abs(num));

            max1 = Math.max(max1 * num, num);
            max0 = Math.max(max0, max1);
        }

        if (sign > 0)
            return maxAbs;

        return max0;
    }
}
