package org.gd.leetcode.p0909;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-11
 */
@DisplayName("LeetCode #909: Snakes and Ladders")
class SolutionTest {


    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(new int[][]{
                        {-1, -1, 30, 14, 15, -1},
                        {23, 9, -1, -1, -1, 9},
                        {12, 5, 7, 24, -1, 30},
                        {10, -1, -1, -1, 25, 17},
                        {32, -1, 28, -1, -1, 32},
                        {-1, -1, 23, -1, 13, 19}
                }, 3),

                Arguments.of(new int[][]{
                        {-1, 15, 9, 1, -1},
                        {-1, -1, 10, 5, 19},
                        {18, -1, 23, 9, -1},
                        {1, 13, -1, 16, 20},
                        {-1, 10, 10, 25, 13}
                }, 1),

                Arguments.of(new int[][]{
                        {1, 1, -1},
                        {1, 1, 1},
                        {-1, 1, 1}
                }, -1),

                Arguments.of(new int[][]{
                        {-1, 4, -1},
                        {6, 2, 6},
                        {-1, 3, -1}
                }, 2),

                Arguments.of(new int[][]{
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 35, -1, -1, 13, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 15, -1, -1, -1, -1}
                }, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SnakesAndLadders")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_SnakesAndLadders(int[][] board, int expected) {
        assertEquals(expected, new Solution().snakesAndLadders(board));
    }

    private static int[][] generateBoard(int n) {
        int[][] board = new int[n][n];
        for (int[] ints : board)
            Arrays.fill(ints, -1);
        return board;
    }

    private static Stream<Arguments> pointsArgs() {
        return Stream.of(

                Arguments.of(3, 5, new ExpectedPoint(1, 1)),
                Arguments.of(3, 1, new ExpectedPoint(2, 0)),

                Arguments.of(6, 1, new ExpectedPoint(5, 0)),
                Arguments.of(6, 10, new ExpectedPoint(4, 2)),
                Arguments.of(6, 13, new ExpectedPoint(3, 0)),
                Arguments.of(6, 22, new ExpectedPoint(2, 2)),
                Arguments.of(6, 23, new ExpectedPoint(2, 1)),
                Arguments.of(6, 19, new ExpectedPoint(2, 5)),
                Arguments.of(6, 18, new ExpectedPoint(3, 5)),
                Arguments.of(6, 36, new ExpectedPoint(0, 0))
        );
    }

    @ParameterizedTest(name = "board {0}x{0}, position for {1} is {2}")
    @MethodSource("pointsArgs")
    @DisplayName("Point")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_Point(int n, int position, ExpectedPoint expected) {

        Solution solution = new Solution();
        solution.reset(generateBoard(n));

        var point = solution.startPoint();
        if (position != point.position())
            point = point.next(position);

        assertEquals(position, point.position());
        assertEquals(expected, ExpectedPoint.of(point));
    }
}
