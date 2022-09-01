package org.gd.leetcode.p0136;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0137.SolutionTest
 * @since 2020-08-06
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #136: Single Number")
@Timeout(value = 10, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SingleNumber")
    void test_SingleNumber(int[] nums, int expected) {
        assertEquals(expected, new Solution().singleNumber(nums));
    }
}