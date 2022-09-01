package org.gd.leetcode.p0162;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-07-23
 */
@DisplayName("LeetCode #162: Find Peak Element")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, org.gd.leetcode.common.CollectionUtils.setOf(2)),
                Arguments.of(new int[]{1, 2, 1, 3, 5, 6, 4}, org.gd.leetcode.common.CollectionUtils.setOf(1, 5)),
                Arguments.of(new int[]{1}, org.gd.leetcode.common.CollectionUtils.setOf(0)),
                Arguments.of(new int[]{1, 2}, org.gd.leetcode.common.CollectionUtils.setOf(1)),
                Arguments.of(new int[]{3, 2, 1}, org.gd.leetcode.common.CollectionUtils.setOf(0))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("FindPeakElement")
    void test_FindPeakElement(int[] nums, Set<Integer> expected) {
        int actual = new Solution().findPeakElement(nums);
        assertTrue(expected.contains(actual));
    }
}