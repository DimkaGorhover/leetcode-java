package org.gd.leetcode.p0542;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/01-matrix/
 */
@SuppressWarnings("SpellCheckingInspection")
@Repeat("FUUUUUCKING DYNAMIC PROGRAMMING")
@LeetCode(
        name = "01 Matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING,
                LeetCode.Tags.DEPTH_FIRST_SEARCH,
                LeetCode.Tags.BREADTH_FIRST_SEARCH
        }
)
interface Solution {

    int[][] updateMatrix(int[][] matrix);
}
