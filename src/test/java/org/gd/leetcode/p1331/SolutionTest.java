package org.gd.leetcode.p1331;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.CollectionUtils.listOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-11-18
 */
@DisplayName("LeetCode #1331: Rank Transform of an Array")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{16, 43}, java.util.Arrays.asList(1, 2)),
                Arguments.of(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12}, java.util.Arrays.asList(5, 3, 4, 2, 8, 6, 7, 1, 3)),
                Arguments.of(new int[]{40, 10, 20, 30}, java.util.Arrays.asList(4, 1, 2, 3)),
                Arguments.of(new int[]{100, 100, 100}, java.util.Arrays.asList(1, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SortSolution")
    void test_SortSolution(int[] arr, List<Integer> expected) {
        var actual = listOf(new SortSolution().arrayRankTransform(arr));
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LinearSolution")
    void test_LinearSolution(int[] arr, List<Integer> expected) {
        var actual = listOf(new LinearSolution().arrayRankTransform(arr));
        assertEquals(expected, actual);
    }
}
