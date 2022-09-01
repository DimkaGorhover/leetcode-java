package org.gd.leetcode.p0008;

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
 * @since 2019-10-01
 */
@DisplayName("LeetCode #8: string to integer (atoi)")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("42", 42),
                Arguments.of("    -42", -42),
                Arguments.of("words and 987", 0),
                Arguments.of("987  ", 987),
                Arguments.of("-91283472332", Integer.MIN_VALUE),
                Arguments.of("1291283472332", Integer.MAX_VALUE),
                Arguments.of("4193 with words", 4193)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MyAtoi")
    void test_MyAtoi(String str, int expected) {
        int actual = new Solution().myAtoi(str);
        assertEquals(expected, actual, () -> String.format("input:[%s], expected:[%d], actual:[%d]%n%n", str, expected, actual));
    }
}