package org.gd.leetcode.p0003;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments("ab", 2),
                Arguments.arguments("aa", 1),
                Arguments.arguments("aabcdacd", 4),
                Arguments.arguments("bbbbb", 1),
                Arguments.arguments("pwwkew", 3),
                Arguments.arguments("abcabcbb", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LengthOfLongestSubstring")
    void test_LengthOfLongestSubstring(String input, int expected) {
        assertEquals(expected, new Solution().lengthOfLongestSubstring(input));
    }
}