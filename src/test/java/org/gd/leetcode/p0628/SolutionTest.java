package org.gd.leetcode.p0628;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
    @DisplayName("LeetCode #628: Maximum Product of Three Numbers")
    void test(int[] input, int expected) {

        int actual = new Solution().maximumProduct(input);

        assertEquals(expected, actual);
    }
}
