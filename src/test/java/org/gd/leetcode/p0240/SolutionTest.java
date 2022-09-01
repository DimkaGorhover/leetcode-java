package org.gd.leetcode.p0240;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode #240: Search a 2d Matrix II")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    static Stream<Arguments> args() {
        //@formatter:off
        final int[][] matrix = {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        //@formatter:on

        return Stream.of(
                Arguments.of(new int[0][0], 18, false),
                Arguments.of(matrix, 18, true),
                Arguments.of(matrix, 25, false),
                Arguments.of(matrix, 24, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test(int[][] matrix, int target, boolean expected) {
        assertEquals(expected, new Solution().searchMatrix(matrix, target));
    }
}
