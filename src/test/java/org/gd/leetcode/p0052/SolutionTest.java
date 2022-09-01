package org.gd.leetcode.p0052;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0051.SolutionTest
 * @since 2020-07-24
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #52: N-Queens II")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(5, 10)
        );
    }

    @ParameterizedTest(name = "{0} Queens -> expects {1} distinct solutions")
    @MethodSource("args")
    @DisplayName("TotalNQueens")
    void test_TotalNQueens(int n, int expected) {
        Solution solution = new Solution();
        assertEquals(expected, solution.totalNQueens(n));
    }
}
