package org.gd.leetcode.p1103;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-17
 */
@DisplayName("LeetCode #1103: Distribute Candies to People")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(10, 3, new int[]{5, 2, 3}),
                Arguments.of(7, 4, new int[]{1, 2, 3, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DistributeCandies")
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void test_DistributeCandies(int candies, int num_people, int[] expected) {
        int[] actual = new Solution().distributeCandies(candies, num_people);
        assertEquals(listOf(expected), listOf(actual));
    }
}
