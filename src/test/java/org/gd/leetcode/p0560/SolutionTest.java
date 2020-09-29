package org.gd.leetcode.p0560;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-29
 */
@DisplayName("Test for org.gd.leetcode.p0560.Solution")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{-1, -1, 1}, 0, 1),
                Arguments.of(new int[]{1, 1, 1}, 2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SubarraySum")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_SubarraySum(int[] nums, int k, int expected) {
        assertEquals(expected, new Solution().subarraySum(nums, k));
    }
}
