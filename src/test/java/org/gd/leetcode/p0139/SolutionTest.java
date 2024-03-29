package org.gd.leetcode.p0139;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @see org.gd.leetcode.p0140.SolutionTest
 * @since 2020-07-11
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #139: Word Break")
class SolutionTest {

    private static Stream<Arguments> args() {

        return Stream.of(
                Arguments.of(
                        "pineapplepenapple",
                        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"),
                        true),
                Arguments.of("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), false),
                Arguments.of("applepenapple", Arrays.asList("apple", "pen"), true),
                Arguments.of("leetcode", Arrays.asList("leet", "code"), true),
                Arguments.of("abcd", Arrays.asList("a", "abc", "b", "cd"), true),
                Arguments.of("dogs", Arrays.asList("dog","s","gs"), true),
                Arguments.of("aaaaaa", Arrays.asList("aaaa", "aaa"), true),
                Arguments.of("bb", Arrays.asList("b", "a", "bbb", "bbbb"), true),
                Arguments.of(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                        Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"),
                        false
                ),
                Arguments.of("aaaaaaa", Arrays.asList("aaaa", "aa"), false)
        );
    }

    @Timeout(2)
    @ParameterizedTest(name = "word = {0}, dict = {1}")
    @MethodSource("args")
    @DisplayName("WordBreak")
    void test_WordBreak(String word, List<String> dict, boolean expected) {
        //assertEquals(expected, new StreamSolution().wordBreak(word, dict));
        assertEquals(expected, new Solution().wordBreak(word, dict));
    }
}