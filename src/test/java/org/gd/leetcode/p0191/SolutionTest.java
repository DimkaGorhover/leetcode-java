package org.gd.leetcode.p0191;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-09.07.2020
 */
@DisplayName("LeetCode #191: Number of 1 Bits")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(6, 2),
                Arguments.of(7, 3),
                Arguments.of(8, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #191: Number of 1 Bits")
    void test_HammingWeight(int n, int expected) {
        int actual = new Solution().hammingWeight(n);
        assertEquals(expected, actual);
    }
}