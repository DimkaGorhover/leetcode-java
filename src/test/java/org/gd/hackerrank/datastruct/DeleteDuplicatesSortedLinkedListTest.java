package org.gd.hackerrank.datastruct;

import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link DeleteDuplicatesSortedLinkedList}
 *
 * @author Horkhover Dmytro
 * @since 2020-09-21
 */
@DisplayName("HackerRank: Delete duplicate-value nodes from a sorted linked list")
class DeleteDuplicatesSortedLinkedListTest {

    @Nonnull
    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(SinglyLinkedListNode.of(1, 1, 2, 2, 3, 3, 3), List.of(1, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("Remove Duplicates")
    void removeDuplicates(SinglyLinkedListNode head, List<Integer> expected) {
        head = DeleteDuplicatesSortedLinkedList.removeDuplicates(head);
        assertEquals(expected, head.toList());
    }
}
