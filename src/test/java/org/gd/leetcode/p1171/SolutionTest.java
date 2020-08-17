package org.gd.leetcode.p1171;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-17
 */
    @DisplayName("LeetCode #1171: Remove Zero Sum Consecutive Nodes from Linked List")
@Timeout(value = 100, unit = java.util.concurrent.TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(ListNode.of(1, 2, 3, -3, -2), Set.of(
                        ListNode.of(1)
                )),

                Arguments.of(ListNode.of(1, 2, 3, -3, 4), Set.of(
                        ListNode.of(1, 2, 4)
                )),

                Arguments.of(ListNode.of(1, 2, -3, 3, 1), Set.of(
                        ListNode.of(3, 1),
                        ListNode.of(1, 2, 1)
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("RemoveZeroSumSublists")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_RemoveZeroSumSublists(ListNode head, Set<ListNode> expected) {

        //noinspection deprecation
        final ListNode actual = new Solution().removeZeroSumSublists(head.copy());

        assertTrue(expected.contains(actual), () -> {
            StringBuilder sb = new StringBuilder();
            sb.append("\nactual = ").append(actual).append("\n\n");
            sb.append("expected = [\n");
            expected.forEach(node -> sb.append(node).append('\n'));
            sb.append("]");
            return sb.toString();
        });
    }
}
