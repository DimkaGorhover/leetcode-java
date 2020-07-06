package org.gd.leetcode.p0147;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #147: Insertion Sort List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of(4, 3, 1, 2, 5),
                        ListNode.rangeClosed(1, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #147: Insertion Sort List")
    void insertionSortList(ListNode head, ListNode expected) {
        var actual = new Solution().insertionSortList(head);
        assertEquals(expected, actual);
    }
}