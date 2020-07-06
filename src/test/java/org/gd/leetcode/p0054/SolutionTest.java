package org.gd.leetcode.p0054;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-20
 */
@Disabled
@DisplayName("LeetCode #54: spiral matrix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                arguments(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)
                ),
                arguments(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9},
                                {10, 11, 12},
                                {13, 14, 15},
                        },
                        List.of(1, 2, 3, 6, 9, 12, 15, 14, 13, 10, 7, 4, 5, 8, 11)
                ),
                arguments(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SpiralOrder")
    void test_SpiralOrder(int[][] input, List<Integer> expected) {
        assertEquals(
                expected,
                new Solution().spiralOrder(input)
        );
    }
}