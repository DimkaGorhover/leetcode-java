package org.gd.leetcode.p0005;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments("1234567890ABCDEF", 4, "17C")
                //Arguments.arguments("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                //Arguments.arguments("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Convert")
    void test_Convert(String input, int numRows, String expected) {
    }
}