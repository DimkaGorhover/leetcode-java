package org.gd.leetcode.p0338;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #338: Counting Bits")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(2, new int[]{0, 1, 1})
        );
    }

    @ParameterizedTest(name = "num {0} -> {1}")
    @MethodSource("args")
    @DisplayName("Solution")
    void countBits1(int num, int[] expected) {
        assertArrayEquals(expected, new Solution().countBits(num));
    }

    @ParameterizedTest(name = "num {0} -> {1}")
    @MethodSource("args")
    @DisplayName("DP Solution")
    void countBits2(int num, int[] expected) {
        assertArrayEquals(expected, new DPSolution().countBits(num));
    }
}
