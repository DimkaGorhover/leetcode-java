package org.gd.leetcode.p0005;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
@Execution(ExecutionMode.CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("babad", Set.of("bab", "aba")),
                arguments("cbbd", Set.of("bb")),
                arguments("ac", Set.of("a", "c")),
                arguments("ccc", Set.of("ccc")),
                arguments("caba", Set.of("aba"))
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
                arguments("bb", 0, "bb".length(), "bb"),
                arguments("aba", 0, "aba".length(), "aba"),
                arguments("abccba", 0, "abccba".length(), "abccba"),
                arguments("abcdcba", 0, "abcdcba".length(), "abcdcba"),
                arguments("ab1cdcba", 0, "ab1cdcba".length(), ""),
                arguments("ab1cdcba", 3, 6, "cdc")
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