package org.gd.leetcode.p0509;

class DPSolution implements Solution {

    @Override
    public int fib(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;

        int[] dp = {1, 2};

        for (int i = 4; i <= n; i++)
            dp[i % dp.length] = dp[0] + dp[1];

        return dp[n % dp.length];
    }
}
