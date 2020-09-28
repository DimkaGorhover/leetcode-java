package org.gd.leetcode.p0713;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
@LeetCode(
        name = "Subarray Product Less Than K",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS
        }
)
class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (nums == null || nums.length == 0)
            return 0;

        int sum = 0;
        for (int i = 0, j = 0, p = 1; j < nums.length; j++) {

            p *= nums[j];

            while (p >= k && i < j)
                p /= nums[i++];

            if (p < k)
                sum += j - i + 1;
        }

        return sum;
    }
}
