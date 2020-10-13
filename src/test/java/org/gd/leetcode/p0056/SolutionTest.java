package org.gd.leetcode.p0056;

import org.gd.common.CollectionUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-06.07.2020
 */
@DisplayName("LeetCode #56: Merge Intervals")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[][]{{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}},
                        new int[][]{{0, 3}, {4, 6}}
                ),

                Arguments.of(
                        new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}},
                        new int[][]{{2, 4}, {5, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},
                        new int[][]{{1, 6}, {8, 10}, {15, 18}}
                ),
                Arguments.of(
                        new int[][]{{1, 4}, {4, 5}},
                        new int[][]{{1, 5}}
                ),
                Arguments.of(
                        new int[][]{{1, 4}, {2, 4}},
                        new int[][]{{1, 4}}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Merge")
    void test_Merge(int[][] intervals, int[][] expected) {

        int[][] actual = new Solution().merge(intervals);

        assertEquals(expected.length, actual.length);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(
                    CollectionUtils.listOf(expected[i]),
                    CollectionUtils.listOf(actual[i]));
        }
    }
}