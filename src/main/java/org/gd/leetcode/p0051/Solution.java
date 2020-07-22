package org.gd.leetcode.p0051;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@LeetCode(
        name = "N-Queens",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.FIXME,
        tags = {
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private List<List<String>> result;
    private char[][] board;
    private boolean[] rowSet;
    private boolean[] colSet;
    private boolean[] diagonalSet;

    private void init(final int n) {
        result = new ArrayList<>(n);
        board = new char[n][n];

        for (int row = 0; row < n; row++)
            Arrays.fill(board[row], '.');

        rowSet = new boolean[n];
        colSet = new boolean[n];
        diagonalSet = new boolean[n];
    }

    private boolean canBePlaced(int row, int col) {
        return board[row][col] == '.'
                && !rowSet[row]
                && !colSet[col]
                && (row != col || diagonalSet[row]);
    }

    private void set(int row, int col) {
        board[row][col] = 'Q';
        rowSet[row] = colSet[col] = diagonalSet[row] = true;
    }

    private void reset(int row, int col) {
        board[row][col] = '.';
        rowSet[row] = colSet[col] = diagonalSet[row] = false;
    }

    private boolean solve(final int n) {

        if (n == 0)
            return true;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {

                if (canBePlaced(row, col)) {
                    set(row, col);

                    if (solve(n - 1))
                        return true;

                    reset(row, col);
                }

            }
        }

        return false;
    }

    public List<List<String>> solveNQueens(final int n) {
        init(n);
        solve(n);
        return result;
    }

    @Override
    public String toString() {
        int length = (board.length * board.length) << 1;
        StringBuilder sb = new StringBuilder(length);
        for (char[] chars : board) {
            sb.append(chars[0]);
            for (int col = 1; col < board.length; col++)
                sb.append(' ').append(chars[col]);
            sb.append('\n');
        }
        return sb.toString();
    }
}
