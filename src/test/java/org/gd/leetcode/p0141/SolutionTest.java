package org.gd.leetcode.p0141;

import org.gd.leetcode.common.ListNode;
import org.gd.leetcode.p0141.Solution.SolutionProvider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-01
 */
@DisplayName("LeetCode #141: Linked List Cycle")
class SolutionTest {

    private static Stream<Arguments> args() {

        ListNode n1 = ListNode.of(1);
        ListNode n2 = n1.next = ListNode.of(2);
        ListNode n3 = n2.next = ListNode.of(3);
        ListNode n4 = n3.next = ListNode.of(4);

        ListNode head0 = n1.copy();

        n4.next = n3;

        Stream<Supplier<SolutionProvider>> solutionsStream = Stream.of(
                Solution.HashTableSolution::new,
                Solution.TwoPointersSolution::new);

        return solutionsStream.flatMap(solution -> Stream.of(
                Arguments.of(solution, head0, false),
                Arguments.of(solution, n1, true)
        ));

    }

    @ParameterizedTest
    @MethodSource("args")
    void test_HasCycle(Supplier<SolutionProvider> solution,
                       ListNode head,
                       boolean expected) {

        try {
            assertEquals(expected, solution.get().hasCycle(head));
        } catch (Throwable e) {

            System.out.println(solution.get().getClass());

            throw e;
        }
    }
}