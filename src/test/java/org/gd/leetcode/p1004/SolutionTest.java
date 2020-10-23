package org.gd.leetcode.p1004;

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
 * @see org.gd.leetcode.p0485.SolutionTest
 * @since 2020-10-23
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #1004: Max Consecutive Ones III")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 0, 0}, 0, 3),
                Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LongestOnes")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_LongestOnes(int[] A, int K, int expected) {
        assertEquals(expected, new Solution().longestOnes(A, K));
    }
}
