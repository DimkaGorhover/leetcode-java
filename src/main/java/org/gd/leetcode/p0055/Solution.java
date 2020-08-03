package org.gd.leetcode.p0055;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/jump-game/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0045.Solution
 * @see org.gd.leetcode.p1306.Solution
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Jump Game",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.GREEDY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {
    
    public boolean canJump(int[] nums) {
        if (nums == null) throw new NullPointerException();
        if (nums.length <= 1) return true;

        int max = nums[0];
        for (int i = 1; i < nums.length - 1 && max > 0; i++)
            max = Math.max(max - 1, nums[i]);

        return max > 0;
    }
}
