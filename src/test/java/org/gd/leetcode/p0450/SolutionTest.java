package org.gd.leetcode.p0450;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        (Supplier<TreeNode>) () -> TreeNode.of(5, 3, 6, 2, 4, null, 7),
                        3,
                        TreeNode.of(5, 4, 6, 2, null, null, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LeetCode #450: Delete Node in a BST")
    void deleteNode(Supplier<TreeNode> input, int key, TreeNode expected) {

        TreeNode root = input.get();

        TreeNode result = new Solution().deleteNode(root, key);

        assertSame(result, root);

        assertEquals(expected, result, () -> {
            String a1 = String.format("   input: %s%n", input.get());
            String a2 = String.format("  actual: %s%n", root);
            String a3 = String.format("expected: %s%n", expected);
            return String.format("%n%n%s%s%s%n", a1, a2, a3);
        });
    }
}