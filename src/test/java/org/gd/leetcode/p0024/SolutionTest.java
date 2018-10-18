package org.gd.leetcode.p0024;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gorkhover D.
 * @since 2018-10-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        toListNode(1, 2, 3, 4, 5, 6, 7, 8),
                        toListNode(2, 1, 4, 3, 6, 5, 8, 7)
                )
        );
    }

    private static ListNode toListNode(int... values) {
        requireNonNull(values, "values");
        ListNode root = new ListNode(values[0]), node = root, tmp;
        for (int i = 1; i < values.length; i++) {
            tmp = new ListNode(values[i]);
            node.next = tmp;
            node = tmp;
        }
        return root;

    }

    @ParameterizedTest
    @MethodSource("args")
    void swapPairs(ListNode root, ListNode expected) {
        final ListNode result = new Solution().swapPairs(root);
        assertEquals(
                expected, result,
                () -> String.format("%n%s%n%s%n%s%n%n", expected.toPrettyString(), root.toPrettyString(), result.toPrettyString()));
    }
}