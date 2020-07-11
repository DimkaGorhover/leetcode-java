package org.gd.leetcode.p0139;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-11
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"),
                        true
                ),
                Arguments.of("aaaaaaa", List.of("aaaa","aa"), false),
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("WordBreak")
    void test_WordBreak(String word, List<String> dict, boolean expected) {
        boolean actual = new Solution().wordBreak(word, dict);
        assertEquals(expected, actual);
    }
}