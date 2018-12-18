package org.gd.leetcode.p0814;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution};
 *
 * @author Horkhover Dmytro
 * @since 2018-12-18
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(
                        TreeNode.of(1, null, 0, 0, 1),
                        TreeNode.of(1, null, 0, null, 1)),
                arguments(
                        TreeNode.of(1, 0, 1, 0, 0, 0, 1),
                        TreeNode.of(1, null, 1, null, 1)),
                arguments(
                        TreeNode.of(1, 1, 0, 1, 1, 0, 1, 0),
                        TreeNode.of(1, 1, 0, 1, 1, null, 1)),

                arguments(
                        TreeNode.of(0, 1, 1, null, 1, 1, 0, 0, 1, null, 1, 1, null, null, null, null, null, null, null, null, null),
                        TreeNode.of(0, 1, 1, null, 1, 1, 0, null, 1, null, 1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("PruneTree")
    void test_PruneTree(TreeNode root, TreeNode expected) {
        assertEquals(expected, new Solution().pruneTree(root));
    }
}