package org.gd.leetcode.p0419;

import org.gd.leetcode.common.LeetCode;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-02
 */
@LeetCode(
        name = "Battleships in a Board",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.ARRAY
        }
)
class Solution {

    public int countBattleships(char[][] board) {
        final int rows;
        final int cols;
        if (board == null || (rows = board.length) == 0 || (cols = board[0].length) == 0)
            return 0;

        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == '.' || (row > 0 && board[row - 1][col] == board[row][col]))
                    continue;

                count++;
                while (col < cols && board[row][col] != '.')
                    col++;

            }
        }

        return count;
    }
}
