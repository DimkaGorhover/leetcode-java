package org.gd.leetcode.p0008;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-01
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("42", 42),
                arguments("    -42", -42),
                arguments("words and 987", 0),
                arguments("987  ", 987),
                arguments("-91283472332", Integer.MIN_VALUE),
                arguments("1291283472332", Integer.MAX_VALUE),
                arguments("4193 with words", 4193)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MyAtoi")
    void test_MyAtoi(String str, int expected) throws Exception {
        int actual = new Solution().myAtoi(str);
        assertEquals(expected, actual, () -> String.format("%ninput:[%s], expected:[%d], actual:[%d]%n%n", str, expected, actual));
    }
}