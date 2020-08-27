package org.gd.leetcode.p0983;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-cost-for-tickets/
 */
@Repeat("stolen solution, dynamic programming")
@LeetCode(
        name = "Minimum Cost For Tickets",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.DYNAMIC_PROGRAMMING
)
class Solution {

    private static final int[] DURATIONS = {1, 7, 30};

    private int[] days, costs;
    private Integer[] memo;

    public int mincostTickets(int[] days, int[] costs) {

        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];

        return dp(0);
    }

    public int dp(int i) {
        if (i >= days.length)
            return 0;

        if (memo[i] != null)
            return memo[i];

        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {

            while (j < days.length && days[j] < days[i] + DURATIONS[k])
                j++;

            ans = Math.min(ans, dp(j) + costs[k]);
        }

        return memo[i] = ans;
    }
}
