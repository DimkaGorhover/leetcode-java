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
                Arguments.of("applepenapple", List.of("apple", "pen"), true),
                Arguments.of("leetcode", List.of("leet", "code"), true),
                Arguments.of("abcd", List.of("a", "abc", "b", "cd"), true),
                Arguments.of("dogs", List.of("dog","s","gs"), true),
                Arguments.of("aaaaaa", List.of("aaaa", "aaa"), true),
                Arguments.of("bb", List.of("b", "a", "bbb", "bbbb"), true),
                Arguments.of(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                        false
                ),
                Arguments.of("aaaaaaa", List.of("aaaa", "aa"), false),
                Arguments.of("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    @ParameterizedTest(name = "word = {0}, dict = {1}")
    @MethodSource("args")
    @DisplayName("WordBreak")
    void test_WordBreak(String word, List<String> dict, boolean expected) {
        //assertEquals(expected, new StreamSolution().wordBreak(word, dict));
        assertEquals(expected, new Solution().wordBreak(word, dict));
    }
}