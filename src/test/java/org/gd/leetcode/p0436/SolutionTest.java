package org.gd.leetcode.p0436;

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
 * @since 2020-08-27
 */
@DisplayName("LeetCode #436: Find Right Interval")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[][]{{4, 5}, {2, 3}, {1, 2}},
                        new int[]{-1, 0, 1}),

                Arguments.of(
                        new int[][]{{3, 4}, {2, 3}, {1, 2}},
                        new int[]{-1, 0, 1}),

                Arguments.of(
                        new int[][]{{1, 2}, {3, 4}, {5, 6}},
                        new int[]{1, 2, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindRightInterval")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FindRightInterval(int[][] intervals, int[] expected) {
        assertEquals(listOf(expected), listOf(new Solution().findRightInterval(intervals)));
    }
}
