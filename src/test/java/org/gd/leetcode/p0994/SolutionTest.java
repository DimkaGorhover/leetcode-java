package org.gd.leetcode.p0994;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-09
 */
@DisplayName("LeetCode #994: Rotting Oranges")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(new int[][]{{0, 2}}, 0),

                Arguments.of(new int[][]{
                        {2, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                }, 4)
        );
    }

    @ParameterizedTest(name = "expected {1} minutes in grid {0}")
    @MethodSource("args")
    @DisplayName("OrangesRotting")
    void test_OrangesRotting(int[][] grid, int expected) {
        assertEquals(expected, new Solution().orangesRotting(grid));
    }
}
