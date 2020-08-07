package org.gd.leetcode.p0136;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/single-number/
 *
 * @author Horkhover Dmytro
 * @see org.gd.hackerrank.other.LonelyInteger
 * @see org.gd.leetcode.p0137.Solution
 * @since 2018-12-19
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Single Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BIT_MANIPULATION,
                LeetCode.Tags.HASH_TABLE
        }
)
class Solution {

    public int singleNumber(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[0] ^= nums[i];
        return nums[0];
    }
}
