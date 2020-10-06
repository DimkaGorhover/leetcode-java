package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.DoublyLinkedListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link InsertingNodeSortedDoublyLinkedList}
 *
 * @author Horkhover Dmytro
 * @since 2020-10-06
 */
@DisplayName("Test for org.gd.hackerrank.datastruct.InsertingNodeSortedDoublyLinkedList")
class InsertingNodeSortedDoublyLinkedListTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(DoublyLinkedListNode.of(1, 2, 3, 4), 5, List.of(1, 2, 3, 4, 5)),
                Arguments.of(DoublyLinkedListNode.of(1, 2, 4, 5), 3, List.of(1, 2, 3, 4, 5)),
                Arguments.of(DoublyLinkedListNode.of(2, 3, 4, 5), 1, List.of(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SortedInsert")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_SortedInsert(DoublyLinkedListNode head, int data, List<Integer> expected) {
        assertEquals(
                expected,
                InsertingNodeSortedDoublyLinkedList.sortedInsert(head, data).toList()
        );
    }
}
