package org.gd.leetcode.p0064;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 *
 * @see org.gd.leetcode.p0062.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Minimum Path Sum",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
interface Solution {

    int minPathSum(int[][] grid);
}
