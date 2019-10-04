package org.gd.leetcode.p0171;

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
 * @see org.gd.leetcode.p0168.SolutionTest
 * @since 2019-10-04
 */
@SuppressWarnings("JavadocReference")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("AZ", 52),
                arguments("A", 1),
                arguments("B", 2),
                arguments("C", 3),
                arguments("Z", 26),
                arguments("AA", 27),
                arguments("AB", 28),
                arguments("ZY", 701),
                arguments("JIQ", 7011)
        );
    }

    @ParameterizedTest(name = "excel column: {0} --> {1}")
    @MethodSource("args")
    @DisplayName("TitleToNumber")
    void test_TitleToNumber(String str, int expected) throws Exception {
        int actual = new Solution().titleToNumber(str);
        assertEquals(expected, actual, () -> String.format("input: %s, expected: %d, actual: %d", str, expected, actual));
    }
}
