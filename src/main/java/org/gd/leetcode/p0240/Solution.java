package org.gd.leetcode.p0240;

import java.util.Arrays;

import org.gd.leetcode.common.Repeat;
import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * @see org.gd.leetcode.p0074.Solution
 * @see Arrays#binarySearch(int[], int)
 * @since 2019-09-10
 */
@SuppressWarnings("JavadocReference")
@Repeat("search value in 2d matrix")
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = {
                LeetCode.Tags.BINARY_SEARCH,
                LeetCode.Tags.DIVIDE_AND_CONQUER
        })
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0)
            return false;

        int cols = matrix.length;
        int rows = matrix[0].length;

        if ((matrix[0][0] > target) || (matrix[cols - 1][rows - 1] < target))
            return false;

        for (int col = 0, row = rows - 1; col < cols && row >= 0;) {
            if (matrix[col][row] == target) {
                return true;
            }
            if (matrix[col][row] < target) {
                col++;
            } else {
                row--;
            }
        }

        return false;
    }
}
