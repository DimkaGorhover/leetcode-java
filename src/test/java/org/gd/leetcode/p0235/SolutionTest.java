package org.gd.leetcode.p0235;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link Solution}
 *
 * @author Gorkhover D.
 * @since 2018-10-17
 */
@DisplayName("LeetCode #235: Lowest Common Ancestor of a Binary Search Tree")
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        2, 8, 6),
                Arguments.of(
                        TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
                        8, 2, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void test(TreeNode root, int v1, int v2, int expected) {

        final TreeNode left = new TreeNode(v1);
        final TreeNode right = new TreeNode(v2);
        int actual = new Solution().lowestCommonAncestor(root, left, right).val;

        assertEquals(expected, actual);
    }
}
