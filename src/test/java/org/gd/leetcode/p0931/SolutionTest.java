package org.gd.leetcode.p0931;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p1289.SolutionTest
 * @since 2020-08-07
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #931: Minimum Falling Path Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, 12)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MinFallingPathSum")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MinFallingPathSum(int[][] A, int expected) {
        assertEquals(expected, new Solution().minFallingPathSum(copy(A)));
    }
}