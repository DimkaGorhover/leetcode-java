package org.gd.leetcode.p0542;

import org.gd.common.CollectionUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #542: 01 Matrix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 1, 1}
                }, new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {1, 2, 1}
                }),

                Arguments.of(
                        new int[][]{
                                /* 0 */ {1, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                                /* 1 */ {1, 0, 0, 1, 0, 1, 1, 1, 1, 1},
                                /* 2 */ {1, 1, 1, 0, 0, 1, 1, 1, 1, 0},
                                /* 3 */ {0, 1, 1, 1, 0, 1, 1, 1, 1, 1},
                                /* 4 */ {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
                                /* 5 */ {1, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                                /* 6 */ {0, 1, 1, 1, 1, 1, 1, 0, 0, 1},
                                /* 7 */ {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                                /* 8 */ {0, 1, 0, 1, 1, 0, 1, 1, 1, 1},
                                /* 9 */ {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}},
                        new int[][]{
                                /* 0 */ {2, 1, 0, 0, 1, 0, 0, 1, 1, 0},
                                /* 1 */ {1, 0, 0, 1, 0, 1, 1, 2, 2, 1},
                                /* 2 */ {1, 1, 1, 0, 0, 1, 2, 2, 1, 0},
                                /* 3 */ {0, 1, 2, 1, 0, 1, 2, 3, 2, 1},
                                /* 4 */ {0, 0, 1, 2, 1, 2, 1, 2, 1, 0},
                                /* 5 */ {1, 1, 2, 3, 2, 1, 0, 1, 1, 1},
                                /* 6 */ {0, 1, 2, 3, 2, 1, 1, 0, 0, 1},
                                /* 7 */ {1, 2, 1, 2, 1, 0, 0, 1, 1, 2},
                                /* 8 */ {0, 1, 0, 1, 1, 0, 1, 2, 2, 3},
                                /* 9 */ {1, 2, 1, 0, 1, 0, 1, 2, 3, 4}
                        }),

                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                }, new int[][]{
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void updateMatrix(int[][] matrix, int[][] expected) {

        var actual = new DPSolution().updateMatrix(matrix);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < actual.length; i++) {
            final int line = i;
            assertEquals(
                    CollectionUtils.listOf(expected[i]),
                    CollectionUtils.listOf(actual[i]),
                    () -> String.format("line = %d", line));
        }
    }
}