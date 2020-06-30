package org.gd.leetcode.p0151;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world!  ", "world! hello"),
                Arguments.of("a good   example", "example good a")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeerCode #151: Reverse Words in a String")
    void reverseWords(String input, String expected) {
        String actual = new Solution().reverseWords(input);
        assertEquals(expected, actual);
    }
}