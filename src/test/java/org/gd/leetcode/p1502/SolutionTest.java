package org.gd.leetcode.p1502;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #1502: Can Make Arithmetic Progression From Sequence")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{3, 9, 1, 7, 5}, true),
                Arguments.of(new int[]{1, 1}, true),
                Arguments.of(new int[]{1, 3, 1, 3}, false),
                Arguments.of(new int[]{1, 4, 2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void canMakeArithmeticProgression(int[] arr, boolean expected) {
        boolean actual = new Solution().canMakeArithmeticProgression(arr);
        assertEquals(expected, actual);
    }
}