package org.gd.leetcode.p0377;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0039.SolutionTest
 * @see org.gd.leetcode.p0040.SolutionTest
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #377: Combination Sum IV")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 4, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #377: Combination Sum IV")
    void combinationSum4(int[] nums, int target, int expected) {
        int actual = new Solution().combinationSum4(nums, target);
        assertEquals(expected, actual);
    }
}