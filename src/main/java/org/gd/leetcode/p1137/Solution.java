package org.gd.leetcode.p1137;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * @see org.gd.leetcode.p0070.Solution
 * @see org.gd.leetcode.p0509.Solution
 */
@SuppressWarnings({"JavadocReference", "SpellCheckingInspection"})
@LeetCode(
        name = "N-th Tribonacci Number",
        difficulty = LeetCode.Level.EASY,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.RECURSION,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class Solution {

    public int tribonacci(int n) {
        if (n <= 0) return 0;
        if (n <= 2) return 1;

        int[] dp = {0, 1, 1};

        for (int i = dp.length; i <= n; i++)
            dp[i % dp.length] = dp[0] + dp[1] + dp[2];

        return dp[n % dp.length];
    }
}
