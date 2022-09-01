package org.gd.leetcode.p0054;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-20
 */
@Disabled
@DisplayName("LeetCode #54: Spiral Matrix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9},
                                {10, 11, 12},
                                {13, 14, 15},
                        },
                        Arrays.asList(1, 2, 3, 6, 9, 12, 15, 14, 13, 10, 7, 4, 5, 8, 11)),

                Arguments.of(
                        new int[][]{
                                {1, 11},
                                {2, 12},
                                {3, 13},
                                {4, 14},
                                {5, 15},
                                {6, 16},
                                {7, 17},
                                {8, 18},
                                {9, 19},
                                {10, 20}
                        },
                        Arrays.asList(1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2)),

                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)),

                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)),

                Arguments.of(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10))
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