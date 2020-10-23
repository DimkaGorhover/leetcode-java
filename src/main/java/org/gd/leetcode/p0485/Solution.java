package org.gd.leetcode.p0485;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/max-consecutive-ones/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p1004.Solution
 * @since 2020-10-23
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "Max Consecutive Ones",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.TODO,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;
        for (int value : nums) {
            if (value != 0) {
                max = Math.max(max, ++count);
            } else {
                count = 0;
            }
        }
        return max;
    }
}
