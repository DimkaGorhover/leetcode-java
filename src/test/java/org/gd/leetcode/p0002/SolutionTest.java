package org.gd.leetcode.p0002;

import lombok.NonNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution};
 *
 * @author Gorkhover D.
 * @since 2018-10-16
 */
class SolutionTest {

    private static ListNode listNode(int... values) {
        final int length = values.length;
        switch (length) {
            case 0: throw new IllegalArgumentException();
            case 1: return new ListNode(values[0]);
        }
        final ListNode head     = new ListNode(values[0]);
        ListNode       listNode = head, tmp;
        for (int i = 1; i < values.length; i++) {
            tmp = new ListNode(values[i]);
            listNode.next = tmp;
            listNode = tmp;
        }
        return head;
    }

    @NonNull
    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
                Arguments.arguments(
                        listNode(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1),
                        listNode(5, 6, 4),
                        listNode(6, 6, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1)
                ),
                Arguments.arguments(
                        listNode(9),
                        listNode(1, 9, 9, 9, 9, 9, 9, 9, 9, 9),
                        listNode(1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
                ),
                Arguments.arguments(
                        listNode(0),
                        listNode(0),
                        listNode(0)
                ),
                Arguments.arguments(
                        listNode(2, 4, 3),
                        listNode(5, 6, 4),
                        listNode(8, 0, 7)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsStream")
    @DisplayName("AddTwoNumbers")
    void test_AddTwoNumbers(@NonNull ListNode l1,
                            @NonNull ListNode l2,
                            @NonNull ListNode expected) {
        assertEquals(expected, new Solution().addTwoNumbers(l1, l2));
    }
}