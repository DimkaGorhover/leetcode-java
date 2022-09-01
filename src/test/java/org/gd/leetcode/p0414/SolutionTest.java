package org.gd.leetcode.p0414;

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
 * @since 2020-08-02
 */
@DisplayName("LeetCode #414: Third Maximum Number")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, -2147483648}, -2147483648),
                Arguments.of(new int[]{1, 2, 2, 5, 3, 5}, 2),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{1, 1, 1}, 1),
                Arguments.of(new int[]{3, 2, 1}, 1),
                Arguments.of(new int[]{2, 2, 3, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ThirdMax")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_ThirdMax(int[] nums, int expected) {
        assertEquals(expected, new Solution().thirdMax(nums));
    }
}