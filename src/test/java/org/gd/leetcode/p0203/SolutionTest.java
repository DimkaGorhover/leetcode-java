package org.gd.leetcode.p0203;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @since 2019-08-23
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(
                        ListNode.of("1->2->6->3->4->5->6"),
                        6,
                        ListNode.of("1->2->3->4->5")
                ),
                Arguments.arguments(
                        ListNode.of("1->2->2->1"),
                        2,
                        ListNode.of("1->1")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("removeElements")
    void removeElements(ListNode input, int val, ListNode expected) {
        assertEquals(
                expected,
                new Solution().removeElements(input, val)
        );
    }
}