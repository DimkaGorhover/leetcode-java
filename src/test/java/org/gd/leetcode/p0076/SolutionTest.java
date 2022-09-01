package org.gd.leetcode.p0076;

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
 * @since 2020-08-16
 */
@DisplayName("LeetCode #76: Minimum Window Substring")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("bba", "ab", "ba"),
                Arguments.of("cabwefgewcwaefgcf", "cae", "cwae"),
                Arguments.of("a", "aa", ""),
                Arguments.of("a", "b", ""),
                Arguments.of("ADOBECODEBANC", "ABC", "BANC")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MinWindow")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MinWindow(String s, String t, String expected) {
        assertEquals(expected, new Solution().minWindow(s, t));
    }
}
