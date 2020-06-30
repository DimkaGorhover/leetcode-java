package org.gd.leetcode.p0235;

import org.gd.leetcode.common.TreeNode;
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
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5}, 2, 8, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    void lowestCommonAncestor(Integer[] integers, int v1, int v2, int expected) {
        
        final TreeNode n1   = new TreeNode(v1);
        final TreeNode n2   = new TreeNode(v2);
        final TreeNode root = TreeNode.of(integers);

        assertEquals(expected, new Solution().lowestCommonAncestor(root, n1, n2).val);
    }
}
