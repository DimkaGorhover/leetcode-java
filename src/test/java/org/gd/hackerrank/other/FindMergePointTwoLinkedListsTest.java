package org.gd.hackerrank.other;

import org.gd.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HackerRank: Find Merge Point of Two Lists")
class FindMergePointTwoLinkedListsTest {

    static Stream<Arguments> args() {
        //noinspection TrivialFunctionalExpressionUsage
        return Stream.of(

                ((Supplier<Arguments>) () -> {
                    var tail = SinglyLinkedListNode.of(2, 3);
                    return Arguments.of(
                            SinglyLinkedListNode.of(1).concat(tail),
                            SinglyLinkedListNode.of(1).concat(tail),
                            2);
                }).get(),

                ((Supplier<Arguments>) () -> {
                    var tail = SinglyLinkedListNode.of(6, 2, 1);
                    return Arguments.of(
                            SinglyLinkedListNode.of(4, 5).concat(tail),
                            SinglyLinkedListNode.of(8, 7).concat(tail),
                            6);
                }).get()
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Find Merge Point Two Linked Lists")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test(SinglyLinkedListNode head1, SinglyLinkedListNode head2, int expected) {

        assertEquals(
                expected,
                FindMergePointTwoLinkedLists.findMergeNode(head1, head2));
    }
}