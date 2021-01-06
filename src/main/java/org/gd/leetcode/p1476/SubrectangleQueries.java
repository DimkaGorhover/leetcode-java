package org.gd.leetcode.p1476;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/subrectangle-queries/
 *
 * @author Horkhover D.
 * @since 2020-11-19
 */
@LeetCode(
        name = "Subrectangle Queries",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = LeetCode.Tags.ARRAY
)
class SubrectangleQueries {

    private final int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(final int row1,
                                   final int col1,
                                   final int row2,
                                   final int col2,
                                   final int newValue) {
        for (int row = row1; row < row2; row++) {
            for (int col = col1; col < col2; col++) {
                rectangle[row][col] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }
}
