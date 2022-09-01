package org.gd.leetcode.p0059;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
@DisplayName("LeetCode #59: Spiral Matrix II")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(5, new int[][]{
                        {1, 2, 3, 4, 5},
                        {16, 17, 18, 19, 6},
                        {15, 24, 25, 20, 7},
                        {14, 23, 22, 21, 8},
                        {13, 12, 11, 10, 9}
                }),

                Arguments.of(4, new int[][]{
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7}
                }),

                Arguments.of(3, new int[][]{
                        {1, 2, 3},
                        {8, 9, 4},
                        {7, 6, 5}
                })
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GenerateMatrix")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_GenerateMatrix(int n, int[][] expected) {
        assertEquals(listOf(expected), listOf(new Solution().generateMatrix(n)));
    }
}
