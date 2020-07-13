package org.gd.leetcode.p0079;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-13.07.2020
 */
@DisplayName("LeetCode #79: Word Search")
class SolutionTest {

    private static Stream<Arguments> args() {

        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        return Stream.of(
                Arguments.of(board, "SEE", true),
                Arguments.of(board, "ABCCED", true),
                Arguments.of(board, "ABCB", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Exist")
    void test_Exist(char[][] board, String word, boolean expected) {
        boolean actual = new Solution().exist(board, word);
        assertEquals(expected, actual);
    }
}