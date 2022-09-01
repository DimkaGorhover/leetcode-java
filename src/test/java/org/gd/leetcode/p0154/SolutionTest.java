package org.gd.leetcode.p0154;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-26
 */
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
@DisplayName("LeetCode #154: Find Minimum in Rotated Sorted Array II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 1),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 3, 1, 2, 2}, 1),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 1, 2, 2}, 1),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 0, 1, 2, 2}, 0),
                Arguments.of(
                        IntStream.concat(IntStream.rangeClosed(1010, 5_000), IntStream.rangeClosed(14, 1_000)).toArray(),
                        14),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 0}, 0),
                Arguments.of(new int[]{1, 0, -1}, -1),
                Arguments.of(new int[]{3, 4, 5, 1, 2}, 1),
                Arguments.of(new int[]{2, 2, 2, 2, 2, 1, 2, 2}, 1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindMin")
    void test_FindMin(int[] nums, int expected) {
        assertEquals(expected, new Solution().findMin(nums));
    }
}