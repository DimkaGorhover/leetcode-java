package org.gd.leetcode.p0067;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("1111", "1111", "11110"),
                arguments("11", "1", "100"),
                arguments("10", "1", "11"),
                arguments("1010", "1011", "10101")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void addBinary(String v1, String v2, String expected) {
        assertEquals(
                expected,
                new Solution().addBinary(v1, v2)
        );
    }
}