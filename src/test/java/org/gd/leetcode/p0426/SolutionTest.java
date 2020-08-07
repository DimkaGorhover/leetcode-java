package org.gd.leetcode.p0426;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover Dmytro
 * @since 2020-08-07
 */
@DisplayName("LeetCode #426: Convert Binary Search Tree to Sorted Doubly Linked List")
@Timeout(value = 30, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Arguments testCase(TreeNode root) {

        @SuppressWarnings("deprecation")
        int[] values = TreeNode.values(root);

        Arrays.sort(values);

        return Arguments.of(root, Node.of(values));
    }

    private static Stream<Arguments> args() {

        TreeNode tree001 = TreeNode.builder(8)
                .left(TreeNode.builder(3)
                        .left(TreeNode.builder(1))
                        .right(TreeNode.builder(6)
                                .left(4)
                                .right(7)))
                .right(TreeNode.builder(10)
                        .right(TreeNode.builder(14)
                                .left(13)))
                .build();

        return Stream.of(
                testCase(tree001)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("ToDoublyLinkedList")
    void test_ToDoublyLinkedList(TreeNode root, Node expected) {

        expected = Node.getHead(expected);

        Node actual = new Solution().toDoublyLinkedList(root);
        actual = Node.getHead(actual);

        assertEquals(expected, actual);
    }
}