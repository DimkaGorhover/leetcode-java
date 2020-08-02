package org.gd.leetcode.p0023;

import org.gd.leetcode.common.ListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @see org.gd.leetcode.p0021.SolutionTest
 * @since 2019-09-10
 */
@SuppressWarnings("JavadocReference")
@DisplayName("LeetCode #23: Merge K Sorted Lists")
class SolutionTest {

    @SuppressWarnings("deprecation")
    private static ListNode[] copy(ListNode[] lists) {
        ListNode[] newLists = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            newLists[i] = ListNode.copy(lists[i]);
        }
        return newLists;
    }

    private static Stream<Arguments> args() {

        return Stream.of(new BigHeapSolutionFactory(), new HeapSolutionFactory(), new OopHeapSolutionFactory())
                .flatMap(sf -> Stream.of(

                        Arguments.of(sf,
                                new ListNode[]{
                                        ListNode.of("1->4->5"),
                                        null,
                                        ListNode.of("2->6")
                                },
                                ListNode.of("1->2->4->5->6")),

                        Arguments.of(sf,
                                new ListNode[]{
                                        ListNode.of("1->4->5"),
                                        ListNode.of("1->3->4"),
                                        ListNode.of("2->6")
                                },
                                ListNode.of("1->1->2->3->4->4->5->6"))
                ));
    }

    @SuppressWarnings("deprecation")
    private static void validate(ListNode[] lists) {
        requireNonNull(lists, "\"lists\" cannot be null");
        for (int i = 0, length = lists.length; i < length; i++) {
            ListNode list = lists[i];
            if (list != null && !list.isSorted())
                throw new IllegalArgumentException(String.format("list %d is not sorted", i));
        }
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_MergeKLists(SolutionFactory sf, ListNode[] lists, ListNode expected) {

        validate(lists);

        ListNode actual = sf.create().mergeKLists(copy(lists));

        assertEquals(expected, actual);
    }
}