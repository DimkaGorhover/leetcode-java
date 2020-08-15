package org.gd.leetcode.p0209;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@LeetCode(
        name = "Minimum Size Subarray Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.TWO_POINTERS,
                LeetCode.Tags.BINARY_SEARCH
        }
)
class Solution {

    public int minSubArrayLen(int s, int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0] == s ? 1 : 0;

        int i = 0, j = 1;
        int sum = nums[0];
        int minLength = Integer.MAX_VALUE;

        while (j < nums.length) {

            if (i == j) {
                if (sum == s) return 1;
                j++;
                continue;
            }

            while (sum < s && j < nums.length)
                sum += nums[j++];

            while (sum >= s && i <= j) {
                minLength = Math.min(minLength, j - i);
                sum -= nums[i++];
            }
        }

        if (minLength == Integer.MAX_VALUE)
            return 0;

        return minLength;
    }
}
