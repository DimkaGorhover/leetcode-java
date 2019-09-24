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
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(new int[]{1, 3}, new int[]{2}, 2d)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindMedianSortedArrays")
    void test_FindMedianSortedArrays(int[] nums1, int[] nums2, double expected) throws Exception {
        assertEquals(expected, new Solution().findMedianSortedArrays(nums1, nums2));
    }
}