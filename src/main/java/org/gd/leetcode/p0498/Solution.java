package org.gd.leetcode.p0498;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/diagonal-traverse/
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in
 * the below image.
 *
 * @since 2019-09-14
 */
@LeetCode(
        name = "diagonal traverse",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO)
class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0)
            return new int[0];
        if (matrix.length == 1)
            return matrix[0];

        throw new UnsupportedOperationException(new String(new char[]{175, 92, 95, 40, 12_484, 41, 95, 47, 175}));
    }
}
