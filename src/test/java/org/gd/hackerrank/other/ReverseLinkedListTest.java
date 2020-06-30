package org.gd.hackerrank.other;

import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(SinglyLinkedListNode.of(1), SinglyLinkedListNode.of(1)),
                Arguments.of(SinglyLinkedListNode.of(1, 2, 3, 4), SinglyLinkedListNode.of(4, 3, 2, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("HackerRank: Reverse Linked List")
    void reverse(SinglyLinkedListNode head, SinglyLinkedListNode expected) {
        assertEquals(expected, ReverseLinkedList.reverse(head));
    }
}