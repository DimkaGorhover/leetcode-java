package org.gd.leetcode.p0628;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * @see org.gd.leetcode.p0053.Solution
 * @see org.gd.leetcode.p0152.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Maximum Product Of Three Numbers",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.MATH
        })
class Solution {

    public int maximumProduct(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        switch (nums.length) {
            case 1: return nums[0];
            case 2: return nums[0] * nums[1];
            case 3: return nums[0] * nums[1] * nums[2];
        }

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min2) {
                min2 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            }
            if (num > max3) {
                max3 = num;
            }
            if (num > max2) {
                max3 = max2;
                max2 = num;
            }
            if (num > max1) {
                max2 = max1;
                max1 = num;
            }
        }

        return Math.max((min1 * min2 * max1), (max3 * max2 * max1));
    }
}