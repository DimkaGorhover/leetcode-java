package org.gd.leetcode.p0206;

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
 * @see org.gd.leetcode.p0096.Solution
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #206: Reverse Linked List")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of(1, 2, 3, 4, 5),
                        ListNode.of(5, 4, 3, 2, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void reverseList(ListNode head, ListNode expected) {
        ListNode actual = new Solution().reverseList(head);
        assertEquals(expected, actual);
    }
}