package org.gd.leetcode.p0060;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-21
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(3, 3, "213"),
                arguments(4, 9, "2314")
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetPermutation")
    void test_GetPermutation(int n, int k, String expected) {
        assertEquals(expected, new Solution().getPermutation(n, k));
    }
}