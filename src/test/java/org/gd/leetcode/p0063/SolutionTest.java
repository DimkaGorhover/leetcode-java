package org.gd.leetcode.p0063;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #63: Unique Paths II")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }, 2),
                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {1, 1, 0},
                        {0, 0, 0}
                }, 1),
                Arguments.of(new int[][]{{1}}, 0),
                Arguments.of(new int[][]{{0, 1, 0}}, 0),
                Arguments.of(new int[][]{{0, 1}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void uniquePathsWithObstacles(int[][] grid, int expected) {
        int actual = new Solution().uniquePathsWithObstacles(grid);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Args Validation")
    void test_ArgsValidation() {
        assertThrows(NullPointerException.class, () -> new Solution().uniquePathsWithObstacles(null));
        assertThrows(IllegalArgumentException.class, () -> {
            int[][] grid = {};
            new Solution().uniquePathsWithObstacles(grid);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            int[][] grid = {{}, {}};
            new Solution().uniquePathsWithObstacles(grid);
        });
    }
}