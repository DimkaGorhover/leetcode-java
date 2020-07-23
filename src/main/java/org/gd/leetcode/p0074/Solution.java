package org.gd.leetcode.p0074;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0240.Solution
 * @since 2020-07-23
 */
@LeetCode(
        name = "Search a 2D Matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BINARY_SEARCH,
        }
)
@SuppressWarnings("JavadocReference")
interface Solution {

    boolean searchMatrix(int[][] matrix, int target);
}
