package org.gd.leetcode.p0409;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #409: Longest Palindrome")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abccccdd", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void longestPalindrome(String s, int expected) {
        assertEquals(expected, new Solution().longestPalindrome(s));
    }
}