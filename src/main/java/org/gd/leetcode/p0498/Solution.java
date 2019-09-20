package org.gd.leetcode.p0498;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/diagonal-traverse/
 *
 * Given a matrix of M x N elements (M rows, N columns),
 * return all elements of the matrix in diagonal order as shown in the below image.
 *
 * Example:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 *
 * Output:  [1,2,4,7,5,3,6,8,9]
 *
 * @since 2019-09-14
 */
@LeetCode(difficulty = LeetCode.Level.MEDIUM)
class Solution {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        if (matrix.length == 0)
            return new int[0];
        if (matrix.length == 1)
            return matrix[0];

        throw new UnsupportedOperationException(new String(new char[]{ 175, 92, 95, 40, 12_484, 41, 95, 47, 175 }));
    }
}
