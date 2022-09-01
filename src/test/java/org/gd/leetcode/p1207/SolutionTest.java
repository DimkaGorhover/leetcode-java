package org.gd.leetcode.p1207;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-04
 */
@Execution(ExecutionMode.CONCURRENT)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1, 1, 3}, true),
                Arguments.of(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true),
                Arguments.of(new int[]{26, 2, 16, 16, 5, 5, 26, 2, 5, 20, 20, 5, 2, 20, 2, 2, 20, 2, 16, 20, 16, 17, 16, 2, 16, 20, 26, 16}, false),
                Arguments.of(new int[]{1, 2}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #1207: Unique Number of Occurrences")
    void test_UniqueOccurrences(int[] arr, boolean expected) throws Exception {
        assertEquals(expected, new Solution().uniqueOccurrences(arr));
    }
}