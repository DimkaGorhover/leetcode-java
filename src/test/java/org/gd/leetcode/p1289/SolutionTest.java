package org.gd.leetcode.p1289;

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
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0931.SolutionTest
 * @see HalfDPSolution
 * @see FullDPSolution
 * @since 2020-08-07
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #1289: Minimum Falling Path Sum II")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(new int[][]{
                        {-73, 61, 43, -48, -36},
                        {3, 30, 27, 57, 10},
                        {96, -76, 84, 59, -15},
                        {5, -49, 76, 31, -7},
                        {97, 91, 61, -46, 67}
                }, -192),

                Arguments.of(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, 13)

        );
    }

    /**
     * @see HalfDPSolution
     */
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Half DP Solution")
    void test_HalfDPSolution(int[][] arr, int expected) {
        assertEquals(expected, new HalfDPSolution().minFallingPathSum(arr));
    }

    /**
     * @see FullDPSolution
     */
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Full DP Solution")
    void test_FullDPSolution(int[][] arr, int expected) {
        assertEquals(expected, new FullDPSolution().minFallingPathSum(arr));
    }
}