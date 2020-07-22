package org.gd.leetcode.p0037;

import org.gd.leetcode.common.LeetCode;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/sudoku-solver/
 *
 * @see org.gd.leetcode.p0036.Solution
 */
@SuppressWarnings("JavadocReference")
@LeetCode(
        difficulty = LeetCode.Level.HARD,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private char[][] board;

    private boolean[][] squareSet;
    private boolean[][] rowsSets;
    private boolean[][] colsSets;

    private static int toNumber(char c) { return ('1' <= c && c <= '9') ? c - '1' : -1; }

    private static char toChar(int value) { return (char) (value + '1'); }

    private static int indexSet(int row, int col) { return (row / 3) + (col / 3) * 3; }

    private boolean canBePlaced(int row, int col, int value) {
        return board[row][col] == '.'
                && !rowsSets[row][value]
                && !colsSets[col][value]
                && !squareSet[indexSet(row, col)][value];
    }

    private void set(int row, int col, int value) {
        board[row][col] = toChar(value);
        rowsSets[row][value] = true;
        colsSets[col][value] = true;
        squareSet[indexSet(row, col)][value] = true;
    }

    private void reset(int row, int col, int value) {
        board[row][col] = '.';
        rowsSets[row][value] = false;
        colsSets[col][value] = false;
        squareSet[indexSet(row, col)][value] = false;
    }

    private boolean solve() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] != '.')
                    continue;

                for (int value = 0; value < 9; value++) {
                    if (canBePlaced(row, col, value)) {

                        set(row, col, value);

                        if (solve())
                            return true;

                        reset(row, col, value);
                    }
                }

                return false;
            }
        }

        return true;
    }

    private void reset(char[][] board) {
        this.board = board;

        squareSet = new boolean[9][9];
        rowsSets = new boolean[9][9];
        colsSets = new boolean[9][9];

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                final int value = toNumber(board[row][col]);
                if (value >= 0)
                    set(row, col, value);
            }
        }
    }

    public void solveSudoku(char[][] board) {
        reset(board);
        solve();
    }

    @Override
    public String toString() {

        StringJoiner all = new StringJoiner("\n");
        all.add("-".repeat(25));

        for (int row = 0; row < 9; row++) {

            StringJoiner line = new StringJoiner(" ");
            line.add("|");

            for (int col = 0; col < 9; col++) {

                line.add("" + board[row][col]);

                if (col % 3 == 2) line.add("|");
            }

            String s = line.toString();
            all.add(s);
            if (row % 3 == 2)
                all.add("-".repeat(s.length()));
        }

        return all.toString();
    }
}
