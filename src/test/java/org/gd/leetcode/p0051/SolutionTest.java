package org.gd.leetcode.p0051;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0052.Solution
 * @since 2020-07-22
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #51: N-Queens")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(4, java.util.Arrays.asList(
                        java.util.Arrays.asList(
                                ".Q..",
                                "...Q",
                                "Q...",
                                "..Q."
                        ),
                        java.util.Arrays.asList(
                                "..Q.",
                                "Q...",
                                "...Q",
                                ".Q.."
                        )
                ))
        );
    }

    @ParameterizedTest(name = "{0} Queens")
    @MethodSource("args")
    @DisplayName("SolveNQueens")
    void test_SolveNQueens(int n, List<List<String>> expected) {

        assertEquals(
                new HashSet<>(expected),
                new HashSet<>(new Solution().solveNQueens(n))
        );
    }
}