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
 * Test for {@link ReverseDoublyLinkedList}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-04
 */
@DisplayName("HackerRank: Reverse a doubly linked list")
class ReverseDoublyLinkedListTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(DoublyLinkedListNode.of(1, 2, 3, 4, 5), List.of(5,4,3,2,1))
        );
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Reverse")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Reverse(DoublyLinkedListNode head, List<Integer> expected) {
        assertEquals(expected, ReverseDoublyLinkedList.reverse(head).toList());
    }
}
