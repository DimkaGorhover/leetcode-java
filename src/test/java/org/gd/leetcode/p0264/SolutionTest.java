package org.gd.leetcode.p0264;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #264: Ugly Number II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(10, 12),
                Arguments.of(100, 1536),
                Arguments.of(13, 18),
                Arguments.of(14, 20),
                Arguments.of(380, 245760)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void nthUglyNumber(int n, int expected) {
        assertEquals(expected, new BigCacheSolution().nthUglyNumber(n));
        assertEquals(expected, new DPSolution().nthUglyNumber(n));
    }

    @Test
    void testAll() {
        for (int n = -100; n <= 1690; n++) {
            int expected = new BigCacheSolution().nthUglyNumber(n);
            assertEquals(expected, new DPSolution().nthUglyNumber(n));
        }
    }
}