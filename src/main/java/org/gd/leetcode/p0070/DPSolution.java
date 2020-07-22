package org.gd.leetcode.p0070;

/**
 * @see MemoizationSolution
 */
class DPSolution implements Solution {

    @Override
    public int climbStairs(int n) {
        if (n < 1)
            return 0;

        final int[] dp = new int[]{1, 2};

        for (int i = dp.length; i < n; i++)
            dp[i % dp.length] = dp[0] + dp[1];

        return dp[(n - 1) % dp.length];
    }
}
