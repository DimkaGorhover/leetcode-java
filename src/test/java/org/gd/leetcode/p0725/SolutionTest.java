package org.gd.leetcode.p0725;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@DisplayName("LeetCode #725: Split Linked List in Parts")
@Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        ListNode.of(0, 1), 2,
                        new ListNode[]{
                                ListNode.of(0),
                                ListNode.of(1)
                        }),

                Arguments.of(
                        ListNode.of(1, 2, 3), 5,
                        new ListNode[]{
                                ListNode.of(1),
                                ListNode.of(2),
                                ListNode.of(3),
                                null,
                                null
                        }),

                Arguments.of(
                        ListNode.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3,
                        new ListNode[]{
                                ListNode.of(1, 2, 3, 4),
                                ListNode.of(5, 6, 7),
                                ListNode.of(8, 9, 10)
                        })
        );
    }

    @SuppressWarnings("deprecation")
    private static List<List<Integer>> toList(ListNode[] arr) {
        return Arrays.stream(arr)
                .map(ListNode::listValues)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SplitListToParts")
    void test_SplitListToParts(ListNode root, int k, ListNode[] expected) {
        assertEquals(
                toList(expected),
                toList(new Solution().splitListToParts(root, k)));
    }
}
