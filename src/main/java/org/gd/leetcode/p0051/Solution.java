package org.gd.leetcode.p0051;

import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/n-queens/
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@LeetCode(
        name = "N-Queens",
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private List<List<String>> result;

    private char[][] board;

    private int[] positions;
    private boolean[] rowSet, colSet;

    private boolean canBePlaced(int row, int col) {
        if (row == 0)
            return true;

        if (rowSet[row] || colSet[col])
            return false;

        for (int row1 = 0; row1 < row; row1++) {
            int col1 = positions[row1];
            if (Math.abs(col - col1) == Math.abs(row - row1))
                return false;
        }

        return true;
    }

    private void set(int row, int col) {
        board[row][col] = 'Q';
        rowSet[row] = colSet[col] = true;
        positions[row] = col;
    }

    private void reset(int row, int col) {
        board[row][col] = '.';
        rowSet[row] = colSet[col] = false;
    }

    private void solve(final int row) {

        if (row == board.length) {

            ArrayList<String> list = new ArrayList<>(board.length);
            for (char[] chars : board)
                list.add(new String(chars));
            result.add(list);

            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (canBePlaced(row, col)) {
                set(row, col);
                solve(row + 1);
                reset(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(final int n) {
        if (n <= 0)
            throw new IllegalArgumentException();

        result = new ArrayList<>(n);
        board = new char[n][n];
        positions = new int[n];
        rowSet = new boolean[n];
        colSet = new boolean[n];

        for (int row = 0; row < n; row++)
            Arrays.fill(board[row], '.');

        solve(0);

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
