package org.gd.leetcode.p0217;

import org.gd.common.ArrayUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-21
 */
@DisplayName("LeetCode #217: Contains Duplicate")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, true),
                arguments(new int[]{1, 2, 3, 4}, false),
                arguments(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ContainsDuplicate")
    void test_ContainsDuplicate(int[] input, boolean expected) {
        assertEquals(expected, new SortSolution().containsDuplicate(ArrayUtils.copy(input)));
    }

    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HashSetSolution")
    void test_HashSetSolution(int[] input, boolean expected) {
        assertEquals(expected, new HashSetSolution().containsDuplicate(ArrayUtils.copy(input)));
    }

    @Disabled
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TwoPointers")
    void test_TwoPointers(int[] input, boolean expected) {
        assertEquals(expected, new TwoPointersSolution().containsDuplicate(ArrayUtils.copy(input)));
    }
}