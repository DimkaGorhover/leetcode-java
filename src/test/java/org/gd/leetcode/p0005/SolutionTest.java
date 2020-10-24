package org.gd.leetcode.p0005;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
@DisplayName("LeetCode #5: longest palindromic substring")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("babad", Set.of("bab", "aba")),
                Arguments.of("cbbd", Set.of("bb")),
                Arguments.of("ac", Set.of("a", "c")),
                Arguments.of("ccc", Set.of("ccc")),
                Arguments.of("caba", Set.of("aba"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LongestPalindrome")
    void test_LongestPalindrome(String str, Set<String> expected) throws Exception {
        String palindrome = new Solution().longestPalindrome(str);
        assertTrue(
                expected.contains(palindrome),
                () -> String.format("%s doesn't contains \"%s\"%n%n", expected, palindrome));
    }


    private static Stream<Arguments> argsIsPalindrome() {
        return Stream.of(
                Arguments.of("bb", 0, "bb".length(), "bb"),
                Arguments.of("aba", 0, "aba".length(), "aba"),
                Arguments.of("abccba", 0, "abccba".length(), "abccba"),
                Arguments.of("abcdcba", 0, "abcdcba".length(), "abcdcba"),
                Arguments.of("ab1cdcba", 0, "ab1cdcba".length(), ""),
                Arguments.of("ab1cdcba", 3, 6, "cdc")
        );
    }

    @ParameterizedTest
    @MethodSource("argsIsPalindrome")
    @DisplayName("IsPalindrome")
    void test_IsPalindrome(String string, int startIndex, int endIndex, String expected) throws Exception {
        String palindrome = Solution.getPalindrome(string, startIndex, endIndex);
        assertEquals(expected, palindrome);
    }
}