package org.gd.leetcode.p0236;

import org.gd.leetcode.common.TreeNode;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link Solution}
 *
 * @author Horkhover D.
 * @since 2020-07-16.07.2020
 */
class SolutionTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(TreeNode.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), 5, 1, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("LowestCommonAncestor")
    void test_LowestCommonAncestor(TreeNode root, int v0, int v1, int expected) {
        Solution s = new Solution();
        int actual = s.lowestCommonAncestor(root, TreeNode.of(v0), TreeNode.of(v1)).val;
        assertEquals(expected, actual);
    }
}