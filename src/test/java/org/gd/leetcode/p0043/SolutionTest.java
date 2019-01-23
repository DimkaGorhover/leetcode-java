package org.gd.leetcode.p0043;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gorkhover D.
 * @since 2018-10-22
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments("2", "3"),
                arguments("123", "456")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void multiply(String v1, String v2) {
        assertEquals(
                new BigInteger(v1, 10).multiply(new BigInteger(v2, 10)).toString(10),
                new Solution().multiply(v1, v2));
    }
}