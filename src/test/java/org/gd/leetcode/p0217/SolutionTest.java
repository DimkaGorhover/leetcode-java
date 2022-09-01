package org.gd.leetcode.p0217;

import lombok.var;
import org.gd.leetcode.common.ArrayUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                Arguments.of(new int[]{1, 2, 3, 1}, true),
                Arguments.of(new int[]{1, 2, 3, 4}, false),
                Arguments.of(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true)
        );
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ContainsDuplicate")
    void test_ContainsDuplicate(int[] input, boolean expected) {
        var solution = new SortSolution();
        assertEquals(expected, solution.containsDuplicate(ArrayUtils.copy(input)));
    }

    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HashSetSolution")
    void test_HashSetSolution(int[] input, boolean expected) {
        var solution = new HashSetSolution();
        assertEquals(expected, solution.containsDuplicate(ArrayUtils.copy(input)));
    }

    @Disabled
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("TwoPointers")
    void test_TwoPointers(int[] input, boolean expected) {
        var solution = new TwoPointersSolution();
        assertEquals(expected, solution.containsDuplicate(ArrayUtils.copy(input)));
    }
}
