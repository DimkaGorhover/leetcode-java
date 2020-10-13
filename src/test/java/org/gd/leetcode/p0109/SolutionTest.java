package org.gd.leetcode.p0109;

import org.gd.leetcode.common.ListNode;
import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @since 2019-10-02
 */
@DisplayName("LeetCode #109: Convert Sorted List to Binary Search Tree")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        ListNode.of(-10, -3, 0, 5, 9),
                        TreeNode.of(0, -3, 9, -10, null, 5)),
                arguments(
                        ListNode.of(0, 1, 2, 3, 4, 5, 6, 7, 8),
                        TreeNode.of(4, 2, 7, 1, 3, 6, 8, 0, null, null, null, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SortedListToBST")
    void test_SortedListToBST(ListNode list, TreeNode expected) throws Exception {
        assertEquals(expected, new Solution().sortedListToBST(list));
    }
}