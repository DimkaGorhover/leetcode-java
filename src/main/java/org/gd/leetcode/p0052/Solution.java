package org.gd.leetcode.p0052;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/n-queens-ii/
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0051.Solution
 * @since 2020-07-24
 */
@SuppressWarnings({"JavadocReference", "DuplicatedCode"})
@LeetCode(
        name = "N-Queens II",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private int n, result;
    private int[] positions;
    private boolean[] rowSet, colSet;

    private boolean canBePlaced(int row, int col) {
        if (row == 0)
            return true;

        if (rowSet[row] || colSet[col])
            return false;

        for (int row1 = 0; row1 < row; row1++) {
            int col1 = positions[row1];
            if (col == col1 || Math.abs(col - col1) == Math.abs(row - row1))
                return false;
        }

        return true;
    }

    private void set(int row, int col) {
        rowSet[row] = colSet[col] = true;
        positions[row] = col;
    }

    private void reset(int row, int col) {
        rowSet[row] = colSet[col] = false;
    }

    private void solve(final int row) {

        if (row == n) {
            result++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (canBePlaced(row, col)) {
                set(row, col);
                solve(row + 1);
                reset(row, col);
            }
        }
    }

    public int totalNQueens(final int n) {
        if (n <= 0)
            return 0;

        this.n = n;
        result = 0;
        positions = new int[n];
        rowSet = new boolean[n];
        colSet = new boolean[n];

        solve(0);

        return result;
    }
}
