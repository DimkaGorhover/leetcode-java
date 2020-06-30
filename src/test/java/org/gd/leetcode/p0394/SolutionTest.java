package org.gd.leetcode.p0394;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("3[a]2[bc]", "aaabcbc"),
                Arguments.of("3[a2[c]]","accaccacc"),
                Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef"),
                Arguments.of("abc3[cd]xyz", "abccdcdcdxyz")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #394: Decode String")
    void decodeString(String input, String expected) {

        String actual = new Solution().decodeString(input);

        assertEquals(expected, actual);
    }
}