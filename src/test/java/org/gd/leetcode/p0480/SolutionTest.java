package org.gd.leetcode.p0480;

import lombok.var;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-22
 */
@DisplayName("LeetCode #480: Sliding Window Median")
class SolutionTest {

    private static List<Double> toList(double[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                        3,
                        new double[]{1, -1, -1, 3, 5, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MedianSlidingWindow")
    void test_MedianSlidingWindow(int[] nums, int k, double[] expected) {
        double[] actual = new Solution().medianSlidingWindow(nums, k);
        assertEquals(toList(expected), toList(actual));
    }

    @Test
    @DisplayName("SortedList")
    void test_SortedList() {
        var sortedList = new SortedList(new int[]{1, 2, 3, 4, 5}, 5);
        assertEquals("[1, 2, 3, 4, 5]", sortedList.toString());
        sortedList.replace(4, 6);
        assertEquals("[1, 2, 3, 5, 6]", sortedList.toString());
    }
}