package org.gd.leetcode.p0036;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
@DisplayName("LeetCode #36: Valid Sudoku")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        new char[][]{
                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                        },
                        true
                ),
                arguments(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '.', '.', '.', '2'},
                                {'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                                {'.', '.', '1', '4', '.', '.', '8', '.', '.'},

                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '3', '.', '.', '.', '.'},

                                {'5', '.', '8', '6', '.', '.', '.', '.', '.'},
                                {'.', '9', '.', '.', '.', '.', '4', '.', '.'},
                                {'.', '.', '.', '.', '5', '.', '.', '.', '.'}
                        },
                        true
                ),
                arguments(
                        new char[][]{
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '3', '.', '.', '5', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

                                {'.', '.', '.', '8', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '1', '1', '6', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

                                {'.', '.', '.', '.', '.', '.', '1', '.', '.'},
                                {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                                {'.', '.', '.', '.', '.', '.', '.', '4', '.'}
                        },
                        false
                ),
                arguments(
                        new char[][]{
                                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},

                                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},

                                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
                        },
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("IsValidSudoku")
    void test_IsValidSudoku(char[][] board, boolean valid) {
        assertEquals(valid, new Solution().isValidSudoku(board));
    }

    @Test
    @DisplayName("number")
    void test_number() {
        for (int i = 0; i < Character.BYTES; i++) {
            char c = (char) i;
            if (!('1' <= c && c <= '9')) {
                assertEquals(-1, Solution.number(c));
            } else {
                assertEquals(c - '1', Solution.number(c));
            }
        }
        assertEquals(8, Solution.number('9'));
    }

    @Deprecated
    @Test
    @DisplayName("Pos")
    void test_Pos() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(pos(i, j) + " ");
            }
            System.out.println();
        }
    }

    static int pos(int i, int j) {
        i = i - (i / 3) * 3;
        j = j - (j / 3) * 3;
        return i * 3 + j;
    }
}


