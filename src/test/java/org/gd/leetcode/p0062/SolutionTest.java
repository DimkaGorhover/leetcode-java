package org.gd.leetcode.p0062;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-03
 */
@DisplayName("LeetCode #62: Unique Paths")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(1, 1, 1),
                Arguments.of(3, 2, 3),
                Arguments.of(25, 13, 1_251_677_700),
                Arguments.of(27, 15, 1_732_093_360),
                Arguments.of(7, 3, 28)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("UniquePaths")
    void test_UniquePaths(int m, int n, int expected) {
        assertEquals(expected, new Solution().uniquePaths(m, n));
    }

    @Test
    @DisplayName("Validation")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Validation() {
        assertThrows(IllegalArgumentException.class, () -> new Solution().uniquePaths(1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Solution().uniquePaths(0, 1));
    }
}