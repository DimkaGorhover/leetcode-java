package org.gd.leetcode.p0053;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-06-30
 */
@DisplayName("LeetCode #53: Maximum Subarray")
@Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("test")
    void test_MaxSubArray(int[] nums, int expected) {
        assertEquals(expected, new Solution().maxSubArray(nums));
    }
}