package org.gd.leetcode.p0070;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @see MemoizationSolution
 * @see DPSolution
 */
@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #70: Climbing Stairs")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(5, 8),
                Arguments.of(8, 34),
                Arguments.of(19, 6765),
                Arguments.of(44, 1_134_903_170)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Dynamic Programming")
    void dpSolution(int n, int expected) {
        assertEquals(expected, new DPSolution().climbStairs(n));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Memoization")
    void memoizationSolution(int n, int expected) {
        assertEquals(expected, new MemoizationSolution().climbStairs(n));
    }
}