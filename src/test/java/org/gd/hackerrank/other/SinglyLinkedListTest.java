package org.gd.hackerrank.other;

import lombok.Value;
import org.gd.hackerrank.other.SinglyLinkedList.SinglyLinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        SinglyLinkedListNode.of(16, 13, 7),
                        InsertEntry.builder()
                                .position(2)
                                .data(1)
                                .build(),
                        SinglyLinkedListNode.of(16, 13, 1, 7)
                ),
                Arguments.of(
                        SinglyLinkedListNode.of(16, 13, 7),
                        InsertEntry.builder()
                                .position(0)
                                .data(100)
                                .build(),
                        SinglyLinkedListNode.of(100, 16, 13, 7)
                ),
                Arguments.of(
                        SinglyLinkedListNode.of(16, 13, 7),
                        InsertEntry.builder()
                                .position(1)
                                .data(100)
                                .build(),
                        SinglyLinkedListNode.of(16, 100, 13, 7)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void insertNodeAtPosition(SinglyLinkedListNode head,
                              InsertEntry insertEntry,
                              SinglyLinkedListNode expected) {

        var actual = SinglyLinkedList.insertNodeAtPosition(head, insertEntry.data, insertEntry.position);

        assertEquals(actual, expected);
    }

    @Value
    @lombok.Builder(builderClassName = "Builder", toBuilder = true)
    static class InsertEntry {

        int position;
        int data;
    }
}