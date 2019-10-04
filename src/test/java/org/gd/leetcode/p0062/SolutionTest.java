package org.gd.leetcode.p0062;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-03
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(3, 2, 3),
                arguments(25, 13, 1251677700),
                arguments(7, 3, 28)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("UniquePaths")
    void test_UniquePaths(int m, int n, int expected) throws Exception {
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }
}