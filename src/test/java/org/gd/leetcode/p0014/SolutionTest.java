package org.gd.leetcode.p0014;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-21
 */
@DisplayName("LeetCode #14: Longest Common Prefix")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LongestCommonPrefix")
    void test_LongestCommonPrefix(String[] input, String expected) {
        String actual = new Solution().longestCommonPrefix(input);
        assertEquals(expected, actual);
    }
}