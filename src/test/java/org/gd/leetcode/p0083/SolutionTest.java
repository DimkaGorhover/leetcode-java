package org.gd.leetcode.p0083;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-21
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(listNodes(1, 1, 2), listNodes(1, 2)),
                arguments(listNodes(1, 1, 2, 3, 3), listNodes(1, 2, 3))
        );
    }

    private static ListNode listNodes(int... values) {
        ListNode head = new ListNode(values[0]);
        ListNode node = head;
        for (int i = 1; i < values.length; i++) {
            ListNode tmp = new ListNode(values[i]);
            node.next = tmp;
            node = tmp;
        }
        return head;
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("DeleteDuplicates")
    void test_DeleteDuplicates(ListNode input, ListNode expected) {
        assertEquals(expected, new Solution().deleteDuplicates(input));
    }
}