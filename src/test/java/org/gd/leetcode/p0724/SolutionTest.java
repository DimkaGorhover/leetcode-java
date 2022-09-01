package org.gd.leetcode.p0724;

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
 * @since 2020-07-31
 */
@DisplayName("LeetCode #724: Find Pivot Index")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{1, 2, 3, 2, 1}, 2),
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PivotIndex")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_PivotIndex(int[] nums, int expected) {
        assertEquals(expected, new Solution().pivotIndex(nums));
    }
}