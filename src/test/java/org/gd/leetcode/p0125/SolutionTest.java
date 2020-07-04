package org.gd.leetcode.p0125;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #125: Is Palindrome")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("0P", false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void isPalindrome(String s, boolean expected) {
        assertEquals(expected, new Solution().isPalindrome(s));
    }
}