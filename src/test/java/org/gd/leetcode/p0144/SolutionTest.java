package org.gd.leetcode.p0144;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * Test for {@link Solution}
 *
 * @author Gorkhover D.
 * @since 2018-10-23
 */
@DisplayName("LeetCode #144: Binary Tree Preorder Traversal")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(TreeNode.of(1, null, 2, 3), List.of(1, 2, 3)),
                arguments(TreeNode.of(1, 4, 3, 2), List.of(1, 4, 2, 3))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void preorderTraversal(TreeNode input, List<Integer> expected) {
        assertEquals(expected, new Solution().preorderTraversal(input));
    }
}
