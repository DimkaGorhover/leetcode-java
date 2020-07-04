package org.gd.leetcode.p0062;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * https://leetcode.com/problems/unique-paths/discuss/306448/O(min(m-%2B-n))-time-O(1)-space-solution
 *
 * @see org.gd.leetcode.p0064.Solution
 * @since 2019-10-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "unique paths",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        })
class Solution {

    private int dpUniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        if (m * n > 25 * 13)
            return dpUniquePaths(m, n);

        if (m > n)
            return uniquePaths(n, m);

        int downSteps = m - 1;
        int rightSteps = n - 1;
        int totalSteps = downSteps + rightSteps;

        long product = 1; // use long instead of int to avoid integer overflow
        for (int numTop = rightSteps + 1, numBot = 1; numTop <= totalSteps; numTop++, numBot++)
            product = product * numTop / numBot;

        return Math.toIntExact(product);
    }

}
