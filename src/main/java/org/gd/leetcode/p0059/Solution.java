package org.gd.leetcode.p0059;

import org.gd.leetcode.common.LeetCode;

/**
 * TODO: https://leetcode.com/problems/spiral-matrix-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0054.Solution
 * @see org.gd.leetcode.p0885.Solution
 * @since 2018-11-20
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Spiral Matrix II",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public int[][] generateMatrix(int n) {
        if (n < 0) throw new IndexOutOfBoundsException();
        if (n == 0) return new int[0][0];
        if (n == 1) return new int[][]{{1}};
        if (n == 2) return new int[][]{{1, 2}, {4, 3}};

        final int size = n * n;
        final int mid = n >>> 1;
        final int[][] matrix = new int[n][n];

        int offset = 0;
        int counter = 0;
        while (offset <= mid) {

            for (int col = offset; col < n - offset && counter < size; col++)
                matrix[offset][col] = ++counter;

            for (int row = offset + 1; row < n - offset - 1 && counter < size; row++)
                matrix[row][n - offset - 1] = ++counter;

            for (int col = n - offset - 1; col >= offset && counter < size; col--)
                matrix[n - offset - 1][col] = ++counter;

            for (int row = n - offset - 2; row > offset && counter < size; row--)
                matrix[row][offset] = ++counter;

            offset++;
        }

        return matrix;
    }
}
