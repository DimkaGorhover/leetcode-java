package org.gd.leetcode.p0034;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-20
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SearchRange")
    void test_SearchRange(int[] input, int target, int[] expected) {
        assertEquals(
                listOf(expected),
                listOf(new Solution().searchRange(input, target))
        );
    }
}