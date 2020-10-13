package org.gd.leetcode.p0628;

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
@DisplayName("LeetCode #628: Maximum Product of Three Numbers")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4}, 24),
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{1, 2, 3, 2}, 12),
                Arguments.of(new int[]{-1, -2, -3}, -6),
                Arguments.of(new int[]{-4, -3, -2, -1, 60}, 720)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test(int[] input, int expected) {

        int actual = new Solution().maximumProduct(input);

        assertEquals(expected, actual);
    }
}
