package org.gd.leetcode.p0217;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-21
 */
@DisplayName("LeetCode #217: Contains Duplicate")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ContainsDuplicate")
    void test_ContainsDuplicate(int[] input, boolean expected) {
        assertEquals(expected, new SortSolution().containsDuplicate(input));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HashSetSolution")
    void test_HashSetSolution(int[] input, boolean expected) {
        assertEquals(expected, new HashSetSolution().containsDuplicate(input));
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TwoPointers")
    void test_TwoPointers(int[] input, boolean expected) {
        assertEquals(expected, new TwoPointersSolution().containsDuplicate(input));
    }
}
