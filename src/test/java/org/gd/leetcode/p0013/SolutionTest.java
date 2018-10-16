package org.gd.leetcode.p0013;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments("III", 3),
                Arguments.arguments("IV", 4),
                Arguments.arguments("IX", 9),
                Arguments.arguments("LVIII", 58),
                Arguments.arguments("DCCIX", 709),
                Arguments.arguments("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("RomanToInt")
    void test_RomanToInt(String roman, int expected) {
        assertEquals(expected, new Solution().romanToInt(roman));
    }
}