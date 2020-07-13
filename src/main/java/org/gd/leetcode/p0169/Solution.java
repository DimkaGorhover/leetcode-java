package org.gd.leetcode.p0169;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/majority-element/
 */
@LeetCode(
        name = "Majority Element",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DIVIDE_AND_CONQUER,
                LeetCode.Tags.BIT_MANIPULATION
        }
)
interface Solution {

    int majorityElement(int[] nums);
}
