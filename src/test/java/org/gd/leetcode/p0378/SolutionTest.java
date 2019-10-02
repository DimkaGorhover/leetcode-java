package org.gd.leetcode.p0378;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-01
 */
class SolutionTest {

    private static Stream<Arguments> args() {

        int[][] arr1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15},
        };

        return IntStream.of(6, 7, 9)
                .mapToObj(index -> arguments(arr1, index));
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("KthSmallest")
    void test_KthSmallest(int[][] matrix, int k) throws Exception {

        int expected = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .getAsInt();

        int actual = new Solution().kthSmallest(matrix, k);

        assertEquals(expected, actual);
    }
}