package org.gd.leetcode.p0015;

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
 * @author Horkhover D.
 * @since 2020-07-08
 */
@DisplayName("LeetCode #15: 3sum")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new int[]{-1, 0, 1, 2, -1, -4},
                        List.of(
                                List.of(-1, 0, 1),
                                List.of(-1, -1, 2)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Solution")
    void test_ThreeSum(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, new Solution().threeSum(nums));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Fastest Solution")
    void test_Name(int[] nums, List<List<Integer>> expected) {
        assertEquals(expected, new FastestSolution().threeSum(nums));
    }
}