package org.gd.leetcode.p0037;

import org.junit.jupiter.api.*;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #37: Sudoku Solver")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @Test
    void solveSudoku() {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        Solution solution = new Solution();
        solution.solveSudoku(board);

        System.out.println(solution.toString());

    }
}