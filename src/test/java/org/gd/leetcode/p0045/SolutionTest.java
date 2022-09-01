package org.gd.leetcode.p0045;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.gd.leetcode.common.ArrayUtils.copy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0055.SolutionTest
 * @see org.gd.leetcode.p1306.SolutionTest
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #45: Jump Game II")
@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}, 2),
                Arguments.of(new int[]{1, 2, 3, 4}, 2),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.of(new int[]{1, 1, 1, 1}, 3),
                Arguments.of(new int[]{2, 3, 1}, 1),
                Arguments.of(new int[]{2, 3, 1, 1, 4}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Jump")
    void test_Jump(int[] nums, int expected) {
        assertEquals(expected, new Solution().jump(copy(nums)));
    }
}