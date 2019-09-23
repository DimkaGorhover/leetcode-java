package org.gd.hackerrank.other;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link TimeConversion}
 *
 * @since 2019-09-23
 */
class TimeConversionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("07:05:45PM", "19:05:45"),
                arguments("12:05:45PM", "12:05:45"),
                arguments("12:05:45AM", "00:05:45")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TimeConversion")
    void test_TimeConversion(String input, String expected) throws Exception {
        assertEquals(expected, TimeConversion.timeConversion(input));
    }
}