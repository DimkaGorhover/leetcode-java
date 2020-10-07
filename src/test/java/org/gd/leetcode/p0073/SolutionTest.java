package org.gd.leetcode.p0073;

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
 * @since 2020-07-23
 */
@DisplayName("LeetCode #73: Set Matrix Zeroes")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {1, 1, 1},
                        {1, 0, 1},
                        {1, 1, 1}
                }, new int[][]{
                        {1, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SetZeroes")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_SetZeroes(int[][] matrix, int[][] expected) {
        new Solution().setZeroes(matrix);
        assertEquals(listOf(expected), listOf(matrix));
    }
}