package org.gd.leetcode.p0392;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #391: Is Subsequence")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("abc", "ahbgdfff", false),
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("ac", "ahbgdc", true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void isSubsequence(String seq, String text, boolean expected) {
        boolean actual = new Solution().isSubsequence(seq, text);
        assertEquals(expected, actual);
    }
}