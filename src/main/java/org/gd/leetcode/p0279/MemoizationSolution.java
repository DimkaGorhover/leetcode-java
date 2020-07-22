package org.gd.leetcode.p0279;

class MemoizationSolution implements Solution {

    private int[] memo;

    private int numSquares0(final int n) {
        if (n <= 0) return 0;

        if (memo[n - 1] != 0)
            return memo[n - 1];

        int sum = Integer.MAX_VALUE;
        for (int i = 1, s = (i * i); s <= n; i++, s = (i * i))
            sum = Math.min(sum, 1 + numSquares0(n - s));

        return memo[n - 1] = sum;
    }

    @Override
    public int numSquares(final int n) {
        memo = new int[n];
        return numSquares0(n);
    }
}
