package org.gd.leetcode.p0046;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-09-20
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(new int[]{1, 2}, List.of(
                        List.of(1, 2),
                        List.of(2, 1)
                )),
                arguments(new int[]{1, 2, 3}, List.of(
                        List.of(1, 2, 3),
                        List.of(1, 3, 2),
                        List.of(2, 1, 3),
                        List.of(2, 3, 1),
                        List.of(3, 1, 2),
                        List.of(3, 2, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Permute")
    void test_Permute(int[] nums, List<List<Integer>> expected) throws Exception {
        assertEquals(expected, new Solution().permute(nums));
    }
}