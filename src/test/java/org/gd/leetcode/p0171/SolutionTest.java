package org.gd.leetcode.p0171;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0168.SolutionTest
 * @since 2019-10-04
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #171: Excel Sheet Column Number")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of("AZ", 52),
                Arguments.of("A", 1),
                Arguments.of("B", 2),
                Arguments.of("C", 3),
                Arguments.of("Z", 26),
                Arguments.of("AA", 27),
                Arguments.of("AB", 28),
                Arguments.of("ZY", 701),
                Arguments.of("JIQ", 7011)
        );
    }

    @ParameterizedTest(name = "excel column: {0} --> {1}")
    @MethodSource("args")
    @DisplayName("Excel Sheet Column Number")
    void test_TitleToNumber(String str, int expected) {
        final int actual = new Solution().titleToNumber(str);
        assertEquals(expected, actual, () -> String.format("input: %s, expected: %d, actual: %d", str, expected, actual));
    }
}
