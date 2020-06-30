package org.gd.leetcode.p0121;

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
 * @since 2020-06-30
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #121: Best Time to Buy and Sell Stock")
    void test_MaxProfit(int[] prices, int expected) {
        assertEquals(expected, new Solution().maxProfit(prices));
        assertEquals(expected, new LinearSolution().maxProfit(prices));
    }
}