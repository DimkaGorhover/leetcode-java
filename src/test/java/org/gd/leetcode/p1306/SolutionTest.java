package org.gd.leetcode.p1306;

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
 * @see org.gd.leetcode.p0045.SolutionTest
 * @see org.gd.leetcode.p0055.SolutionTest
 * @since 2020-08-03
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #1306: Jump Game III")
@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true),
                Arguments.of(new int[]{0, 0}, 0, true),
                Arguments.of(new int[]{3, 0, 2, 1, 2}, 2, false),
                Arguments.of(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CanReach")
    void test_CanReach(int[] arr, int start, boolean expected) {
        assertEquals(expected, new Solution().canReach(copy(arr), start));
    }
}