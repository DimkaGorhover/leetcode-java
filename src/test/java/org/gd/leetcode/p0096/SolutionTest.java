package org.gd.leetcode.p0096;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0206.SolutionTest
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #96: Reverse Linked List 2")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.rangeClosed(1, 5), 3, 4,
                        ListNode.of(1, 2, 4, 3, 5)),
                Arguments.of(
                        ListNode.of(3, 5, 4, 8), 1, 2,
                        ListNode.of(5, 3, 4, 8)),
                Arguments.of(
                        ListNode.of(3, 5), 1, 2,
                        ListNode.of(5, 3)),
                Arguments.of(
                        ListNode.rangeClosed(1, 9), 2, 4,
                        ListNode.of(1, 4, 3, 2, 5, 6, 7, 8, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #96: Reverse Linked List 2")
    void reverseBetween(ListNode head, int m, int n, ListNode expected) {
        ListNode actual = new Solution().reverseBetween(head, m, n);
        assertEquals(expected, actual);
    }
}