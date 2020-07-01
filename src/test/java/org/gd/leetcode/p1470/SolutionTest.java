package org.gd.leetcode.p1470;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{2, 5, 1, 3, 4, 7}, new int[]{2, 3, 5, 4, 1, 7}),
                Arguments.of(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, new int[]{1, 4, 2, 3, 3, 2, 4, 1}),
                Arguments.of(new int[]{1, 1, 2, 2}, new int[]{1, 2, 1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #1470: Shuffle the Array")
    void shuffle(int[] nums, int[] expected) {
        assertArrayEquals(expected, new Solution().shuffle(nums, nums.length >> 1));
    }
}