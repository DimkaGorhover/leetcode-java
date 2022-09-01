package org.gd.leetcode.p0003;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
@DisplayName("LeetCode #3: longest substring without repeating characters")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("ab", 2),
                Arguments.of("aa", 1),
                Arguments.of("aabcdacd", 4),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("abcabcbb", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LengthOfLongestSubstring")
    void test_LengthOfLongestSubstring(String input, int expected) {
        assertEquals(expected, new Solution().lengthOfLongestSubstring(input));
    }
}