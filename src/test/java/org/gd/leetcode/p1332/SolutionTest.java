package org.gd.leetcode.p1332;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link Solution}.
 */
@DisplayName("LeetCode #1332: Remove Palindromic Subsequences")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0),
                Arguments.of("ababa", 1),
                Arguments.of("abb", 2),
                Arguments.of("baabb", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test_RemovePalindromeSub(String s, int expected) {
        Solution solution = new Solution();
        assertThat(solution.removePalindromeSub(s)).isEqualTo(expected);
    }
}
