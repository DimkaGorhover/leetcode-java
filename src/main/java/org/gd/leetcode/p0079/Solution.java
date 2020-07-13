package org.gd.leetcode.p0079;

import org.gd.leetcode.common.LeetCode;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/word-search/
 *
 * @author Horkhover D.
 * @since 2020-07-13.07.2020
 */
@LeetCode(
        name = "Word Search",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.TODO,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private char[][] board;
    private boolean[][] arr;
    int rows, cols;

    private boolean exist(final String word,
                          final int charIndex,
                          final int row,
                          final int col) {

        if (charIndex == word.length())
            return true;

        char c = word.charAt(charIndex);

        // up
        if (row > 0 && !arr[row - 1][col] && board[row - 1][col] == c) {
            arr[row - 1][col] = true;
            if (exist(word, charIndex + 1, row - 1, col)) {
                return true;
            } else {
                arr[row - 1][col] = false;
            }
        }

        // down
        if (row < rows - 1 && !arr[row + 1][col] && board[row + 1][col] == c) {
            arr[row + 1][col] = true;
            if (exist(word, charIndex + 1, row + 1, col)) {
                return true;
            } else {
                arr[row + 1][col] = false;
            }
        }

        // left
        if (col > 0 && !arr[row][col - 1] && board[row][col - 1] == c) {
            arr[row][col - 1] = true;
            if (exist(word, charIndex + 1, row, col - 1)) {
                return true;
            } else {
                arr[row][col - 1] = false;
            }
        }

        // right
        if (col < cols - 1 && !arr[row][col + 1] && board[row][col + 1] == c) {
            arr[row][col + 1] = true;
            if (exist(word, charIndex + 1, row, col + 1)) {
                return true;
            } else {
                arr[row][col + 1] = false;
            }
        }


        return false;
    }

    private void reset(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        arr = new boolean[rows][cols];
    }

    public boolean exist(char[][] board, String word) {
        reset(board);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == word.charAt(0)) {
                    arr[row][col] = true;
                    if (exist(word, 1, row, col)) {
                        return true;
                    } else {
                        arr[row][col] = false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("->", "[", "]");
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (arr[row][col])
                    sj.add(String.format("(%d;%d)", row, col));
            }
        }
        return sj.toString();

    }
}
