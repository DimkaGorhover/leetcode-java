package org.gd.leetcode.p1137;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@SuppressWarnings("SpellCheckingInspection")
@DisplayName("LeetCode #1137: N-th Tribonacci Number")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 4),
                Arguments.of(5, 7),
                Arguments.of(6, 13),
                Arguments.of(7, 24),
                Arguments.of(8, 44),
                Arguments.of(9, 81)
        );
    }

    @ParameterizedTest(name = "tribonacci({0}) = {1}")
    @MethodSource("args")
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void tribonacci(int n, int expected) {
        assertEquals(expected, new Solution().tribonacci(n));
    }
}
