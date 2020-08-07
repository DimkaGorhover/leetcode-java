package org.gd.leetcode.p1289;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0931.Solution
 * @since 2020-08-07
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Minimum Falling Path Sum II",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
interface Solution {

    int minFallingPathSum(int[][] matrix);
}
