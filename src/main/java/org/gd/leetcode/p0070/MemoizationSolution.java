package org.gd.leetcode.p0070;

/**
 * @see DPSolution
 */
class MemoizationSolution implements Solution {

    private final int[] memo = new int[46];

    MemoizationSolution() {
        memo[1] = 1;
        memo[2] = 2;
    }

    public int climbStairs(int n) {
        if (n < 1) return 0;

        return memo[n] != 0
                ? memo[n]
                : (memo[n] = climbStairs(n - 2) + climbStairs(n - 1));
    }
}
