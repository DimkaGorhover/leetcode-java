package org.gd.hackerrank.other;

import java.util.stream.Stream;

import org.gd.hackerrank.other.IsThisBinarySearchTree.Node;
import org.gd.leetcode.common.BooleanAssertion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Test for {@link IsThisBinarySearchTree}
 */
class IsThisBinarySearchTreeTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                // Arguments.of(new Integer[]{4, 2, 6, 1, 3, 5, 7}, true),
                Arguments.of(new Integer[]{4, 2, 6, 1, 3, 5, 6}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("Is This a Binary Search Tree")
    void test(Integer[] input, boolean expected) {
        Node root = Node.of(input);
        boolean actual = new IsThisBinarySearchTree().checkBST(root);
        BooleanAssertion.of(expected).doAssert(actual);
    }
}