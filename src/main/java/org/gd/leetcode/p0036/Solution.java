package org.gd.leetcode.p0036;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/valid-sudoku/
 *
 * @see org.gd.leetcode.p0037.Solution
 */
@SuppressWarnings({"JavadocReference"})
@LeetCode(
        name = "Valid Sudoku",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE
        })
class Solution {

    static int number(char c) { return ('1' <= c && c <= '9') ? c - '1' : -1; }

    private static int indexSet(int row, int col) { return (row / 3) + (col / 3) * 3; }

    private static boolean linearSolution(char[][] board) {

        final boolean[][] kSet = new boolean[9][9];

        for (int row = 0, n; row < 9; row++) {

            final boolean[] rowSet = new boolean[9], colSet = new boolean[9];

            for (int col = 0; col < 9; col++) {

                final boolean[] set = kSet[indexSet(row, col)];

                if ((n = number(board[row][col])) >= 0) {
                    if (rowSet[n] || set[n])
                        return false;
                    set[n] = rowSet[n] = true;
                }

                if ((n = number(board[col][row])) >= 0) {
                    if (colSet[n])
                        return false;
                    colSet[n] = true;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return linearSolution(board);
    }
}
