package org.gd.leetcode.p0264;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(10, 12),
                Arguments.of(100, 1536),
                Arguments.of(13, 18),
                Arguments.of(14, 20),
                Arguments.of(340, 147456)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void nthUglyNumber(int n, int expected) {
        assertEquals(expected, new DPSolution().nthUglyNumber(n));
        assertEquals(expected, new BigCacheSolution().nthUglyNumber(n));
    }
}