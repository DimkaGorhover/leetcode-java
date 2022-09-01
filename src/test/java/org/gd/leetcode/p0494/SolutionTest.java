package org.gd.leetcode.p0494;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-17
 */
@DisplayName("LeetCode #494: Target Sum")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 0}, 1, 2),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 3, 5),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0, 1_048_576)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindTargetSumWays")
    void test_FindTargetSumWays(int[] nums, int target, int expected) {
        int actual = new Solution().findTargetSumWays(nums, target);
        assertEquals(expected, actual);
    }
}
