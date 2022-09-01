package org.gd.leetcode.p0005;

import lombok.NonNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.gd.leetcode.common.CollectionUtils.setOf;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    @NonNull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("babad", setOf("bab", "aba")),
                Arguments.of("cbbd", setOf("bb")),
                Arguments.of("ac", setOf("a", "c")),
                Arguments.of("ccc", setOf("ccc")),
                Arguments.of("caba", setOf("aba"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Old Solution")
    void test_OldSolution(String str, @NonNull Set<String> expected) {
        assertThat(new OldSolution().longestPalindrome(str))
                .matches(expected::contains, "should contains in " + expected);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("New Solution")
    void test_NewSolution(String str, @NonNull Set<String> expected) {
        assertThat(new NewSolution().longestPalindrome(str))
                .matches(expected::contains, "should contains in " + expected);
    }

    @NonNull
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
    void test_IsPalindrome(String string, int startIndex, int endIndex, String expected) {
        assertThat(OldSolution.getPalindrome(string, startIndex, endIndex)).isEqualTo(expected);
    }
}
