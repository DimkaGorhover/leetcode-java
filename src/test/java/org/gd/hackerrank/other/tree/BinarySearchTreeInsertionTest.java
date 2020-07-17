package org.gd.hackerrank.other.tree;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link BinarySearchTreeInsertion}
 *
 * @author Horkhover D.
 * @since 2020-07-17.07.2020
 */
class BinarySearchTreeInsertionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(Node.of("4 2 7 1 3"), 6, Node.of("4 2 7 1 3 6"))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Insert")
    void test_Insert(Node root, int input, Node expected) {
        assertEquals(expected, BinarySearchTreeInsertion.insert(root, input));
    }
}