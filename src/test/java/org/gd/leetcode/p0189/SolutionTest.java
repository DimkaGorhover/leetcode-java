package org.gd.leetcode.p0189;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
            
                Arguments.of(
                    new int[]{1, 2, 3, 4, 5, 6, 7}, 
                    3, 
                    new int[]{5, 6, 7, 1, 2, 3, 4}),

                Arguments.of(
                    new int[]{1, 2}, 
                    1, 
                    new int[]{2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #189: Rotate Array")
    void test(int[] input, int k, int[] expected) {

        new Solution().rotate(input, k);

        assertArrayEquals(expected, input);
    }
}