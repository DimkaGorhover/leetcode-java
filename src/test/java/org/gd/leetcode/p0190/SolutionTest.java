package org.gd.leetcode.p0190;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    private static final String[] PREFIX;

    static {
        PREFIX = new String[32];
        PREFIX[0] = "";
        for (int i = 1; i < 32; i++)
            PREFIX[i] = PREFIX[i - 1] + '0';
    }

    private static String toBinaryString(int value, int length) {
        final String s = Integer.toBinaryString(value);
        return PREFIX[Math.max(0, length - s.length())] + s;
    }

    private static int fromBinaryString(String input) {
        return (int) Long.parseLong(input, 2);
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        "00000010100101000001111010011100",
                        "00111001011110000010100101000000")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void reverseBits(String input, String expected) {
        int length = Math.max(input.length(), expected.length());
        int n = fromBinaryString(input);
        int result = new Solution().reverseBits(n);
        assertEquals(expected, toBinaryString(result, length));
    }
}