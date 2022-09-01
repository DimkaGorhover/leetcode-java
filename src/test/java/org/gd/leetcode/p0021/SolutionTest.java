package org.gd.leetcode.p0021;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-11-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        ListNode.of("1->2->4"),
                        ListNode.of("1->3->4"),
                        ListNode.of("1->1->2->3->4->4")
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("MergeTwoLists")
    void test_MergeTwoLists(ListNode l1, ListNode l2, ListNode expected) {
        assertEquals(
                expected,
                new Solution().mergeTwoLists(l1, l2)
        );
    }
}