package org.gd.leetcode.p0300;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * @author Horkhover Dmytro
 * @since 2022-01-14
 */
@LeetCode(
        name = "Longest Increasing Subsequence",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] <= nums[1] ? 2 : 1;
        }

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
