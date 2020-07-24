package org.gd.leetcode.p0052;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0051.SolutionTest
 * @since 2020-07-24
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #52: N-Queens II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(5, 10)
        );
    }

    @ParameterizedTest(name = "{0} Queens -> expects {1} distinct solutions")
    @MethodSource("args")
    @DisplayName("TotalNQueens")
    void test_TotalNQueens(final int n, final int expected) {
        assertEquals(expected, new Solution().totalNQueens(n));
    }
}