package org.gd.leetcode.p0313;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(12, new int[]{2, 7, 13, 19}, 32)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void nthSuperUglyNumber(int n, int[] primes, int expected) {
        assertEquals(expected, new Solution().nthSuperUglyNumber(n, primes));
    }
}