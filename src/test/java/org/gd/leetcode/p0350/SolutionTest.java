package org.gd.leetcode.p0350;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0349.SolutionTest
 * @since 2020-08-14
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #350: Intersection of Two Arrays II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{4, 9}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Hash Table Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Hash(int[] nums1, int[] nums2, int[] expected) {

        Arrays.sort(expected);

        int[] actual = new HashTableSolution().intersect(nums1, nums2);
        Arrays.sort(actual);

        assertEquals(listOf(expected), listOf(actual));
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Two Pointers Sort Solution")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Intersect(int[] nums1, int[] nums2, int[] expected) {

        Arrays.sort(expected);

        int[] actual = new TwoPointersSortSolution().intersect(nums1, nums2);
        Arrays.sort(actual);

        assertEquals(listOf(expected), listOf(actual));
    }
}
