package org.gd.leetcode.p0283;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-13
 */
class SolutionTest {


    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                arguments(new int[]{0, 0, 1}, new int[]{1, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MoveZeroes")
    void test_MoveZeroes(int[] input, int[] expected) throws Exception {
        new Solution().moveZeroes(input);
        Assertions.assertArrayEquals(expected, input);
    }
}