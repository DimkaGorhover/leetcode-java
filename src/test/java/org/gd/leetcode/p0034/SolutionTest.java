package org.gd.leetcode.p0034;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
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

    private static List<Integer> toList(int[] ints) {
        return Arrays.stream(ints)
                .boxed()
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SearchRange")
    void test_SearchRange(int[] input, int target, int[] expected) {
        assertEquals(
                toList(expected),
                toList(new Solution().searchRange(input, target))
        );
    }
}