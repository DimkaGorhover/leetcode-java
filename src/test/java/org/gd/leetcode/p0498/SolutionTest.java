package org.gd.leetcode.p0498;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-14
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}
                )
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindDiagonalOrder")
    void test_FindDiagonalOrder(int[][] matrix, int[] expected) throws Exception {
        assertArrayEquals(expected, new Solution().findDiagonalOrder(matrix));
    }
}