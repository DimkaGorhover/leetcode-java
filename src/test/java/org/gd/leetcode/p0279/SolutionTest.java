package org.gd.leetcode.p0279;

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
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode 279: Perfect Squares")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(13, 2),
                Arguments.of(56, 3),
                Arguments.of(192, 3)
        );
    }

    @ParameterizedTest(name = "n = {0}, expected perfect squares = {1}")
    @MethodSource("args")
    @DisplayName("MathSolution")
    void test_MathSolution(int n, int expected) {
        assertEquals(expected, new MathSolution().numSquares(n));
    }

    @ParameterizedTest(name = "n = {0}, expected perfect squares = {1}")
    @MethodSource("args")
    @DisplayName("MemoizationSolution")
    void test_MemoizationSolution(int n, int expected) {
        assertEquals(expected, new MemoizationSolution().numSquares(n));
    }
}