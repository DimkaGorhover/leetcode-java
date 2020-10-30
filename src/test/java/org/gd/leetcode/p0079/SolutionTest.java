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
 * @since 2020-07-13
 */
@DisplayName("LeetCode #79: Word Search")
class SolutionTest {

    private static Stream<Arguments> args() {

        final char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        return Stream
                .of(new SingletonSolutionFactory(), new PrototypeSolutionFactory())
                .flatMap(sf -> Stream.of(
                        Arguments.of(sf, board, "ABCCED", true),
                        Arguments.of(sf, board, "SEE", true),
                        Arguments.of(sf, board, "ABCB", false)
                ));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Exist")
    void test_Exist(SolutionFactory sf, char[][] board, String word, boolean expected) {
        assertEquals(expected, sf.get().exist(board, word));
    }

}