package org.gd.leetcode.p0137;

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
 * @see org.gd.leetcode.p0136.SolutionTest
 * @since 2020-08-04
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #136: Single Number II")
@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 3, 2}, 3),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 99}, 99)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SingleNumber")
    void test_SingleNumber(int[] nums, int expected) {
        assertEquals(expected, new Solution().singleNumber(nums));
    }
}