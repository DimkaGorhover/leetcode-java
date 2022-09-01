package org.gd.leetcode.p0347;

import org.gd.leetcode.common.CollectionUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-10
 */
@DisplayName("LeetCode #347: Top K Frequent Elements")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2})
        );
    }

    private static List<Integer> listOf(int[] arr) {
        Arrays.sort(arr);
        return CollectionUtils.listOf(arr);
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("O( N )")
    void test_LinkedListSolution(int[] nums, int k, int[] expected) {
        assertEquals(listOf(expected), listOf(new LinkedListSolution().topKFrequent(nums, k)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("O( N * Log(N) )")
    void test_SortSolution(int[] nums, int k, int[] expected) {
        assertEquals(listOf(expected), listOf(new SortSolution().topKFrequent(nums, k)));
    }
}