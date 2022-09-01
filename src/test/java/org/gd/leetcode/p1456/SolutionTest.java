package org.gd.leetcode.p1456;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-11-18
 */
@DisplayName("LeetCode #1456: Maximum Number of Vowels in a Substring of Given Length")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("aeiou", 2, 2),
                Arguments.of("rhythms", 4, 0),
                Arguments.of("leetcode", 3, 2),
                Arguments.of("abciiidef", 3, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MaxVowels")
    void test_MaxVowels(String word, int k, int expected) {
        assertEquals(expected, new Solution().maxVowels(word, k));
    }
}
