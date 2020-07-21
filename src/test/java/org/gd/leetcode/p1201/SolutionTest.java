package org.gd.leetcode.p1201;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(3, Primes.of(2, 3, 5), 4),
                Arguments.of(4, Primes.of(2, 3, 4), 6),
                Arguments.of(5, Primes.of(2, 11, 13), 10),
                Arguments.of(1_000_000_000, Primes.of(2, 217_983_653, 336_916_467), 1_999_999_984)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void nthUglyNumber(int n, Primes primes, int expected) {
        int actual = new Solution().nthUglyNumber(n, primes.a, primes.b, primes.c);
        assertEquals(expected, actual);
    }

    @RequiredArgsConstructor(staticName = "of")
    static class Primes {

        final int a, b, c;

        @Override
        public String toString() {
            return String.format("[%d, %d, %d]", a, b, c);
        }
    }
}