package org.gd.leetcode.p0004;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-24
 */
@DisplayName("LeetCode #4: Find Median of Two Sorted Arrays")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2d),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5d)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #4: Find Median of Two Sorted Arrays")
    void test_FindMedianSortedArrays(int[] nums1, int[] nums2, double expected) throws Exception {
        double actual = new Solution().findMedianSortedArrays(nums1, nums2);
        assertEquals(expected, actual);
    }
}