package org.gd.hackerrank.other;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class FindMergePointTwoLinkedListsTest {

    static Stream<Arguments> args() {
        return Stream.of(
            Arguments.of(
                SinglyLinkedListNode.of(4, 5, 6, 2, 1),
                SinglyLinkedListNode.of(8, 7, 6, 2, 1),
                6
            )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Find Merge Point Two Linked Lists")
    void test(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int expected) {

        assertEquals(
            expected, 
            FindMergePointTwoLinkedLists.findMergeNode(head1, head2));
    }
}