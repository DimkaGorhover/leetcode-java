package org.gd.leetcode.p0304;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * @see org.gd.leetcode.p0303.NumArray
 * @since 2019-09-13
 */
@Repeat("Calc sum from range in 2d matrix")
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Range Sum Query 2D - Immutable",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DYNAMIC_PROGRAMMING
        }
)
class NumMatrix implements Solution {

    private final Solution solution;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            solution = EmptySolution.INSTANCE;
        } else if (matrix.length == 1) {
            solution = new SingleRowSolution(matrix[0]);
        } else {
            solution = new DynamicProgrammingSolution(matrix);
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return solution.sumRegion(row1, col1, row2, col2);
    }
}
