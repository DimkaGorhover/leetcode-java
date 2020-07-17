package org.gd.leetcode.p0084;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #84: Largest Rectangle in Histogram")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{2, 1, 5, 6, 2, 3}, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void largestRectangleArea(int[] area, int expected) {
        assertEquals(expected, new Solution().largestRectangleArea(area));
    }
}