package org.gd.leetcode.p0123;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@DisplayName("LeetCode #123: Best Time to Buy and Sell Stock III")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4),
                Arguments.of(new int[]{3, 3, 5, 0, 0, 3, 1, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Reference 1")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_001(int[] prices, int expected) {
        assertEquals(expected, new Reference1Solution().maxProfit(prices));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Reference 2")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_002(int[] prices, int expected) {
        assertEquals(expected, new Reference2Solution().maxProfit(prices));
    }
}
