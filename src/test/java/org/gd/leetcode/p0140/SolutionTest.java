package org.gd.leetcode.p0140;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @see org.gd.leetcode.p0139.SolutionTest
 */
@Disabled
@DisplayName("LeetCode #140: Word Break II")
@SuppressWarnings("JavadocReference")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        "catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), Arrays.asList()
                ),
                Arguments.of(
                        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                        Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"),
                        Arrays.asList()
                ),
                Arguments.of(
                        "pineapplepenapple",
                        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"),
                        Arrays.asList(
                                "pine apple pen apple",
                                "pineapple pen apple",
                                "pine applepen apple"
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void wordBreak(String word, List<String> dict, List<String> expected) {
        List<String> actual = new Solution().wordBreak(word, dict);

        for (String s : expected) {
            assertTrue(actual.contains(s));
        }
    }
}