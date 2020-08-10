package org.gd.leetcode.p0054;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0059.Solution
 * @see org.gd.leetcode.p0885.Solution
 * @since 2018-11-20
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        name = "Spiral Matrix",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        final int rows, cols;
        if (matrix == null || (rows = matrix.length) == 0 || (cols = matrix[0].length) == 0)
            return Collections.emptyList();

        if (rows == 1) {
            ArrayList<Integer> result = new ArrayList<>(cols);
            for (int col = 0; col < cols; col++)
                result.add(matrix[0][col]);
            return result;
        }

        if (cols == 1) {
            ArrayList<Integer> result = new ArrayList<>(rows);
            for (int row = 0; row < rows; row++)
                result.add(matrix[row][0]);
            return result;
        }

        ArrayList<Integer> result = new ArrayList<>(rows * cols);

        int upRow = 0;
        int downRow = rows - 1;
        int leftCol = 0;
        int rightCol = cols - 1;

        while (upRow <= downRow && leftCol <= rightCol) {

            // left --> right
            for (int col = leftCol; col <= rightCol; col++)
                result.add(matrix[upRow][col]);

            if (upRow == downRow)
                break;

            // up --> down
            for (int row = upRow + 1; row <= downRow - 1; row++)
                result.add(matrix[row][rightCol]);

            // right --> left
            for (int col = rightCol; col >= leftCol; col--)
                result.add(matrix[downRow][col]);

            if (leftCol == rightCol)
                break;

            // down --> up
            for (int row = downRow - 1; row >= upRow + 1; row--)
                result.add(matrix[row][leftCol]);

            upRow++;
            downRow--;

            leftCol++;
            rightCol--;
        }

        return result;
    }
}
