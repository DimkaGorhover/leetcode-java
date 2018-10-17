package org.gd.leetcode.p0235;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Gorkhover D.
 * @since 2018-10-17
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.arguments(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 2, 8, 6)
        );
    }

    private static TreeNode toTreeNode(Integer[] integers, int pos) {
        Integer integer;
        return integers == null || pos < 0 || pos >= integers.length || (integer = integers[pos]) == null ? null : new TreeNode(integer);
    }

    private static TreeNode toTreeNode(Integer[] integers) {
        final TreeNode head  = new TreeNode(integers[0]);
        List<TreeNode> nodes = Collections.singletonList(head);
        int            i     = 1;
        TreeNode       tmp;
        while (i < integers.length && !nodes.isEmpty()) {
            final ArrayList<TreeNode> newNodes = new ArrayList<>();
            for (TreeNode node : nodes) {
                node.left = tmp = toTreeNode(integers, i++);
                newNodes.add(tmp);
                node.right = tmp = toTreeNode(integers, i++);
                newNodes.add(tmp);
            }
            nodes = newNodes;
        }

        return head;
    }

    @ParameterizedTest
    @MethodSource("args")
    void lowestCommonAncestor(Integer[] integers, int v1, int v2, int expected) {
        final Solution s    = new Solution();
        final TreeNode n1   = new TreeNode(v1);
        final TreeNode n2   = new TreeNode(v2);
        final TreeNode root = toTreeNode(integers);
        assertEquals(expected, s.lowestCommonAncestor(root, n1, n2).val);
    }
}