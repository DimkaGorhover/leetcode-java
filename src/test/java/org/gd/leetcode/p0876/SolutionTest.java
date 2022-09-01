package org.gd.leetcode.p0876;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @author Gorkhover D.
 * @since 2018-10-18
 */
@DisplayName("LeetCode #876: Middle of the Linked List")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 3),
                Arguments.of(ListNode.of(1, 2, 3, 4, 5, 6), 4)

        ).map(arguments -> {
            final ListNode root = (ListNode) arguments.get()[0];
            final int value = (int) arguments.get()[1];

            ListNode node = root, middle = null;
            while (node != null) {
                if (node.val == value) {
                    middle = node;
                    break;
                }
                node = node.next;
            }
            return Arguments.of(root, requireNonNull(middle, "middle"));
        });
    }

    @ParameterizedTest
    @MethodSource("args")
    void middleNode(ListNode root, ListNode expected) {
        assertSame(expected, new Solution().middleNode(root));
    }
}