package org.gd.leetcode.p0198;

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
 * @author Horkhover Dmytro
 * @since 2019-01-01
 */
class SolutionTest {


    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        new int[]{1, 2, 3, 1},
                        4),
                arguments(
                        new int[]{2, 7, 9, 3, 1},
                        12),
                arguments(
                        new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240},
                        4173)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Rob")
    void test_Rob(int[] input, int expected) {
        assertEquals(expected, new Solution().rob(input));
    }
}