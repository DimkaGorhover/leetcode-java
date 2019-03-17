package org.gd.leetcode.p0036;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/valid-sudoku/
 */
@LeetCode(
        difficulty = LeetCode.Level.MEDIUM,
        tags = LeetCode.Tags.HASH_TABLE)
class Solution {

    @Deprecated
    static int pos(int i, int j) {
        i = i - (i / 3) * 3;
        j = j - (j / 3) * 3;
        return i * 3 + j;
    }

    static int number(char c) { return ('1' <= c && c <= '9') ? c - '1' : -1; }

    private static boolean linearSolution(char[][] board) {
        final boolean[][][] kSet = new boolean[3][3][9];
        for (int i = 0, n; i < 9; i++) {
            final boolean[] rowSet = new boolean[9], colSet = new boolean[9];
            for (int j = 0; j < 9; j++) {
                final boolean[] set = kSet[i / 3][j / 3];
                if ((n = number(board[i][j])) >= 0) {
                    if (rowSet[n] || set[n])
                        return false;
                    set[n] = rowSet[n] = true;
                }
                if ((n = number(board[j][i])) >= 0) {
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
