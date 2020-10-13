package org.gd.leetcode.p0450;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 */
@DisplayName("LeetCode #450: Delete Node in a BST")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(

                Arguments.of(
                        TreeNode.of(5, 3, 6, 2, 4, null, 7),
                        3,
                        TreeNode.of(5, 4, 6, 2, null, null, 7))
        );
    }

    @SuppressWarnings("deprecation")
    @ParameterizedTest
    @MethodSource("args")
    void deleteNode(TreeNode input, int key, TreeNode expected) {

        TreeNode before = input.copy();

        TreeNode result = new Solution().deleteNode(input, key);

        assertEquals(expected, result, () -> {
            String a1 = String.format("   input: %s%n", before);
            String a2 = String.format("  actual: %s%n", result);
            String a3 = String.format("expected: %s%n", expected);
            return String.format("%n%n%s%s%s%n", a1, a2, a3);
        });
    }
}
