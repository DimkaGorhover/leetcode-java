package org.gd.leetcode.p0023;

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
 * @see org.gd.leetcode.p0021.SolutionTest
 * @since 2019-09-10
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #23: Merge K Sorted Lists")
class SolutionTest {

    @SuppressWarnings("deprecation")
    private static ListNode[] copy(ListNode[] lists) {
        ListNode[] newLists = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            newLists[i] = lists[i].copy();
        }
        return newLists;
    }

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        new ListNode[]{
                                ListNode.of("1->4->5"),
                                ListNode.of("1->3->4"),
                                ListNode.of("2->6")
                        },
                        ListNode.of("1->1->2->3->4->4->5->6"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MergeKLists")
    void test_MergeKLists(ListNode[] lists, ListNode expected) {
        assertEquals(expected, new Solution().mergeKLists(copy(lists)));
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PriorityQ")
    void test_PriorityQ(ListNode[] lists, ListNode expected) {
        assertEquals(expected, new ReduceSolution().mergeKLists(copy(lists)));
    }
}