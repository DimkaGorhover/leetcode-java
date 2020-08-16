package org.gd.leetcode.p0160;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-16
 */
@DisplayName("LeetCode #160: Intersection of Two Linked Lists")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {

        Stream<Supplier<Arguments>> stream = Stream.of(

                () -> {
                    ListNode c = ListNode.of(8, 4, 5);
                    ListNode a = ListNode.concat(ListNode.of(4, 1), c);
                    ListNode b = ListNode.concat(ListNode.of(5, 6, 1), c);
                    return Arguments.of(a, b, c);
                },

                () -> {
                    ListNode c = ListNode.of(2, 4);
                    ListNode a = ListNode.concat(ListNode.of(1, 9, 1), c);
                    ListNode b = ListNode.concat(ListNode.of(3), c);
                    return Arguments.of(a, b, c);
                },

                () -> {
                    ListNode c = ListNode.rangeClosed(100, 200);
                    ListNode a = ListNode.concat(ListNode.rangeClosed(50, 99), c);
                    ListNode b = ListNode.concat(ListNode.rangeClosed(70, 90), c);
                    return Arguments.of(a, b, c);
                },

                () -> {
                    ListNode a = ListNode.of(4, 1);
                    ListNode b = ListNode.of(5, 6, 1);
                    return Arguments.of(a, b, null);
                },

                () -> {
                    ListNode a = ListNode.of(2, 6, 4);
                    ListNode b = ListNode.of(1, 5);
                    return Arguments.of(a, b, null);
                }
        );

        return stream.map(Supplier::get);
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("Hash Table Solution")
    void test_001(ListNode headA, ListNode headB, ListNode expected) {

        assertSame(expected, new HashTableSolution().getIntersectionNode(headA, headB));
    }

    @ParameterizedTest(name = "{displayName} #{index}")
    @MethodSource("args")
    @DisplayName("Two Pointers Solution")
    void test_002(ListNode headA, ListNode headB, ListNode expected) {

        assertSame(expected, new TwoPointersSolution().getIntersectionNode(headA, headB));
    }
}
