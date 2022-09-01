package org.gd.leetcode.p1081;

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
 * @since 2020-10-12
 */
@DisplayName("LeetCode #1081: Smallest Subsequence of Distinct Characters")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("cbacdcbc", "acdb"),
                Arguments.of("bcabc", "abc")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("smallestSubsequence")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_RemoveDuplicateLetters(String s, String expected) {
        assertEquals(expected, new Solution().smallestSubsequence(s));
    }
}
