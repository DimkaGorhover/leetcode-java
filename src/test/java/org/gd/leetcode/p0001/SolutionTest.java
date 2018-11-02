package org.gd.leetcode.p0001;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.gd.common.CollectionUtils.toList;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-11-02
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TwoSum")
    void test_TwoSum(int[] input, int target, int[] expected) {
        assertEquals(
                toList(expected),
                toList(new Solution().twoSum(input, target))
        );
    }
}