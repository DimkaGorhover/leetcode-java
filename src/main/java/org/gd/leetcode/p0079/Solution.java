package org.gd.leetcode.p0079;

import org.gd.leetcode.common.LeetCode;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/word-search/
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0212.Solution
 * @since 2020-07-13
 */
@SuppressWarnings({"RedundantIfStatement", "JavadocReference"})
@LeetCode(
        name = "Word Search",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY,
                LeetCode.Tags.BACKTRACKING
        }
)
class Solution {

    private static final char VISITED = 0;

    private char[][] board;
    private int rows, cols;

    private boolean exist(final String word,
                          final int charIndex,
                          final int row,
                          final int col) {

        if (charIndex == word.length()) return true;
        char c = word.charAt(charIndex);

        // up
        if (row > 0 && board[row - 1][col] == c) {
            board[row - 1][col] = VISITED;
            boolean result = exist(word, charIndex + 1, row - 1, col);
            board[row - 1][col] = c;
            if (result) return true;
        }

        // down
        if (row < rows - 1 && board[row + 1][col] == c) {
            board[row + 1][col] = VISITED;
            boolean result = exist(word, charIndex + 1, row + 1, col);
            board[row + 1][col] = c;
            if (result) return true;
        }

        // left
        if (col > 0 && board[row][col - 1] == c) {
            board[row][col - 1] = VISITED;
            boolean result = exist(word, charIndex + 1, row, col - 1);
            board[row][col - 1] = c;
            if (result) return true;
        }

        // right
        if (col < cols - 1 && board[row][col + 1] == c) {
            board[row][col + 1] = VISITED;
            boolean result = exist(word, charIndex + 1, row, col + 1);
            board[row][col + 1] = c;
            if (result) return true;
        }

        return false;
    }

    private void reset(char[][] board) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
    }

    public boolean exist(char[][] board, String word) {
        reset(board);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char c = word.charAt(0);
                if (board[row][col] == c) {
                    board[row][col] = VISITED;
                    boolean result = exist(word, 1, row, col);
                    board[row][col] = c;
                    if (result) return true;
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
                if (board[row][col] == VISITED)
                    sj.add(String.format("(%d;%d)", row, col));
            }
        }
        return sj.toString();
    }
}
