package org.gd.leetcode.p0741;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-16.07.2020
 */
@DisplayName("LeetCode #741: Cherry Pickup")
class SolutionTest {

    private static List<Arguments> args() {
        return List.of(

                Arguments.of(new int[][]{
                        {1, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 1, 1, 1, 1}}, 15),

                Arguments.of(new int[][]{
                        {1, 1, -1},
                        {1, -1, 1},
                        {-1, 1, 1}}, 0),

                Arguments.of(new int[][]{
                        {0, 1, -1},
                        {1, 0, -1},
                        {1, 1, 1}}, 5),

                Arguments.of(new int[][]{
                        {0, 1, -1, 1},
                        {1, 0, -1, 1},
                        {1, 1, 1, 0}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CherryPickup")
    void test_CherryPickup(int[][] grid, int expected) {
        assertEquals(expected, new Solution().cherryPickup(grid));
    }
}