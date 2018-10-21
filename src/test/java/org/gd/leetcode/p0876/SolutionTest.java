package org.gd.leetcode.p0876;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * @author Gorkhover D.
 * @since 2018-10-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.arguments(new int[]{1, 2, 3, 4, 5}, 3),
                Arguments.arguments(new int[]{1, 2, 3, 4, 5, 6}, 4)

        ).map(arguments -> {
            final ListNode root  = ListNode.of((int[]) arguments.get()[0]);
            final int      value = (int) arguments.get()[1];

            ListNode node = root, middle = null;
            while (node != null) {
                if (node.val == value)
                    middle = node;
                node = node.next;
            }
            requireNonNull(middle, "middle");
            return Arguments.arguments(root, middle);
        });
    }

    @ParameterizedTest
    @MethodSource("args")
    void middleNode(ListNode root, ListNode expected) {
        assertSame(expected, new Solution().middleNode(root));
    }
}