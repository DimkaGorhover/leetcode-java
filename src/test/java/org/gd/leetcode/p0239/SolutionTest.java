package org.gd.leetcode.p0239;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-11-02
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaxSlidingWindow")
    void test_MaxSlidingWindow(int[] input, int k, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new Solution().maxSlidingWindow(input, k))
        );
    }
}