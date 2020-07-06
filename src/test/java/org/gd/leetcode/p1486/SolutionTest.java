package org.gd.leetcode.p1486;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LeetCode #1489: Xor Operation In An Array")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(5, 0, 8),
                Arguments.of(4, 3, 8),
                Arguments.of(1, 7, 7),
                Arguments.of(10, 5, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #1489: Xor Operation In An Array")
    void xorOperation(int n, int start, int expected) {
        int actual = new Solution().xorOperation(n, start);
        assertEquals(expected, actual);
    }
}