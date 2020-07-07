package org.gd.leetcode.p0057;

import org.gd.common.CollectionUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-07
 */
@DisplayName("LeetCode #57: Insert Interval")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                        new int[]{4, 8},
                        new int[][]{{1, 2}, {3, 10}, {12, 16}}
                ),
                Arguments.of(
                        new int[][]{{1, 5}},
                        new int[]{0, 0},
                        new int[][]{{0, 0}, {1, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 5}},
                        new int[]{0, 3},
                        new int[][]{{0, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 5}},
                        new int[]{2, 7},
                        new int[][]{{1, 7}}
                ),
                Arguments.of(
                        new int[][]{},
                        new int[]{5, 7},
                        new int[][]{{5, 7}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {6, 9}},
                        new int[]{2, 5},
                        new int[][]{{1, 5}, {6, 9}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #57: Insert Interval")
    void test_Insert(int[][] intervals, int[] newInterval, int[][] expected) {

        assertEquals(
                CollectionUtils.listOf(expected),
                CollectionUtils.listOf(new Solution().insert(intervals, newInterval)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #57: Insert Interval (Heap Solution)")
    void test_HeapSolution(int[][] intervals, int[] newInterval, int[][] expected) {

        assertEquals(
                CollectionUtils.listOf(expected),
                CollectionUtils.listOf(Solution.SolutionProvider.heap().insert(intervals, newInterval)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #57: Insert Interval (Simple Solution)")
    void test_SimpleSolution(int[][] intervals, int[] newInterval, int[][] expected) {

        assertEquals(
                CollectionUtils.listOf(expected),
                CollectionUtils.listOf(Solution.SolutionProvider.simple().insert(intervals, newInterval)));
    }
}