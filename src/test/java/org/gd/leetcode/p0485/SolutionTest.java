package org.gd.leetcode.p0485;

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
 * @see org.gd.leetcode.p1004.SolutionTest
 * @since 2020-10-23
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #485: Max Consecutive Ones")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 0, 1, 1, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindMaxConsecutiveOnes")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_FindMaxConsecutiveOnes(int[] nums, int expected) {
        assertEquals(expected, new Solution().findMaxConsecutiveOnes(nums));
    }
}
