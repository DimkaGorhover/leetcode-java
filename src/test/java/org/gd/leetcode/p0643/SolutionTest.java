package org.gd.leetcode.p0643;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-20
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindMaxAverage")
    void test_FindMaxAverage(int[] nums, int k, double expected) throws Exception {
        assertEquals(expected, new Solution().findMaxAverage(nums, k));
    }
}