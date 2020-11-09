package org.gd.leetcode.p1636;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-11-09
 */
@DisplayName("LeetCode #1636: Sort Array by Increasing Frequency")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 1}),
                Arguments.of(new int[]{2, 3, 1, 3, 2}, new int[]{1, 3, 3, 2, 2}),
                Arguments.of(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1}, new int[]{5, -1, 4, 4, -6, -6, 1, 1, 1}),
                Arguments.of(new int[]{1, 1, 2, 2, 2, 3}, new int[]{3, 1, 1, 2, 2, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FrequencySort")
    void test_FrequencySort(int[] nums, int[] expected) {
        int[] actual = new Solution().frequencySort(nums);
        assertSame(nums, actual);
        assertEquals(listOf(expected), listOf(actual));
    }
}
