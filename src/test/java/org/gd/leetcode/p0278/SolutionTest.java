package org.gd.leetcode.p0278;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-15
 */
@DisplayName("LeetCode #278: First Bad Version")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(1_000_000, 4_573),
                Arguments.of(5, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FirstBadVersion")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FirstBadVersion(int n, final int expected) {

        var solution = new Solution() {

            @Override
            boolean isBadVersion(int version) { return version >= expected; }
        };

        assertEquals(expected, solution.firstBadVersion(n));
    }
}
