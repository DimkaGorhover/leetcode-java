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
class SolutionTest {

    private static Stream<Arguments> arguments() {
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
    @MethodSource("arguments")
    @DisplayName("MergeKLists")
    void test_MergeKLists(ListNode[] lists, ListNode expected) throws Exception {
        assertEquals(expected, new Solution().mergeKLists(lists));
    }
}