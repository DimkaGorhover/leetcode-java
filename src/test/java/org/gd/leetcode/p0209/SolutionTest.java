package org.gd.leetcode.p0209;

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
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@DisplayName("LeetCode #209: Minimum Size Subarray Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(11, new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of(7, new int[]{2, 3, 1, 2, 4, 3}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MinSubArrayLen")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MinSubArrayLen(int s, int[] nums, int expected) {
        assertEquals(expected, new Solution().minSubArrayLen(s, nums));
    }
}
