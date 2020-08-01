package org.gd.leetcode.p0033;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0081.SolutionTest
 * @since 2020-07-27
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #33: Search in Rotated Sorted Array")
class SolutionTest {

    private static Stream<Arguments> args() {

        int[] ints = IntStream.concat(
                IntStream.rangeClosed(101, 1000),
                IntStream.rangeClosed(1, 100)
        ).toArray();

        return Stream.of(
                Arguments.of(new int[]{9, 0, 2, 7, 8}, 3, -1),
                Arguments.of(new int[]{7, 9, 1, 4, 6}, 5, -1),
                Arguments.of(new int[]{7, 8, 9, 1, 4, 6}, 5, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 8, -1),
                Arguments.of(Arrays.copyOf(ints, ints.length), 13, 912),
                Arguments.of(new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 25, 4),
                Arguments.of(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1}, 9, 7),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Search")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_Search(int[] nums, int target, int expected) {
        assertEquals(expected, new Solution().search(nums, target));
    }
}