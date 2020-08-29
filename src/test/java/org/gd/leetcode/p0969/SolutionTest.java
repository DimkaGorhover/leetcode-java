package org.gd.leetcode.p0969;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-29
 */
@DisplayName("LeetCode #969: Pancake Sorting")
class SolutionTest {

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 4, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PancakeSort")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_PancakeSort(int[] arr) {
        List<Integer> actual = new Solution().pancakeSort(arr);
        assertTrue(Solution.isSorted(arr));
        assertTrue(actual.size() < 10 * arr.length);
    }
}
