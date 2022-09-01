package org.gd.leetcode.p0048;

import org.gd.leetcode.common.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-12
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9},
                }, new int[][]{
                        {7, 4, 1},
                        {8, 5, 2},
                        {9, 6, 3}
                }),

                arguments(new int[][]{
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                }, new int[][]{
                        {15, 13, 2, 5},
                        {14, 3, 4, 1},
                        {12, 6, 8, 9},
                        {16, 7, 10, 11}
                })
        );
    }


    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Rotate")
    void test_Rotate(int[][] input, int[][] expected) {

        new Solution().rotate(input);

        assertEquals(
                CollectionUtils.listOf(expected),
                CollectionUtils.listOf(input)
        );
    }
}