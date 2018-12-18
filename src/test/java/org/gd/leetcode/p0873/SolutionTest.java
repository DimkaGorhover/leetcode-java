package org.gd.leetcode.p0873;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-11-04
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 5),
                arguments(new int[]{1, 2, 3}, 3),
                arguments(new int[]{1, 2, 3, 4}, 3),
                arguments(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LenLongestFibSubseq")
    void test_LenLongestFibSubseq(int[] input, int expected) {
        assertEquals(
                expected,
                new Solution().lenLongestFibSubseq(input)
        );
    }
}