package org.gd.leetcode.p0014;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-21
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(s("flower", "flow", "flight"), "fl"),
                arguments(s("dog", "racecar", "car"), "")
        );
    }

    private static String[] s(String... value) {
        return value;
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LongestCommonPrefix")
    void test_LongestCommonPrefix(String[] input, String expected) {
        assertEquals(
                expected,
                new Solution().longestCommonPrefix(input)
        );
    }
}