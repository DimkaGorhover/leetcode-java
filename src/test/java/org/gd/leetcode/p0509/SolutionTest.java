package org.gd.leetcode.p0509;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("LeetCode #509: Fibonacci Number")
class SolutionTest {

    private static Stream<Arguments> args() {

        return IntStream
                .concat(
                        IntStream.rangeClosed(-2, 2),
                        IntStream.rangeClosed(3, 20))
                .mapToObj(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("args")
    void fib(int n) {
        int expected = new BigCacheSolution().fib(n);
        int actual = new DPSolution().fib(n);
        assertEquals(expected, actual);
    }
}