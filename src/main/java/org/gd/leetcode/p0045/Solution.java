package org.gd.leetcode.p0045;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/jump-game-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0055.Solution
 * @see org.gd.leetcode.p1306.Solution
 * @since 2020-08-03
 */
@Repeat("this is not my solution :'( ")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Jump Game II",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.GREEDY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int jump(int[] nums) {

        if (nums == null)
            throw new NullPointerException();

        if (nums.length <= 1)
            return 0;

        int jumps = 0;
        int curEnd = 0;
        int curFarthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            curFarthest = Math.max(curFarthest, i + nums[i]);

            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }

        }
        return jumps;
    }
}
