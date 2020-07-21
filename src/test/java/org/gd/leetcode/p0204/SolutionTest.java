package org.gd.leetcode.p0204;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #204: Count Primes")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(3, 1),
                Arguments.of(4, 2),
                Arguments.of(5, 2),
                Arguments.of(10, 4),
                Arguments.of(1111, 186)
        );
    }

    @ParameterizedTest(name = "n = {0} ==> {1}")
    @MethodSource("args")
    void countPrimes(int n, int expected) {

        int actual = new Solution().countPrimes(n);

        assertEquals(expected, actual);
    }
}