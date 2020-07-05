package org.gd.leetcode.p0063;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #63: Unique Paths II")
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
                Arguments.of(new int[][]{{1}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void uniquePathsWithObstacles(int[][] grid, int expected) {
        int actual = new Solution().uniquePathsWithObstacles(grid);
        assertEquals(expected, actual);
    }
}