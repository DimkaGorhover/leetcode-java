package org.gd.leetcode.p0445;

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
@DisplayName("LeetCode #445: Add Two Numbers II")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        ListNode.of(1),
                        ListNode.of(9, 9),
                        ListNode.of(1, 0, 0)),
                Arguments.of(
                        ListNode.of(5),
                        ListNode.of(5),
                        ListNode.of(1, 0)),
                Arguments.of(
                        ListNode.of(7, 2, 4, 3),
                        ListNode.of(5, 6, 4),
                        ListNode.of(7, 8, 0, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode expected) {
        ListNode actual = new Solution().addTwoNumbers(l1, l2);
        assertEquals(expected, actual);
    }
}