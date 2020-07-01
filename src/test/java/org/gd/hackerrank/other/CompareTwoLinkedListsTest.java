package org.gd.hackerrank.other;

import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link CompareTwoLinkedLists}
 *
 * @author Horkhover D.
 * @since 2020-07-01.07.2020
 */
@DisplayName("HackerRank: Compare two linked lists")
class CompareTwoLinkedListsTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        SinglyLinkedListNode.of(1, 2, 3, 4),
                        SinglyLinkedListNode.of(1, 2, 3, 4),
                        true),
                Arguments.of(
                        SinglyLinkedListNode.of(1, 2, 3, 4),
                        SinglyLinkedListNode.of(1, 2, 3, 5),
                        false),
                Arguments.of(
                        SinglyLinkedListNode.of(1, 2, 3, 4),
                        SinglyLinkedListNode.of(1, 2, 3),
                        false),
                Arguments.of(
                        SinglyLinkedListNode.of(1, 2, 3, 4),
                        SinglyLinkedListNode.of(0, 2, 3, 4, 5),
                        false),
                Arguments.of(null, SinglyLinkedListNode.of(0, 2, 3, 4, 5), false),
                Arguments.of(null, null, true)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("CompareLists")
    void test_CompareLists(SinglyLinkedListNode head1,
                           SinglyLinkedListNode head2,
                           boolean expected) {
        boolean actual = CompareTwoLinkedLists.compareLists(head1, head2);
        assertEquals(expected, actual);
    }
}