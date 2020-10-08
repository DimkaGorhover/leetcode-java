package org.gd.leetcode.p0088;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-10
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        new int[]{1, 2, 3, 0, 0, 0}, 3,
                        new int[]{2, 5, 6}, 3,
                        new int[]{1, 2, 2, 3, 5, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Merge")
    void test_Merge(int[] nums1, int m, int[] nums2, int n, int[] expected) throws Exception {
        new Solution().merge(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}