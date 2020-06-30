package org.gd.leetcode.p0053;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-06-30
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #53: Maximum Subarray")
    void test_MaxSubArray(int[] nums, int expected) {

        int actual = new Solution().maxSubArray(nums);

        assertEquals(expected, actual);
    }
}