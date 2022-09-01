package org.gd.leetcode.p0746;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @see org.gd.leetcode.p0070.Solution
 */
@SuppressWarnings("JavadocReference")
@Repeat("DYNAMIC_PROGRAMMING")
@LeetCode(
        name = "Min Cost Climbing Stairs",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int f1 = 0, f2 = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int f0 = cost[i] + Math.min(f1, f2);
            f2 = f1;
            f1 = f0;
        }
        return Math.min(f1, f2);
    }
}
