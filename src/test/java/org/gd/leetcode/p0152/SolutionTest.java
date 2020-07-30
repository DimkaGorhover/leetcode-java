package org.gd.leetcode.p0152;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.gd.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-06-30
 */
@DisplayName("LeetCode #152: Maximum Product Subarray")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{-1, -2, -9, -6}, 108),
                Arguments.of(new int[]{-2, 0, -1}, 0),
                Arguments.of(new int[]{-2, 3, -4}, 24),
                Arguments.of(new int[]{-2, 3, -4, -2}, 24),
                Arguments.of(new int[]{2, 3, -2, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Dynamic Programming Solution")
    void test_MaxProduct(int[] nums, int expected) {
        assertEquals(expected, new Solution().maxProduct(copy(nums)));
    }
}