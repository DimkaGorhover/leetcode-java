package org.gd.leetcode.p1535;

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
 * @since 2020-08-03
 */
@DisplayName("LeetCode #1535: Find the Winner of an Array Game")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 25, 35, 42, 68, 70}, 2, 70),
                Arguments.of(new int[]{2, 1, 3, 5, 4, 6, 7}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("GetWinner")
    @Timeout(value = 20, unit = TimeUnit.MILLISECONDS)
    void test_GetWinner(int[] arr, int k, int expected) {
        assertEquals(expected, new Solution().getWinner(arr, k));
    }
}