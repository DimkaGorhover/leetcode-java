package org.gd.leetcode.p0062;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/unique-paths/
 *
 * https://leetcode.com/problems/unique-paths/discuss/22958/Math-solution-O(1)-space
 *
 * https://betterexplained.com/articles/easy-permutations-and-combinations/
 *
 * @see org.gd.leetcode.p0064.Solution
 * @since 2019-10-03
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Unique Paths",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        })
class Solution {

    private static final int PERMUTATION_THRESHOLD = 25 * 13;

    private static int dpUniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    /**
     * This is a combinatorial problem and can be solved without DP. For mxn grid, robot has to move exactly m-1 steps
     * down and n-1 steps right and these can be done in any order.
     *
     * For the eg., given in question, 3x7 matrix, robot needs to take 2+6 = 8 steps with 2 down and 6 right in any
     * order. That is nothing but a permutation problem. Denote down as 'D' and right as 'R', following is one of the
     * path :-
     *
     * D R R R D R R R
     *
     * We have to tell the total number of permutations of the above given word. So, decrease both m & n by 1 and apply
     * following formula:-
     *
     * Total permutations = (m + n)! / (m! * n!)
     */
    private static int permutations(int m, int n) {
        final int downSteps = m - 1;
        final int rightSteps = n - 1;
        final int totalSteps = downSteps + rightSteps;

        long product = 1; // use long instead of int to avoid integer overflow
        for (int numTop = rightSteps + 1, numBot = 1; numTop <= totalSteps; numTop++, numBot++) {
            product = product * numTop / numBot;
        }

        return Math.toIntExact(product);
    }

    public int uniquePaths(int m, int n) {
        if (n <= 0)
            throw new IllegalArgumentException("n");
        if (m <= 0)
            throw new IllegalArgumentException("m");

        if (m == 1 || n == 1)
            return 1;

        if (m * n <= PERMUTATION_THRESHOLD)
            return permutations(Math.min(m, n), Math.max(m, n));

        return dpUniquePaths(m, n);
    }
}
