package org.gd.leetcode.p0167;

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
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@DisplayName("LeetCode #167: Two Sum II - Input array is sorted")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Two Pointers")
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void test_TwoPointers(int[] nums, int target, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new TwoPointersSolution().twoSum(nums, target)));
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("O( n**2 )")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_OMG(int[] nums, int target, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new OMGSolution().twoSum(nums, target)));
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("O( n ** Log(n) )")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_BS(int[] nums, int target, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new BinarySearchSolution().twoSum(nums, target)));
    }
}
