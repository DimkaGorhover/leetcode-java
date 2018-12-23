package org.gd.leetcode.p0024;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
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
                        ListNode.of(1, 2, 3, 4, 5, 6, 7, 8),
                        ListNode.of(2, 1, 4, 3, 6, 5, 8, 7)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("swapPairs")
    void test_swapPairs(ListNode root, ListNode expected) {
        final ListNode result = new Solution().swapPairs(root);
        assertEquals(
                expected, result,
                () -> String.format("%n%s%n%s%n%s%n%n", expected, root, result));
    }
}